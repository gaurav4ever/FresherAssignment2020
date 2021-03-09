package assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args) throws Exception {
		ArrayList<Item> items = ItemReader.getItems(args);
		for(Item item : items) {
			System.out.println("Item Name:"+item.getItemName());
			System.out.println("Item Price:"+item.getItemPrice());
			float salesTax=item.getSalesTax();
			System.out.println("Sales Tax:"+salesTax);
			System.out.println("Final Price:"+(item.getItemPrice()+salesTax));
			System.out.println();
		}
	}
}