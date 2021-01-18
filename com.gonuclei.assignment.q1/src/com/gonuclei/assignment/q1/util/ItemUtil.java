package com.gonuclei.assignment.q1.util;

import java.util.Scanner;

import com.gonuclei.assignment.q1.exception.InvalidItemTypeException;
import com.gonuclei.assignment.q1.model.Item;
import com.gonuclei.assignment.q1.service.ItemService;
import com.gonuclei.assignment.q1.serviceImpl.ImportedItemTaxService;
import com.gonuclei.assignment.q1.serviceImpl.ManufacturedItemTaxService;
import com.gonuclei.assignment.q1.serviceImpl.RawItemService;

public class ItemUtil {

	private static Scanner sc = new Scanner(System.in);;

	private static ItemService itemService;

	public static Item getItemInput() {
		Item item = new Item();

		System.out.println("Enter the Details of the Item");
		System.out.print("-name ");
		item.setName(sc.nextLine());
		System.out.print("-price ");
		item.setPrice(sc.nextDouble());
		System.out.print("-quantity ");
		item.setQuantity(sc.nextInt());
		System.out.print("-type ");
		item.setType(sc.next());
		sc.nextLine();

		return item;
	}

	public static char nextInput() {
		System.out.println("Do you want to enter details of any other item (y/n):");
		char ch = sc.next().toLowerCase().charAt(0);
		
		if (ch == 'n' || ch == 'y') {
			return ch;
		}
		else {
			System.out.println("Invalid Input Please Try Again");
			return nextInput();
		}
	}

	private static void itemOutput(Item item) {
		System.out.println("Item Name    		 :  " + item.getName());
		System.out.println("Item Price   		 :  " + item.getPrice());
		System.out.println("Tax per Item		 :  " + item.getTax());
		System.out.println("Total Price per Item 	 :  " + (item.getTax() + item.getPrice()));
		System.out.println("Total price for " + item.getQuantity() + " items  : " + " "
				+ item.getQuantity() * (item.getTax() + item.getPrice()));
	}

	public static void run() {
		Item item = null;
		char ch = 'y';
		while (true) {
			item = getItemInput();
			try {
				item = calculateTax(item);
			} catch (InvalidItemTypeException e) {
				e.printStackTrace();
			}
			itemOutput(item);
			ch = nextInput();
			if (ch == 'n')
				break;
		}
	}

	// try using abstract factory design pattern & factory design pattern
	private static Item calculateTax(Item item) throws InvalidItemTypeException {
		String itemType = item.getType();
		
		switch(itemType) {
		case "raw":
			itemService = new RawItemService();
			item = itemService.calculateTax(item);
			break;
		case "manufactured":
			itemService = new ManufacturedItemTaxService();
			item = itemService.calculateTax(item);
			break;
		case "imported":
			itemService = new ImportedItemTaxService();
			item = itemService.calculateTax(item);
			break;
		default: throw new InvalidItemTypeException("This kind of item does not exist");
		}
		return item;
	}
}
