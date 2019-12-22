package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import question4.items;
import question4.sqlConnection;

class sqlConnectionTest {
	/* Testing if Data from Database is correctly read */
	
ArrayList<items> ItemsinDB = new ArrayList<>();
	@Test
	void test() {
		
		try {
		    sqlConnection.create();
		}catch (ClassNotFoundException e1) {
		    System.out.println("Class Not Found");
		}

		String sql = "SELECT * FROM items";
	        String url = "jdbc:sqlite:C:/sqlite/"+"abc.db";
	        
	        try {  
	            Connection conn = DriverManager.getConnection(url); 
	            Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);  
	              
	            // loop through the result set  
	          while (rs.next()) {
	               items item1= new items(rs.getString("Name"),rs.getInt("Quantity"), rs.getFloat("Price"), rs.getString("Type")); 
	               ItemsinDB.add(item1);
	            }
	             
	         }catch (SQLException e) {  
	            System.out.println("SQL Exception");
	         }
	        
	        /*
	        ("iphone", 1, 12000, "raw")
			("Back Case", 2, 249, "manufactured")
			("one plus", 2, 37000, "imported")
			("Acer", 1, 63000, "raw")
			("Dell", 2, 70000, "imported")
			
			*/
	         ArrayList<String> name = new ArrayList<>(Arrays.asList("iphone"," Back Case","one plus","Acer","Dell"));
	         ArrayList<Integer> quantity = new ArrayList<>(Arrays.asList(1,2,2,1,2));
	         ArrayList<Float> price = new ArrayList<>(Arrays.asList(12000f,249f,37000f,63000f,70000f));
	         ArrayList<String>type = new ArrayList<>(Arrays.asList("raw","manufactured","imported","raw","imported"));
	        
	        
	         for(int i=0;i<5;i++)
	         {
	        	assertEquals(name.get(i),ItemsinDB.get(i).getName());
	        	assertEquals(quantity.get(i),ItemsinDB.get(i).getQuantity());
	        	assertEquals(price.get(i),ItemsinDB.get(i).getPrice());
	        	assertEquals(type.get(i),ItemsinDB.get(i).getType());
	         }
	        
	     }
}


