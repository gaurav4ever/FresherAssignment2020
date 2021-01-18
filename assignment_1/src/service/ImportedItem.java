package service;
import model.Item;
public class ImportedItem implements CalculateTax{
	public Item calculateTax(Item item) {
		double tax;
		double taxInitial;
		taxInitial = item.getItemPrice() * 10/100;
		if(taxInitial + item.getItemPrice() <= 100)
			tax =taxInitial +  5;
		else if(taxInitial + item.getItemPrice() <= 200)
			tax =taxInitial + 10;
		else
			tax = taxInitial +  (taxInitial + item.getItemPrice()) * 5/100;
		
		item.setItemTax(tax);
		return item;
	}
}
