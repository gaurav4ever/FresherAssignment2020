

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
	 private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet resultSet = null;

	  public List<Item> items = new ArrayList<Item>();
	  public void readDataBase() throws Exception {
		  try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");  
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Items","root","nuclei@123");  
	    	Statement stmt=con.createStatement();  
	    	resultSet = stmt.executeQuery("select * from Item");
	    	writeResultSet(resultSet);
	      
	    } catch (Exception e) {
	      throw e;
	    } finally {
	      close();
	    }

	  }


	  private void writeResultSet(ResultSet resultSet) throws SQLException {
	    while (resultSet.next()) {
	    	//items.add(e)
	    	Item item=new Item();
	      String itemname = resultSet.getString("itemname");
	      item.setName(resultSet.getString("itemname"));
	      float price = resultSet.getFloat("price");
	      item.setPrice(price);
	      int quantity = resultSet.getInt("quantity");
	      item.setQuantity(quantity);
	      String type = resultSet.getString("type");
	      item.setType(type);
	      Main.items.add(item);
	      System.out.println(itemname+"  "+price+"  "+quantity+"  "+type);
	    }
	    System.out.println(Main.items);
	  }

	  // You need to close the resultSet
	  private void close() {
	    try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }
	  
	  

}

