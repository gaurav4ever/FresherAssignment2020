package asgn.util;

import asgn.model.Item;
// print output in desired format

public class OutputUtil {
	
	public static void printOutput(Item arrayListItems) {
		System.out.println("Product name: " + arrayListItems.name);
		System.out.println("Product price: " + arrayListItems.price);
		System.out.println("Sales tax per item: " + arrayListItems.tax + "\n");
	}
}
