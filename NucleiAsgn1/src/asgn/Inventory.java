package asgn;

import java.util.ArrayList;

import asgn.model.Item;
import asgn.services.CalculateTaxService;
import asgn.services.TaxObject;
import asgn.util.InputUtil;
import asgn.util.OutputUtil;

public class Inventory {

	private static ArrayList<Item> arrayListItems = new ArrayList<>();

	public static void main(String args[]) {
		arrayListItems = InputUtil.getInputItem(); // gets input from terminal
		calculateTax(); // calls sell tax method for one or more inputs
	}

	// Calculates tax of all the items entered
	private static void calculateTax() {
		for (Item arrayListItem : arrayListItems) {
			double salesTax = getCalculatedTax(arrayListItem.type, arrayListItem.price);
			double totalPrice = (arrayListItem.price + salesTax) * arrayListItem.quantity;
			OutputUtil.printOutput(arrayListItem, salesTax, totalPrice);
		}
	}

	// to select the tax rule
	private static double getCalculatedTax(int type, double price) {
		CalculateTaxService calculateTaxServiceObject = new TaxObject().getTax(type);
		return calculateTaxServiceObject.calculateTax(price);
	}
}