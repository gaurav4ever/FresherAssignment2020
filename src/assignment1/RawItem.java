package assignment1;

import java.util.HashMap;

public class RawItem extends Item {

	public RawItem(HashMap<String, String> params) {
		super(params);
	}

	@Override
	public float getSalesTax() {
		float salesTax = (float) (12.5 * this.getItemPrice() / 100);
		return salesTax;
	}

}
