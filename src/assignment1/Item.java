package assignment1;

import java.util.HashMap;

abstract public class Item {
	private String itemName;
	private float itemPrice;
	private int itemQuantity;
	
	public Item(HashMap<String,String> params) {
		this.itemName=params.get("name");
		this.itemQuantity=Integer.parseInt(params.get("quantity"));
		this.itemPrice=Float.parseFloat(params.get("price"));
	}
	abstract public float getSalesTax();
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
