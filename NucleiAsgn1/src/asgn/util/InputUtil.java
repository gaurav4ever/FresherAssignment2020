package asgn.util;

import java.util.ArrayList;
import java.util.Scanner;

import asgn.model.Item;

public class InputUtil {
	private static ArrayList<Item> arrayListItems;

	// get input from console in desired format
	public static ArrayList<Item> getInputItem() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the following product details:");
		System.out.print("Product name: ");
		String name = sc.next();
		System.out.print("Product price: ");
		double price = sc.nextFloat();
		System.out.print("Product quantity: ");
		int quantity = sc.nextInt();
		System.out.print("Choose product type:\n press 1 for raw\n 2 for manufactured\n 3 for imported\n");
		int type = sc.nextInt();

		arrayListItems.add(new Item(name, price, quantity, type));

		// ask for multiple items
		System.out.print("Do you want to enter details of any other item? Enter (y/n): ");
		String choice = sc.next();
		getAnotherInput(choice);
		return arrayListItems;
	}

	public static void getAnotherInput(String choice) {
		if ("Y".equals(choice) || "y".equals(choice)) {
			getInputItem();
		} else {
			// add condition
		}
	}
}
