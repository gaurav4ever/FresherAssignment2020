package question4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RetrievalAndComputation {
	
	/** Items is a Shared Variable */
	private static ArrayList<items> Items = new ArrayList<>();
	public static ArrayList<items> finalPricedItems = new ArrayList<>();
	private static boolean stopCalculation=true;
	
	 public void select() throws InterruptedException{  
	        String sql = "SELECT * FROM items";
	        String url = "jdbc:sqlite:C:/sqlite/"+"abc.db";
	        
	        int maxCapacity=3;
	        try {  
	            Connection conn = DriverManager.getConnection(url); 
	            Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);  
	              
	            // loop through the result set  
	             while (rs.next()) {  
	               synchronized(this)
	                {
         		       if(Items.size()==maxCapacity)
	            		 wait();
	            	
	                    items item1= new items(rs.getString("Name"),rs.getInt("Quantity"), rs.getFloat("Price"), rs.getString("Type")); 
	                    Items.add(item1);
	                
	                    System.out.println("Item Added");
	                    notify();
	                
	                    Thread.sleep(1000);
	            	}
	            }  
	        } catch (SQLException e) {  
	            System.out.println("SQL Exception while Reading from Database");
	            stopCalculation=false;
	        }
	        
	        stopCalculation=false;
	    }
	 
	 public void CalculateTaxAndUpdatePrice() throws InterruptedException
	 {
		 
		 while(stopCalculation || Items.size()!=0) {
		      synchronized (this) 
	             { 
	             // consumer thread waits while list 
	             // is empty 
	             while (Items.size() == 0) 
	                 wait(); 
	
	             items i1= new items();
	             items item = (items) Items.get(0);
	             float tax = i1.calculateTax(item.getPrice(), item.getType());
	             
	             items itemfinal = new items(item.getName(),item.getQuantity(),((item.getPrice()+tax)*item.getQuantity()),item.getType());
	             
	             finalPricedItems.add(itemfinal);
	             Items.remove(0);
	             System.out.println("Item Retrieved");
	             // Wake up producer thread 
	             notify(); 
	
	             // and sleep 
	             Thread.sleep(1000); 
	            } 
		 }
		 
	 }

}
