package inventory.service;

import inventory.exception.InvalidInputType;

public class ItemService {
	
//	public void checkItemType(String type) throws InvalidItemException{
//		if(!type.equals("raw") && !type.equals("manufactured") && !type.equals("imported")) {
//			throw new InvalidItemException("This type of item does not exist. Please re-enter.");
//		}
//		return ;
//	}
//	
	public void checkInputType(String ch) throws InvalidInputType {
		if(!ch.equals("y") && !ch.equals("n")) {
			throw new InvalidInputType("Please enter correct input.");
		}
		return;
	}
//	
//	//public void checkItemName(String ch)
//	//we can either check item type like above or after taking input
//	//after taking input if item type is wrong then we need to again take input
//	//that's why above implementation is correct
//	//public Item calculateTax(Item item) throws InvalidItemException{
//	public Item calculateTax(Item item){
//		String type=item.getType();
//		double tax;
//		switch(type) {
//		case "raw" : 
//			tax=item.getPrice()*(12.5/100);
//			item.setTax(tax);
//			item.setOverallTax(tax*item.getQuantity());
//			break;
//		case "manufactured" :
//			tax=item.getPrice()*(12.5/100);
//			tax = tax + (item.getPrice() + tax)*2/100;
//			item.setTax(tax);
//			item.setOverallTax(tax*item.getQuantity());
//			break;
//		case "imported" : 
//			tax = item.getPrice()*10/100;
//			if(tax+item.getPrice() <= 100) {
//				tax+=5;
//			}
//			else if(tax+item.getPrice() <= 200) {
//				tax+=10;
//			}
//			else {
//				tax+=(item.getPrice() + tax)*5/100;
//			}
//			item.setTax(tax);
//			item.setOverallTax(tax*item.getQuantity());
//			break;
//		//default	: 
//			//throw new InvalidItemException("This type of item does not exist. Please re-enter.");
//		}
//		return item;
//	}
}
