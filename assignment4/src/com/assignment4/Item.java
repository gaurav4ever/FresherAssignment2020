package com.assignment4;

public class Item {
		private int item_id;
		private String item_name;
		private double item_price;
		private String item_type;
		private double final_price;
		
		public int getItemId() {
		    return item_id;
		}
		public void setId(int item_id) {
		    this.item_id = item_id;
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
		public double getFinalPrice() {
		    return final_price;
		}
		public void setFinalPrice(double final_price) {
		    this.final_price = final_price;
		}
		@Override
	    public String toString() {
	        return "Item [Item Name=" + item_name + ", Type=" + item_type + ", Final Price=" + final_price + "]";
	    }
}



