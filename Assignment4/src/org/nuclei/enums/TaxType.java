package org.nuclei.enums;

import org.nuclei.model.Item;

public enum TaxType {

    RAW{
        @Override
       public Item calculateTax(Item item){
            double tax;
            tax = item.getPrice()*(12.5/100);
            item.setTax(tax);
            return item;
        }
    },
    MANUFACTURED{
        @Override
        public Item calculateTax(Item item){
            double tax;
            tax = item.getPrice()*12.5/100;
            tax = tax + (item.getPrice() + tax)*2/100;
            item.setTax(tax);
            return item;
        }
    },
    IMPORT{
        @Override
        public Item calculateTax(Item item){
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
    };

     public abstract Item calculateTax(Item item);

}