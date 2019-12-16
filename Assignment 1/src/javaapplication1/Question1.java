import java.lang.System;
import java.util.*;
import java.text.DecimalFormat;

class ItemOperations {

    public Item readItem() {

        Scanner sc = new Scanner(System.in);
        Item item = new Item();

        String error = "Invalid input. Please retype!";

        System.out.println("Enter the name of the item");
        item.setName(sc.next());

        System.out.println("Enter the price of the item");
        while (true) {
            try {
                item.setPrice(Double.parseDouble(sc.next()));
                break;
            } catch (Exception ex) {
                System.out.println(error);
            }
        }

        System.out.println("Enter the quantity of the item");
        while (true) {
            try {
                item.setQuantity(Integer.parseInt(sc.next()));
                break;
            } catch (Exception ex) {
                System.out.println(error+" an integer.");
            }
        }

        System.out.println("Enter the type of the item i.e; raw, manufactured or imported");
        item.setType(sc.next().toLowerCase());

        item.setTax(item.calculateTax());

        return item;

    }

}

public class Question1 {

    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Item> ar = new ArrayList<Item>();
        ItemOperations items = new ItemOperations();

        String choice = "y";
        while (choice.equals("y")) {
            ar.add(items.readItem());
            System.out.println("Do you want to enter details of any other item (y/n):");
            choice = sc.next();
        }

        System.out.println("Item\tPrice\tTax\tFinal Price");
        for (Item item : ar) {
            System.out.println(item.getName() + "\t" + df.format(item.getPrice()) + "\t" + df.format(item.getTax()) + "\t" + df.format(item.getFinalPrice()));
        }

    }
}
