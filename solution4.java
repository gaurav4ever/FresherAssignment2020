package Question4;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class Item {
	private String name;
	private int price;
	private int quantity;
	private String type;
	private double tax;
	private double final_price;
	public Item(String name, int price, int quantity, String type) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.type=type;
		this.tax=0.0;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public String getType() {
		return this.type;
	}
	public double getTax() {
		return this.tax;
	}
	//method to calculate tax based on item type
	public void calculateTax() {
		if(this.price!=0) {
    		switch(this.type) {
    		case "raw": this.tax=0.125*this.price;
    		      break;
    		case  "manufactured": this.tax=0.125*this.price + (0.02*(this.price+0.125*this.price));
    		      break;
    		case "imported": this.tax=this.price*0.1;
    		                 double surcharge=0.0;
    		                 double final_price=this.price+this.tax;
    		                 if(final_price<=100) {
    		                	 surcharge=5;
    		                 }
    		                 else if(final_price<=200) {
    		                	 surcharge=10;
    		                 }
    		                 else {
    		                	 surcharge=0.05*final_price;
    		                 }
    		                 this.tax=this.tax+surcharge;
    		        break;
    	}
    		this.final_price= price+tax;
    	}
	}
}
class ConnectionSetting {
	private static Statement st;
	private static ResultSet rs;
	private static Connection cn=null;
	private static ArrayList<Item> itemlist=new ArrayList<Item>();
	public static Connection isConnected() {
		return cn;
	}
	//method for obtaining connection  to jdbc driver
	public static ArrayList<Item> getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/items?serverTimezone=UTC";
			cn = DriverManager.getConnection(url, "root", "");
			st=cn.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			String query = "Select * from item";
			rs = st.executeQuery(query);
			while(rs.next()) {
				String name=rs.getString("item_name");
				int price=rs.getInt("price");
				int quantity=rs.getInt("quantity");
				String type=rs.getString("type");
				Item itm = new Item(name,price,quantity,type);
				itemlist.add(itm);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return itemlist;
	}
}
// Thread2 to calculate tax and display item details
class Thread2 implements Runnable {
	static List<Item> itemlist=new ArrayList<Item>();
	public Thread2(List<Item> itemlist) {
		this.itemlist=itemlist;
	}
	@Override
	public void run() {
		synchronized(itemlist) {
			for(int i=0;i<itemlist.size();i++) {
				itemlist.get(i).calculateTax();
				System.out.println("Item "+(i+1)+" details:");
				System.out.println("Item name: "+itemlist.get(i).getName());
				System.out.println("Item price: "+itemlist.get(i).getPrice());
				System.out.println("Tax: "+itemlist.get(i).getTax());
				System.out.println("Final price: "+(itemlist.get(i).getTax()+itemlist.get(i).getPrice()));
				System.out.println("--------------------------------------------------------------");
			}
		}
	}
}

public class solution4 implements Runnable {
    static  List<Item> itemlist = new ArrayList<Item>();
    public solution4(List<Item> itemlist) {
    	this.itemlist=itemlist;
    }
    @Override
    public void run() {
    	synchronized (itemlist) {
    		try {
    			itemlist=ConnectionSetting.getConnection();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		itemlist=Collections.synchronizedList(new ArrayList<Item>());
		//Creation of first thread to read item details from database
		Thread t1=new Thread(new solution4(itemlist));
		t1.start();
		//Thread2 will wait for Thread1 to complete its execution and terminate
		t1.join();
		//Creation of second thread to display the details
		Thread t2=new Thread(new Thread2(itemlist));
		t2.start();
	}

}

