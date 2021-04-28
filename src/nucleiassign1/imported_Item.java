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
class imported_Item extends Item {

    static ItemType item_type = ItemType.Imported;

    imported_Item() {

    }

    imported_Item(String name, float price, int quantity) {
        super(name, price, quantity);
        getSalesTax();
    }

    public void getSalesTax() {
        float taxWithoutSurcharge = (float) (this.item_price + 0.1 * this.item_price);
        this.tax = (float) (0.1 * this.item_price);
        if (taxWithoutSurcharge <= 100) {
            this.tax += 5;
        } else if (taxWithoutSurcharge > 100 && taxWithoutSurcharge <= 200) {
            this.tax += 10;
        } else {
            this.tax += 0.05 * taxWithoutSurcharge;
        }
    }

    public String toString() {
        return "\nType:  " + this.item_type.toString() + super.toString() + "\nTax:  ";
    }
}
