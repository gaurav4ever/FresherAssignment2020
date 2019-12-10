package asgn.util;

import asgn.model.Item;

public class OutputUtil {
	// print output in desired format
	public static void printOutput(Item arrayListItems, double salesTax, double totalPrice) {
		System.out.println("Product name: " + arrayListItems.name);
		System.out.println("Product price: " + arrayListItems.price);
		System.out.println("Sales tax per item: " + salesTax);
		System.out.println("Total cost of the given quantity of item: " + totalPrice + "\n");
	}
}