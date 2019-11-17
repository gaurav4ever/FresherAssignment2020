/*
 * Created by Manu KJ 
 */
package Assignment4;

import java.sql.ResultSet;

public class Assignment4 {
	public static void main(String[] args) {

		// first get the database connectivity
		DataBase dataBase = new DataBase();
		dataBase.connectToDatabase();
		int totalRow = dataBase.getTotalRow();
		ResultSet resultSet = dataBase.getResultSet();

		// Initialize the ThreadFunctions object
		ThreadFunctions threadFunctions = new ThreadFunctions(totalRow, resultSet);

		// now create the 2 Thread one with ReadData and UpdateTax
		Runnable readDataJob = new ThreadReadData(threadFunctions);
		Thread t_readData = new Thread(readDataJob);

		Runnable updateTaxJob = new ThreadUpdateTax(threadFunctions);
		Thread t_updateTax = new Thread(updateTaxJob);

		// start both the thread
		t_readData.start();
		t_updateTax.start();

		// wait for both the thread to complete
		try {
			t_readData.join();
			t_updateTax.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("both the thread finished");
		for (Items i : threadFunctions.items) {
			i.display_iteam_info();
		}
	}
}
