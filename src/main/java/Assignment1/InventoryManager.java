package Assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {

    private List<Item> items;
    private Scanner scan;

    InventoryManager(){
        scan = new Scanner(System.in);
        items = new ArrayList<>();
    }

    void readData()
    {
        Item item = new Item();
        System.out.println("Enter the item details: ");
        validateInput(item);
        item.setTax(new TaxCalculator().getTax(item));
        items.add(item);
        System.out.println("Item added successfully");
    }

    void displayDetails() {
        System.out.println("NAME\t\tPRICE\t\tTAX\t\tFINAL PRICE");
        System.out.println("====\t\t=====\t\t==========\t\t===========");
        for( Item item: items)
            System.out.println(item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getTax() + "\t\t" + (item.getPrice() + item.getTax()));
    }



    private void validateInput(Item item) {
        for(int i=0; i<4; i++)
        {
            System.out.print("> ");
            String cmd = scan.next();
            if(cmd.equals("-name") && scan.hasNext()) {
                if (item.isNameFlag()) {
                    System.out.println("Name is already added...");
                    i--;
                    scan.next();
                    continue;
                }
                item.setName(scan.nextLine());
                item.setNameFlag(true);
                System.out.println("Name added");
            } else if(cmd.equals("-price") && scan.hasNextDouble()) {
                if (item.isPriceFlag()) {
                    System.out.println("Price is already added...");
                    i--;
                    scan.next();
                    continue;
                }
                item.setPrice(scan.nextDouble());
                item.setPriceFlag(true);
                System.out.println("Price added");
            } else if(cmd.equals("-quantity") && scan.hasNextDouble()) {
                if (item.isQuantityFlag()) {
                    System.out.println("Quantity is already added...");
                    i--;
                    scan.next();
                    continue;
                }
                item.setQuantity(scan.nextDouble());
                item.setQuantityFlag(true);
                System.out.println("Quantity added");
            } else if(cmd.equals("-type") && scan.hasNext("RAW|IMPORTED|MANUFACTURED")) {
                if (item.isTypeFlag()) {
                    System.out.println("Type is already added...");
                    i--;
                    scan.next();
                    continue;
                }
                item.setType(scan.next("RAW|IMPORTED|MANUFACTURED"));
                item.setTypeFlag(true);
                System.out.println("Type added");
            } else {
                System.out.println("Please enter a valid input...");
                i--;
                scan.next();
            }
        }
    }

}
