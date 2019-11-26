package question1;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class ItemServices {

    ArrayList<Item> itemList = new ArrayList<>();
    final Scanner sc = new Scanner(System.in);
    final String inputError = "Incorrect Input!!! Try Again";

    public Item readItem() {
        GetItemFactory itemFactory = new GetItemFactory();
        String name;
        double price;
        int quantity;

        out.println("Enter name");
        name = sc.next();

        while (true) {
            try {
                out.println("Enter Price");
                price = Double.parseDouble(sc.next());

                break;
            } catch (Exception e) {
                System.out.println(inputError);
            }
        }

        while (true) {
            try {
                out.println("Enter Quantity");
                quantity = Integer.parseInt(sc.next());

                break;
            } catch (Exception e) {
                System.out.println(inputError);
            }
        }

        out.println("Enter Type (Raw, Manufactured,Imported)");
        String type = sc.next();
        Item item = itemFactory.getItem(type);
        while (item == null) {
            out.println(inputError);
            type = sc.next();
            item = itemFactory.getItem(type);
        }

        item.setName(name);
        item.setPrice(price);
        item.calculateTaxes();
        item.setQuantity(quantity);

        return item;

    }

    public ArrayList<Item> readItems() {
        Item newItem;
        String answer = "y";
        while ("y".equalsIgnoreCase(answer)) {
            newItem = readItem();
            itemList.add(newItem);
            out.println("Do you want to enter details of any other item (y/n):");
            answer = sc.next();

        }
        return itemList;
    }
}

public class Question1 {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ItemServices service = new ItemServices();
        service.readItems();
        ArrayList<Item> items = service.itemList;
        System.out.println("Item\tPrice\tTaxes\tFinal Price");
        for (Item item : items) {
            double price = item.getPrice();
            double taxes = item.getTaxes();
            double finalPrice = price + taxes;
            String outputItem = item.getName() + "\t" + price + "\t" + taxes + "\t" + finalPrice;
            System.out.println(outputItem);
        }

    }

}
