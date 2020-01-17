import java.util.*;
import models.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Enter the item details ");
        Boolean flag = true;
        ItemCollection items = new ItemCollection();

        while (true) {
            System.out.print(" -name : ");
            String name = sc.next();
            if (name == null || name.isEmpty()) {
                System.out.println("name shouldn't be null or empty");
                continue;
            }
            String type = "";
            Double price = 0.0;
            int quantity = 0;
            for (int i = 0; i < 3; i++) {
                String s = sc.next();
                if (s.equals("-price")) {
                    price = sc.nextDouble();
                } else if (s.equals("-quantity")) {
                    quantity = sc.nextInt();
                } else if (s.equals("-type")) {
                    type = sc.next();
                } else {
                    System.out.println("Wrong input");
                    i--;
                }
            }

            try {
                Item item = null;
                if ("raw".equals(type)) {
                    item = new RawItem(name, price, quantity);
                } else if ("manufactured".equals(type)) {
                    item = new ManufacturedItem(name, price, quantity);
                } else if ("imported".equals(type)) {
                    item = new ImportedItem(name, price, quantity);
                } else {
                    System.out.println("type is mandatory and should be either raw/manufactured/imported");
                    continue;
                }
                items.addItem(item);
                System.out.println("done : item added");
            } catch (Exception e) {
                System.out.println(" failed : item is not added ");
                e.printStackTrace();
            }
            System.out.print("Do you want to add more items? (y/n)");
            String choice = sc.next();
            if (choice.equals("n")) {
                break;
            }
        }
        items.displayItem();
    }
}
