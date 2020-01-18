package assignment1;

import java.util.HashMap;

public class ManufacturedItem extends Item {

	public ManufacturedItem(HashMap<String, String> params) {
		super(params);
	}

	@Override
	public float getSalesTax() {
		float salesTax = (float) (12.5 * this.getItemPrice() / 100); salesTax += (2 * (this.getItemPrice() + salesTax) /100);
		return salesTax;
	}

}
