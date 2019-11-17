package inventory.util;

import java.util.Scanner;
import java.lang.System;
import inventory.exception.InvalidInputType;
import inventory.exception.InvalidItemException;
import inventory.model.Item;
import inventory.service.ItemService;

public class InventoryUtil {
	//create single instance of scanner class
	static Scanner sc=new Scanner(System.in);
	static ItemService service = new ItemService();
	public static Item getItems() {
		Item item=new Item();
		
		System.out.println("Enter item details : ");
		System.out.println("-name");
		// add exception for name type to be string
		item.setName(sc.nextLine());
		System.out.println("-price");
		item.setPrice(sc.nextDouble());
		System.out.println("-quantity");
		item.setQuantity(sc.nextInt());
		String type = "";
		int flag=0;
		while(true) {
			System.out.println("-type \t1.raw\t2.manufactured\t3.imported");
			type = sc.next();
			try {
				service.checkItemType(type);
				flag=1;
			}
			catch(InvalidItemException e) {
				//e.printStackTrace();
			}
			if(flag==1) {
				break;
			}
		}
		item.setType(type);
		sc.nextLine();
		return item;
	}
	public static void printItem(Item item) {
		System.out.println("Item Name	  : "+ item.getName());
		System.out.println("Item Price           : "+ item.getPrice());
		//System.out.println("Item Quantity        : "+ item.getQuantity());
		//System.out.println("Item Type            : "+ item.getType());
		System.out.println("Tax on single Item          : "+ item.getTax());
		double itemPrice = item.getPrice() + item.getOverallTax();
		System.out.println("Overall Price			 : "+ itemPrice );
	}
	public static void start() {
		Item item=null;
		String ch="y";
		//variable to get out of the loop
		int flag2=0;
		while(true) {
			item = getItems();
			//printItem(item);
			item = service.calculateTax(item);
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
