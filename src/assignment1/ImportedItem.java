package assignment1;

import java.util.HashMap;

public class ImportedItem extends Item {

	public ImportedItem(HashMap<String, String> params) {
		super(params);
	}

	@Override
	public float getSalesTax() {
		float finalCost = this.getItemPrice() + (this.getItemPrice() * 10 /100); 
		float salesTax =(this.getItemPrice() * 10 /100) + ((finalCost <= 100) ? 5 : (finalCost>100 && finalCost <= 200) ? 10 : 5 * (finalCost) / 100);
		return salesTax;
	}

}
