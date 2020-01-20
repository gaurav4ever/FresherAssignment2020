package Util;

import model.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class InputUtil {
    private static ArrayList<Item> productList = new ArrayList<>();

    // Input method
    public static ArrayList<Item> getInputItem() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Product Name: ");
        String productName = sc.nextLine();

        System.out.println("Product Price: ");
        float productPrice = sc.nextFloat();

        System.out.println("Product Quantity");
        int productQuantity = sc.nextInt();

        System.out.println("Choose product" + " type:\t 1: Raw \t 2: Manufactured " + "\t 3: Imported");
        int productType = sc.nextInt();

        productList.add(new Item(productName, productPrice, productQuantity, productType));

        // REPL
        System.out.println("Continue? (y/n)");
        String choice = sc.next();
        getAnotherInput(choice);
        return productList;
    }

    public static void getAnotherInput(String choice) {
        if ("Y".equals(choice) || "y".equals(choice)) {
            getInputItem();
        }
    }
}
