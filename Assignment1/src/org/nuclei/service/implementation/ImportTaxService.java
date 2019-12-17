package org.nuclei.service.implementation;

import org.nuclei.model.Item;
import org.nuclei.service.TaxService;

public class ImportTaxService implements TaxService {

    @Override
    public Item calculateTax(Item item) {
        double tax;
        tax = item.getPrice()*10/100;
        if(tax + item.getPrice()<=100){
            tax = tax + 5;
        }
        else if(tax + item.getPrice()<=200){
            tax = tax + 10;
        }
        else {
            tax = tax + (item.getPrice() + tax)*5/100;
        }
        item.setTax(tax);
        return item;
    }
}
