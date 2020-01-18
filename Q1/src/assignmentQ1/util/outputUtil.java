package assignmentQ1.util;

import assignmentQ1.model.Item;

public class outputUtil {
//    output Util
    public static void printOutput(Item productListItems, double salesTax, double totalPrice) {
        System.out.println("Output details");
        System.out.println("Product Name:"+ productListItems.productName);
        System.out.println("Product Price:"+ productListItems.productPrice);
        System.out.println("Product Name:"+ salesTax);
        System.out.println("Product Name:"+ totalPrice);
    }
}
