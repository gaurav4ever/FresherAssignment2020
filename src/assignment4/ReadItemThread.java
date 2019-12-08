package assignment4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import assignment1.Item;

public class ReadItemThread implements Runnable {
	ResultSet resultSet = null;
	int totalRows;
	public ReadItemThread(ResultSet resultSet,int totalRows) {
		this.resultSet = resultSet;
		this.totalRows=totalRows;
	}
	@Override
	public void run() {
		try {
			while(resultSet.next()) {
				synchronized(Assignment4.items) {
					HashMap<String,String> params = new HashMap<String,String>();
						params.put("name", resultSet.getString("Name"));
						params.put("type", resultSet.getString("Type"));
						params.put("quantity", ""+resultSet.getInt("Quantity"));
						params.put("price", ""+resultSet.getFloat("Price"));
						Item item = new Item(params);
						Assignment4.items.add(item);
						Assignment4.itemsRead+=1;
						if(Assignment4.itemsRead>Assignment4.itemsUpdatedCount) 
							Assignment4.items.notify();
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
