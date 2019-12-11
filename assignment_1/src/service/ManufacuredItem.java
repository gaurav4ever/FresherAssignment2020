package service;
import model.Item;

public class ManufacuredItem implements CalculateTax{
	
	public Item calculateTax(Item item) {
		double tax;
		double taxInitial1;
		taxInitial1 = item.getItemPrice() * 12.5/100;
		tax = taxInitial1 + (taxInitial1 + item.getItemPrice()) * 2/100;
		item.setItemTax(tax);
		return item;
	}
	
}
