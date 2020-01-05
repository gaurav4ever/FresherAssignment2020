/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleiassign1;

/**
 *
 * @author Nilesh Gajwani
 */
abstract class Item{
	static ItemType item_type;
	String item_name;
        float item_price;
        int item_quantity;
        float tax;
	abstract public void getSalesTax();
        Item()
        {
        }
        Item(String item_name, float item_price, int item_quantity)
        {
            this.item_name = item_name;
            this.item_price = item_price;
            this.item_quantity = item_quantity;
            getSalesTax();
            System.out.println("Called tax function");
        }
        
        public String toString()
        {
            String output = "\nName: "+ this.item_name + "\nPrice: " + this.item_price + "\nQuantity:  " + this.item_quantity + "\n" + "Tax:  " + this.tax + "\n\n";
            return output;
        }
        
}