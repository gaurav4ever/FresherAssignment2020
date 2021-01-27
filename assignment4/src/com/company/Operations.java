package assignment4.src.com.company;

import java.util.ArrayList;

public class Operations {

    public ArrayList<Item> taxCalculate( final ArrayList<Item> arrayList ) {
        double tax =0;
        final TaxEvaluation taxEvaluation = new TaxEvaluation();
        for( final Item item : arrayList ){
            //tax calculation method call
            if( item.getType().equals("raw") ) {
                tax = taxEvaluation.calculateRawTax(item.getPrice());
            }
            else if( item.getType().equals("manufactured") ) {
                tax = taxEvaluation.calculateManufacturedTax(item.getPrice());
            }
            else if( item.getType().equals("imported")) {
                tax = taxEvaluation.calculateImportedTax(item.getPrice());
            }
            item.setTax(tax);
        }
        return arrayList;
    }

    // default access specifier
    void displayItems( final ArrayList<Item> arrayList){
        for ( final Item item: arrayList ) {
            System.out.println("Name :\t" + item.getName() + "\tQuantity :\t" + item.getQuantity() + "\tPrice :\t" + item.getPrice() + "\tType :\t" + item.getType() + "\tTax :" + item.getTax());
        }
    }
}
