/*
 * Created by Manu KJ 
 */
package Assignment4;

public class ThreadReadData implements Runnable {

	ThreadFunctions threadFunctions;

	public ThreadReadData(ThreadFunctions threadFunctions) {
		this.threadFunctions = threadFunctions;
	}

	@Override
	public void run() {

		// read the data till the last row
		while (threadFunctions.totalRow - 1 > threadFunctions.visitedRow) {

			try {
				threadFunctions.readData();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("ReadData Thread Finished");
	}
}
