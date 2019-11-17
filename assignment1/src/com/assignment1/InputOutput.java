package com.assignment1;
import java.util.Scanner;

public class InputOutput {
	Scanner s = new Scanner(System.in);
	
	public Item inputItem() {
		Item item = new Item();
		//s.nextLine();
		System.out.println("Please Enter the details of the item:-");
		System.out.print("-name : ");
		item.setItemName(s.nextLine());
		System.out.print("-price : ");
		item.setItemPrice(s.nextDouble());
		System.out.print("-quantity : ");
		item.setItemQuantity(s.nextInt());
		System.out.print("-type : ");
		item.setItemType(s.next());
		
		return item;
	}
	
	
	public Item calculateTax(Item item) throws InvalidTypeException {
		String type = item.getItemType();
		double tax;
		switch(type) {
			case "raw" :
				tax = item.getItemPrice() * (12.5/100);
				item.setItemTax(tax);
				break;
			case "manufactured":
				double taxInitial1;
				taxInitial1 = item.getItemPrice() * 12.5/100;
				tax = taxInitial1 + (taxInitial1 + item.getItemPrice()) * 2/100;
				item.setItemTax(tax);
				break;
			case "imported":
				double taxInitial;
				taxInitial = item.getItemPrice() * 10/100;
				if(taxInitial + item.getItemPrice() <= 100)
					tax =taxInitial +  5;
				else if(taxInitial + item.getItemPrice()<= 200)
					tax =taxInitial + 10;
				else
					tax = taxInitial +  (taxInitial + item.getItemPrice()) * 5/100;
				item.setItemTax(tax);
				break;
			default:
				throw new InvalidTypeException("Invalid Type!");
		}
		
		return item;
	}
	
	public void itemOutput(Item item) {
		System.out.println("Item Name    :" + item.getItemName());
		System.out.println("Item Price   :" + item.getItemPrice());
		System.out.println("Tax per Item :" + item.getItemTax());
		System.out.println("Total Price  :" + (item.getItemPrice() + item.getItemTax()));
	}
	
	
	public char isNext() {
		System.out.println("Do you want to add more items? (y/n)");
		char ch = s.next().charAt(0);
		if(ch == 'y' || ch == 'Y' || ch =='n' || ch == 'N') {
			s.nextLine();
			return ch;
		}
		else {
			System.out.println("Invalid Option! Please Choose Again.");
			
			return isNext();
		}
	}
	
	public void run() {
		InputOutput obj = new InputOutput();
		Item item = null;
		char ch = 'y';
		while(true) {
			item = obj.inputItem();
			try {
			item = obj.calculateTax(item);
			}
			catch(InvalidTypeException e) {
				e.printStackTrace();
			}
			obj.itemOutput(item);
			ch = obj.isNext();
			if(ch == 'N' || ch == 'n')
				break;
		}
	}
}
