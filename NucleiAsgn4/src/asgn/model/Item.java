package asgn.model;

//Class to describe the properties of item
public class Item {
	public String name;
	public double price;
	public int quantity;
	public int type;
	public double tax;

	/**
	 *
	 * @param name
	 * @param price
	 * @param quantity
	 * @param type
	 */
	public Item(String name, double price, int quantity, int type) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}

	public String getname() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getType() {
		return type;
	}
	
	public double getTax() {
		return tax;
	}
	
	public void setTax(double tax) {
		this.tax = tax;
	}
}