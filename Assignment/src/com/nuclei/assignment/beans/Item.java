package com.nuclei.assignment.beans;
//Bean to create the item object
public class Item {
	String name;
	double price;
	int quantity;
	String type;
	double tax;
	double total;
	public String getName() {
		return name;
	}
	
	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//computng the tax amount at the time of object creation
	
	public Item(String name, double price, int quantity, String type) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
		double cost = this.price*this.quantity;
		if(this.type.equals("raw")) {
			this.tax = cost*0.125;
			this.total = this.tax + cost;
		}
		else if(this.type.equals("manufactured")) {
			this.tax = cost*0.125;
			this.tax += (this.tax + cost)*0.02;
			this.total = this.tax + cost;
		}
		else if(this.type.equals("imported")) {
			this.tax = cost*0.10;
			this.total = this.tax + cost;
			if(this.total <= 100.0) {
				this.tax += 5;
			}
			else if(this.total <= 200) {
				this.tax += 10;
			}
			else {
				this.tax += this.total*0.05;
			}
			this.total = this.tax + cost;
		}
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", quantity=" + quantity + ", type=" + type + ", tax=" + tax
				+ ", total=" + total + "]";
	}
	
}
