package assignmentQ1.util;

import assignmentQ1.model.Item;

public class OutputUtil {
    // output Util
    public static void printOutput(Item productListItems, double salesTax, double totalPrice) {
        System.out.println("Output details");
        System.out.println("Product Name:\t" + productListItems.productName);
        System.out.println("Product Price:\t" + productListItems.productPrice);
        System.out.println("Product Name:\t" + salesTax);
        System.out.println("Product Name:\t \n" + totalPrice);
    }
}
