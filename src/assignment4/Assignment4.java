package assignment4;

import java.util.ArrayList;
import java.util.HashMap;

import assignment1.Item;
import java.sql.*;
public class Assignment4 {
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static HashMap<Item,Float> itemsUpdated = new HashMap<Item,Float>();
	static int itemsRead = 0;
	static int itemsUpdatedCount = 0;
	static int totalRows = 0;
	
	public static void main(String[] args) {
		DatabaseConnection dc = DatabaseConnection.DatabaseConnection();
		dc.connectToDatabase();
		ResultSet resultSet = dc.getResultset();
		try {
			resultSet.last();
			totalRows = resultSet.getRow();
			resultSet.beforeFirst();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		Thread readItemThread = new Thread(new ReadItemThread(resultSet,totalRows));
		Thread calculateTaxThread = new Thread(new CalculateTaxThread(totalRows));
		readItemThread.start();
		calculateTaxThread.start();
		try {
			readItemThread.join();
			calculateTaxThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(HashMap.Entry<Item,Float> entry: itemsUpdated.entrySet()) {
			Item i = entry.getKey();
			System.out.println("Name: "+i.getItemName()+" Type: "+i.getItemPrice()+" Price: "+i.getItemPrice()+" Sales Tax: "+entry.getValue());
		}
		dc.closeConnection();
	}
}
