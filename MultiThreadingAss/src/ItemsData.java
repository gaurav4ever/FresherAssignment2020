
public class ItemsData implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread from Database is running");
		DatabaseConnection dao=new DatabaseConnection();
		try {
			dao.readDataBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
