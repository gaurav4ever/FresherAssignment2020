package assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args) throws Exception {
		ArrayList<Item> items = getItems(args);
		for(Item item : items) {
			System.out.println("Item Name:"+item.getItemName());
			System.out.println("Item Price:"+item.getItemPrice());
			float salesTax=item.getSalesTax();
			System.out.println("Sales Tax:"+salesTax);
			System.out.println("Final Price:"+(item.getItemPrice()+salesTax));
			System.out.println();
		}
	}
	private static ArrayList<Item> getItems(String[] params) throws Exception {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(getItem(params));
		char continueAdding='y';
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Do you want to enter details of any other item (y/n): ");
			continueAdding = sc.nextLine().charAt(0);
			if(continueAdding=='y') {
				System.out.println("Enter details of the item: ");
				String args=sc.nextLine();
				items.add(getItem(args.substring(0, args.length()).split(" ")));
			}
			else
				break;
		}
		sc.close();
		return items;
	}
	private static Item getItem(String[] params) throws Exception {
		if(params.length%2!=0) {
			throw new Exception("Invalid Parameters");
		}
		HashMap<String,String> paramMap = new HashMap<String,String>();
		for(int i=0;i<params.length;i+=2) {
			if(params[i].charAt(0)=='-') {
				paramMap.put(params[i].substring(1), params[i+1]);
			}
			else
				throw new Exception("Invalid Input Format");
		}
		Item item = new Item(paramMap);
		return item;
	}
}