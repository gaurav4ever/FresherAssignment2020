


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class connectionClass {
	
	/** Items is a Shared Variable */
	private static ArrayList<Items> Items = new ArrayList<>();
	public static ArrayList<Items> finalPricedItems = new ArrayList<>();
	public static ArrayList<Items> ItemsRead= new ArrayList<>();
	private static boolean stopCalculation=true;
	
	public static void create() throws ClassNotFoundException
	{
		
		Class.forName("om.mysql.jdbc.Driver");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test","root","Sini@@17");
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
    
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS items (Name text PRIMARY KEY,Quantity integer,Price real,Type text);";
              
        try{  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test","root","root");  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
            System.out.println("Table Created");
         } catch (SQLException e) {  
            System.out.println("SQL Exception in Creating Table");  
         }  
       }
	
	public void insert(String name, int quantity, float price, String type) { 
		
        String sql = "INSERT INTO items(Name, Quantity, Price, Type) VALUES(?,?,?,?)";  
       
        try{  
            Connection conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test","root","root");
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