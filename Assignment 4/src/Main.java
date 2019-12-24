import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Item> items = new ArrayList<Item>();
    public static Thread thread1;

    public static void main(String args[]) {

        ItemsData itemsData = new ItemsData();
        CalculateTax calculateTax = new CalculateTax();
        thread1 = new Thread(itemsData);
        Thread thread2 = new Thread(calculateTax);
        thread1.setPriority(10);
        thread2.setPriority(5);
        thread1.start();
        thread2.start();
    }
}
