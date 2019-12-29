package source_Package;

import java.sql.*;
import java.util.Arrays;

//This Thread reads data from MySQL and updates an Arraylist called SQL_LIST with sql_objects
public class sql_reader extends Thread {
	
	@Override
	public void run()
	{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/world","root","root")) {
                
            	Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * from item_data");
                
                while(rs.next())
                {
                    start.sql_list_name = rs.getString(1);
                    start.sql_list_price = rs.getDouble(2);
                    start.sql_list_quantity = rs.getInt(3);
                    start.sql_list_type = rs.getString(4);
                    start.access_sql_list(1);
                }
                start.check1 = 0;
            }
         }
        catch(SQLException|ClassNotFoundException e)
        {
        	System.out.println("In Here");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
	}

}
