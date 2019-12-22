package question4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sqlConnection {
	
	/** Items is a Shared Variable */
	private static ArrayList<items> Items = new ArrayList<>();
	public static ArrayList<items> finalPricedItems = new ArrayList<>();
	public static ArrayList<items> ItemsRead= new ArrayList<>();
	private static boolean stopCalculation=true;
	
	public static void create() throws ClassNotFoundException
	{
		String url = "jdbc:sqlite:C:/sqlite/"+"abc.db";
		Class.forName("org.sqlite.JDBC");
		try {
			Connection conn = DriverManager.getConnection(url);
			if(conn!=null)
			{
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The Driver Name is  "+ meta.getDriverName());
				System.out.println("A new Database is Created");
			}
		}
		catch(SQLException e) {
			System.out.println("SQL Exception while Creating Connection");
		}
		
	}
	
	public void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C:/sqlite/"+"abc.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS items (Name text PRIMARY KEY,Quantity integer,Price real,Type text);";
              
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
            System.out.println("Table Created");
        } catch (SQLException e) {  
            System.out.println("SQL Exception in Creating Table");  
        }  
		
      }
	
	public void insert(String name, int quantity, float price, String type) { 
		
        String sql = "INSERT INTO items(Name, Quantity, Price, Type) VALUES(?,?,?,?)";  
        String url = "jdbc:sqlite:C:/sqlite/"+"abc.db";
        try{  
            Connection conn =   DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name);  
            pstmt.setInt(2, quantity);
            pstmt.setFloat(3, price);
            pstmt.setString(4, type);
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println("SQL Exception while Inserting in Database");  
        }  
    }
	
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
		 
		 while(stopCalculation || Items.size()!=0)
		 {
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
