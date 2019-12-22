package question4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sqlOperationClass {
	
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
	
	
}
