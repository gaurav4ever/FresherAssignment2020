package asgn;

import java.util.ArrayList;

import asgn.model.Item;
import asgn.util.InputUtil;
import asgn.util.OutputUtil;

public class Inventory {

	private static ArrayList<Item> arrayListItems;

	public static void main(String args[]) {
		arrayListItems = new ArrayList<>();
		arrayListItems = InputUtil.getInputItem(); // gets input from command prompt
		calculateOutput(); // calls sell tax method for one or more inputs
	}

	// Calculates tax of all the items entered
	private static void calculateOutput() {
		for (int i = 0; i < arrayListItems.size(); i++) {
			double salesTax = getCalculatedTax(arrayListItems.get(i).type, arrayListItems.get(i).price);

			double totalPrice = (arrayListItems.get(i).price + salesTax) * arrayListItems.get(i).quantity;

			System.out.println("\nOutput Details : ");
			OutputUtil.printOutput(arrayListItems.get(i), salesTax, totalPrice);
		}
	}

	// to select the tax rule
	private static double getCalculatedTax(int type, double price) {
		double tax = 0;
		switch (type) {
		case 1:
			tax = CalculateTax.getRawItemTax(price);
			break;
		case 2:
			tax = CalculateTax.getManufacturedItemTax(price);
			break;
		case 3:
			tax = CalculateTax.getImportedItemTax(price);
			break;
		}
		return tax;
	}
}
