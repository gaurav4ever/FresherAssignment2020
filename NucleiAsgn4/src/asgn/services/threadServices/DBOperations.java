package asgn.services.threadServices;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import asgn.model.Item;
import asgn.services.taxServices.CalculateTaxes;
import asgn.services.taxServices.TaxObject;
import asgn.util.Constants;
import asgn.util.DBConnection;

public class DBOperations {

	List<Item> listItems = new ArrayList<>();
	int rowsVisited = 0;

	public synchronized void readData() throws Exception {

		// establish database connection and get resultset object
		DBConnection database = new DBConnection();
		ResultSet rs = database.getConnection();

		// total number of rows in table
		int size = database.getTotalRows();

		while (listItems.size() != size) {
			if (rs.next()) {
				// set items object in a list
				Item item = new Item(rs.getString(Constants.name), rs.getDouble(Constants.price),
						rs.getInt(Constants.quantity), rs.getInt(Constants.type));
				listItems.add(item);
			}
			notify();
		}
	}

	public synchronized void calculateTax() throws Exception {
		while (listItems.size() != rowsVisited) {

			while (listItems.size() == 0) {
				wait();
			}

			TaxObject taxFactory = new TaxObject();
			Item item = listItems.get(rowsVisited);

			// Calculate tax for each item in the collection
			CalculateTaxes calculateTaxesObject = taxFactory.getTax(listItems.get(rowsVisited).getType());
			double tax = calculateTaxesObject.calculateTax(listItems.get(rowsVisited).getPrice());

			// set tax to item object
			item.setTax(tax);
			rowsVisited++;
			notify();
		}
	}

	// get list of items with calculated tax
	public List<Item> getListItems() {
		return listItems;
	}

}
