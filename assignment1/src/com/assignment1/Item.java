package com.assignment1;

public class Item {
		private String item_name;
		private double item_price;
		private String item_type;
		private double item_tax;
		private int item_quantity;
		
		public int getItemQuantity() {
		    return item_quantity;
		}
		public void setItemQuantity(int item_quantity) {
		    this.item_quantity = item_quantity;
		}
		public String getItemName() {
		    return item_name;
		}
		public void setItemName(String item_name) {
		    this.item_name = item_name;
		}
		public String getItemType() {
		    return item_type;
		}
		public void setItemType(String item_type) {
		    this.item_type = item_type;
		}
		public double getItemPrice() {
		    return item_price;
		}
		public void setItemPrice(double item_price) {
		    this.item_price = item_price;
		}
		public double getItemTax() {
		    return item_tax;
		}
		public void setItemTax(double item_tax) {
		    this.item_tax = item_tax;
		}

}
