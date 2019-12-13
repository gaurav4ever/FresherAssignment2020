package inventory.util;

import java.util.Scanner;
import java.lang.System;
import inventory.exception.InvalidInputType;
import inventory.model.Item;
import inventory.service.GetItemFactory;
import inventory.service.ItemService;

public class InventoryUtil {
	//create single instance of scanner class
	static Scanner sc=new Scanner(System.in);
	static ItemService service = new ItemService();
	public static Item getItems() {
		
		GetItemFactory getItemFactory = new GetItemFactory();
		
		System.out.println("Enter item details : ");
		
		// add exception for name type to be string
		System.out.println("-name");
		String name = sc.nextLine();
		
		System.out.println("-price");
		double price = sc.nextDouble();
		
		System.out.println("-quantity");
		int quantity = sc.nextInt();
		
		System.out.println("-type \t1.raw\t2.manufactured\t3.imported");
		String type = sc.next();
		Item item = getItemFactory.getItem(type);
		while(item == null) {
			System.out.println("Invalid item type. Re-enter item type");
			type = sc.next();
			item = getItemFactory.getItem(type);
		}
		
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		item.calculateTaxes();
		
		sc.nextLine();
		return item;
	}
	public static void printItem(Item item) {
		System.out.println("Item Name	  : "+ item.getName());
		System.out.println("Item Price           : "+ item.getPrice());
		//System.out.println("Item Quantity        : "+ item.getQuantity());
		//System.out.println("Item Type            : "+ item.getType());
		System.out.println("Tax on single Item          : "+ item.getTax());
		double itemPrice = item.getPrice() + item.getQuantity()*item.getTax();
		System.out.println("Overall Price			 : "+ itemPrice );
	}
	public void start() {
		Item item=null;
		String ch="y";
		//variable to get out of the loop
		int flag2=0;
		while(true) {
			item = getItems();
			printItem(item);
			System.out.println("Do you want to enter another item.(y/n)");
			while(true) {
				try {
					ch = sc.nextLine();
					service.checkInputType(ch);
					flag2=1;
				}
				catch(InvalidInputType e) {
					
				}
				if(flag2==1) {
					break;
				}
			}
			
			
			if(ch.equals("n")) {
				System.out.println("Thank you.");
				System.exit(0);
			
			}
		}
	}
}
