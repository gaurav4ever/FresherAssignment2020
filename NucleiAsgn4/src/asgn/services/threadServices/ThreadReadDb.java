package asgn.services.threadServices;

public class ThreadReadDb implements Runnable {

	DBOperations dbOperations;

	public ThreadReadDb(DBOperations dbOperations) {
		this.dbOperations = dbOperations;
	}

	@Override
	public void run() {
		try {
			dbOperations.readData();
		} catch (Exception e) {
			System.out.println("Error in reading data!");
		}
	}
}
