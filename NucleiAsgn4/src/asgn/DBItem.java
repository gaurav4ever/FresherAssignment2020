package asgn;

import asgn.model.Item;
import asgn.services.threadServices.DBOperations;
import asgn.services.threadServices.ThreadReadDb;
import asgn.services.threadServices.ThreadUpdateTax;
import asgn.util.OutputUtil;

public class DBItem {

	public static void main(String[] args) {
		DBOperations dbOperation = new DBOperations();

		// create read thread
		Thread readDb = new Thread(new ThreadReadDb(dbOperation));
		// create update tax thread
		Thread updateTax = new Thread(new ThreadUpdateTax(dbOperation));

		//start both the threads
		try {
			readDb.start();
			updateTax.start();

			readDb.join();
			updateTax.join();
		} catch (InterruptedException e) {
			System.out.println("Error in starting threads!");
		}

		System.out.println("Display data :\n");
		// display output with calculated tax of the item
		for (Item i : dbOperation.getListItems()) {
			OutputUtil.printOutput(i);
		}

	}

}