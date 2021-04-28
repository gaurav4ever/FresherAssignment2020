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

/**
 *
 * @author Nilesh Gajwani
 */
class raw_Item extends Item {

    static ItemType item_type = ItemType.Raw;

    raw_Item() {

    }

    raw_Item(String name, float price, int quantity) {
        super(name, price, quantity);
    }

    public void getSalesTax() {
        tax = (float) (this.item_price * 0.125);
    }

    public String toString() {
        return "\nType:  " + this.item_type.toString() + super.toString() + "\nTax:  " + this.tax;
    }
}
