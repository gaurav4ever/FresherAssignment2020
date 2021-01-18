package assignment1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {

            System.out.println("Enter name of item :");
            String name = sc.nextLine();

            System.out.println("Enter type of item [ raw , manufactured , imported ] : ");
            String type = sc.nextLine();

            System.out.println("Enter price of item (optional) :");
            String price = sc.nextLine();

            System.out.println("Enter quantity of item (optional) : ");
            String quantity = sc.nextLine();

            if (name.equals("")) {
                throw new RuntimeException("Name is required.");
            }
            if (!(type.equals("raw") || type.equals("manufactured") || type.equals("imported"))) {
                throw new RuntimeException("Type shoud be either raw, manufactured or imported.");
            }
            System.out.println("Name of Item : " + name);
            System.out.println("Type of Item : " + type);
            if (!price.equals("")) {
                System.out.println("Price : " + price);
                float pricef = Float.parseFloat(price);
                CalculateTax ct = new CalculateTax(type, pricef);
                System.out.println("Sales tax liability :" + String.valueOf(ct.getTax()));
                System.out.println("Final Price :" + String.valueOf(ct.getTax() + pricef));

            }
            if (!quantity.equals("")) {
                System.out.println("Quantity : " + quantity);
            }

            System.out.println("Do you want to enter details of any other item (y/n):");
            choice = sc.nextLine();

        }while(choice.equals("y"));

    }
}
