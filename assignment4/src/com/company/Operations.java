package assignment4.src.com.company;

import assignment4.src.com.company.Item;
import assignment4.src.com.company.TaxEvaluation;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    ArrayList<Item> taxCalculate(ArrayList<Item> arrayList){
        double tax =0;
        TaxEvaluation te = new TaxEvaluation();
        for(Item item:arrayList){
            //tax calculation method call
            if( item.getType() == "raw" )
                tax = te.calculateRawTax(item.getPrice());
            else if( item.getType() == "manufactured")
                tax = te.calculateManufacturedTax(item.getPrice());
            else if( item.getType() == "imported")
                tax = te.calculateImportedTax(item.getPrice());
            item.setTax(tax);
        }
        return arrayList;
    }

    void displayItems(ArrayList<Item> arrayList){
        for(Item item: arrayList)
            System.out.println("Name :\t" +item.getName() + "\tQuantity :\t" + item.getQuantity() + "\tPrice :\t" +item.getPrice() + "\tType :\t" + item.getType() + "\tTax :" + item.getTax());
    }
}
