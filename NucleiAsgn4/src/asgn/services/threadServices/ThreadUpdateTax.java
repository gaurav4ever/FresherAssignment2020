package asgn.services.threadServices;

public class ThreadUpdateTax implements Runnable {

	DBOperations dbOperations;

	public ThreadUpdateTax(DBOperations dbOperations) {
		this.dbOperations = dbOperations;
	}

	@Override
	public void run() {
		try {
			dbOperations.calculateTax();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Error in updating tax");
		}
	}

}
