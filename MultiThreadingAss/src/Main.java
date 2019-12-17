import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<Item> items = new ArrayList<Item>();
	public static Thread thread1;
	public static void main(String args[]) {
	
		ItemsData obj1 = new ItemsData();
		CalculateTax obj2 = new CalculateTax();
	    thread1 = new Thread(obj1);
		Thread thread2 = new Thread(obj2);
		thread1.setPriority(10);
		thread2.setPriority(5);
		thread1.start();
		thread2.start();	
	
		
		
	}
}
