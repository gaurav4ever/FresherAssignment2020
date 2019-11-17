package com.assignment4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

class FetchData implements Runnable{
	//FetchData f = new FetchData();
	Connection con;
	Statement stmt;
	String sql;
	ArrayList<Item> items = new ArrayList<Item>();
	ResultSet rs;
	public void fetchData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			this.con=DriverManager.getConnection( "jdbc:mysql://localhost:3309/inventory?useSSL=false","root","root");
			System.out.println("Connection Established!!");
			this.sql = "Select * from itemDetails";
			this.stmt=con.createStatement();  	
			this.rs=this.stmt.executeQuery(this.sql);
			//System.out.println(this.rs.hashCode());
			
			while((this.rs).next()) {
			
				Item item = new Item();
				item.setId((this.rs).getInt("item_id"));		 
				item.setItemName((this.rs).getString("item_name"));
				item.setItemPrice((this.rs).getDouble("item_price"));
				item.setItemType((this.rs).getString("item_type"));
				item.setFinalPrice((this.rs).getDouble("final_price"));
				items.add(item);
		}
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		
	}
	public void run() {
		this.fetchData();
//		System.out.println(items);
	}
}
class CloseConnection  {
	Connection con;
	public void closeConnection() {
	try {
	con.close();
	}
	catch(Exception e){ 
		System.out.println(e);
		}
}
}
class Calculate implements Runnable{
	//Calculate c = new Calculate();
//	FetchData f = new FetchData();
	ArrayList<Item> itemList;
	Connection con;
	public void output(Item item){
		
		String type = item.getItemType();
		double tax;
		switch(type) {
			case "raw" :
				tax = item.getItemPrice() * (12.5/100);
				item.setFinalPrice(tax + item.getItemPrice());
				break;
			case "manufactured":
				double taxInitial1;
				taxInitial1 = item.getItemPrice() * 12.5/100;
				tax = taxInitial1 + (taxInitial1 + item.getItemPrice()) * 2/100;
				item.setFinalPrice(tax + item.getItemPrice());
				break;
			case "imported":
				double taxInitial;
				taxInitial = item.getItemPrice() * 10/100;
				if(taxInitial + item.getItemPrice() <= 100)
					tax =taxInitial +  5;
				else if(taxInitial + item.getItemPrice()<= 200)
					tax =taxInitial + 10;
				else
					tax = taxInitial +  (taxInitial + item.getItemPrice()) * 5/100;
				item.setFinalPrice(tax + item.getItemPrice());
				break;
		}
		
	}
	public void calculate() {
		try {
		for(Item item : this.itemList) {
			//System.out.println("hello");
			this.output(item);
			String query = "update itemDetails set final_price = ? where item_name = ?";
		      PreparedStatement preparedStmt = (this.con).prepareStatement(query);
		      preparedStmt.setDouble  (1, item.getFinalPrice());
		      preparedStmt.setString(2,item.getItemName());
		      preparedStmt.executeUpdate();
		}
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		
	}
	public void run() {
		//System.out.println((f.items).size());
		this.calculate();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class DatabaseConnection {
	public static void main(String[] args) {
		
		//DConnection dc = new DConnection();
		FetchData fd = new FetchData();
		Calculate c = new Calculate();
		CloseConnection cc = new CloseConnection();
		
		Thread t1 = new Thread(fd);
		Thread t2 = new Thread(c);
		
		try {
			   // First thread
			   t1.start();
			   t1.join();
			   
			   
			   c.con = fd.con;
			   c.itemList=fd.items;
			   // Second thread
			   t2.start();
			   t2.join();
			   cc.con = fd.con;
			   System.out.println(fd.items);
			  } 
		catch (InterruptedException e) {
			   e.printStackTrace();
			  }
		cc.closeConnection();
	}
}

		