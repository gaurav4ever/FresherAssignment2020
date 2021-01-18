package Assignment4;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class Item {
	private String name;
	private double price;
	private int quantity;
	private String type;
	private double tax;
	private double final_price;
	public Item() {
		this.name="";
		this.price=0;
		this.quantity=0;
		this.type="";
		this.tax=0.0;
		this.final_price=0.0;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getName() {
		return this.name;
	}
	public double getPrice() {
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
		if("raw".equals(this.type)) {
			this.tax=0.125*this.price;
		
    	} else if("manufactured".equals(this.type)) {
			this.tax=0.125*this.price + (0.02*(this.price+0.125*this.price));
    	} else if("imported".equals(this.type)) {
    		this.tax=this.price*0.1;
            double surcharge=0.0;
            double total=this.price+this.tax;
            //calculating surcharge amount
            if(total<=100) {
           	 surcharge=5;
            }
            else if(total<=200) {
           	 surcharge=10;
            }
            else {
           	 surcharge=0.05*total;
            }
            this.tax=this.tax+surcharge;
    	}
		this.final_price=this.price+this.tax;
	}
}
class ConnectionConfiguration {
	private static Statement st;
	private static ResultSet rs;
	private static Connection connection =null;
	private static ArrayList<Item> itemlist=new ArrayList<Item>();
	public static Connection isConnected() {
		return connection;
	}

	public static ArrayList<Item> getConnection() {
		try {
			//obtaining connection to database through jdbc driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/items?serverTimezone=UTC";
			connection = DriverManager.getConnection(url, "root", "");
			st=connection.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			String query = "Select * from item";
			rs = st.executeQuery(query);
			while(rs.next()) {
				Item item = new Item();
				item.setName(rs.getString("item_name"));
				item.setPrice(rs.getDouble("price"));
				item.setQuantity(rs.getInt("quantity"));
				item.setType(rs.getString("type"));
				itemlist.add(item);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return itemlist;
	}
}

class SecondThread extends Thread {
	static List<Item> itemlist=new ArrayList<Item>();
	public SecondThread(List<Item> itemlist) {
		this.itemlist=itemlist;
	}
	// second thread to display item details after calculating tax
	@Override
	public void run() {
		synchronized(itemlist) {
			for(int i=0;i<itemlist.size();i++) {
				if(itemlist.get(i).getPrice()!=0) {
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
}

public class Assignment4 extends Thread {
    static  List<Item> itemlist = new ArrayList<Item>();
    public Assignment4(List<Item> itemlist) {
    	this.itemlist=itemlist;
    }
    @Override
    public void run() {
    	synchronized (itemlist) {
    		try {
    			itemlist=ConnectionConfiguration.getConnection();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		itemlist=Collections.synchronizedList(new ArrayList<Item>());
		//Creation of first thread to read item details from database
		Assignment4 thread1 = new Assignment4(itemlist);
		thread1.start();
		//second thread will wait for first thread to complete its execution and terminate
		thread1.join();
		//Creation of second thread to display the details
		SecondThread thread2 = new SecondThread(itemlist);
		thread2.start();
	}

}

