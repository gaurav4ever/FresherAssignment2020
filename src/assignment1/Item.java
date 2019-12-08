package assignment1;

import java.util.HashMap;

public class Item {
	private String itemName,itemType;
	private float itemPrice;
	private int itemQuantity;
	
	public Item(HashMap<String,String> params) throws Exception {
		if(!params.containsKey("type")) {
			throw new Exception("Type is a mandatory option!");
		}
		if(!params.get("type").equals("raw")&&!params.get("type").equals("imported")&&!params.get("type").equals("manufactured")) {
			throw new Exception("type value invalid");
		}
		this.itemName=params.get("name");
		this.itemType=params.get("type");
		this.itemQuantity=Integer.parseInt(params.get("quantity"));
		this.itemPrice=Float.parseFloat(params.get("price"));
	}
	public float getSalesTax() {
		float salesTax = 0;
		switch(this.itemType) {
		case "raw": salesTax = (float) (12.5 * this.itemPrice / 100); break;
		case "manufactured": salesTax = (float) (12.5 * this.itemPrice / 100); salesTax += (2 * (this.itemPrice + salesTax) /100); break;
		case "imported": float finalCost = this.itemPrice + (this.itemPrice * 10 /100); salesTax =(this.itemPrice * 10 /100) + ((finalCost <= 100) ? 5 : (finalCost>100 && finalCost <= 200) ? 10 : 5 * (finalCost) / 100);
		}
		return salesTax;
	}
	/**
	 * @return the itemQuantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @return the itemPrice
	 */
	public float getItemPrice() {
		return itemPrice;
	}
}
