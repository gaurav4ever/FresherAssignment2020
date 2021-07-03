/*
 * Created by Manu KJ 
 */
package Assignment4;

public class ThreadUpdateTax implements Runnable {

	ThreadFunctions threadFunctions;

	public ThreadUpdateTax(ThreadFunctions threadFunctions) {
		this.threadFunctions = threadFunctions;
	}

	@Override
	public void run() {

		// read the data till the last row
		while (threadFunctions.totalRow > threadFunctions.visitedRow) {

			try {
				threadFunctions.updateTax();
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		System.out.println("UpdateTax Thread Finished");
	}
}
