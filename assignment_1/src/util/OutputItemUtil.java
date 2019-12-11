package util;

import model.Item;
public class OutputItemUtil {
	public void itemOutput(Item item) {
		System.out.println("Item Name    :" + item.getItemName());
		System.out.println("Item Price   :" + item.getItemPrice());
		System.out.println("Tax per Item :" + item.getItemTax());
		System.out.println("Total Price  :" + (item.getItemPrice() + item.getItemTax()));
	}
	
}

