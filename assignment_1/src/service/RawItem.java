package service;
import model.Item;;

public class RawItem implements CalculateTax{

	public Item calculateTax(Item item) {
		double tax;
		tax = item.getItemPrice() * (12.5/100);
		item.setItemTax(tax);
		return item;
	}
}
