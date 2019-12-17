package org.nuclei.enums;

import org.nuclei.model.Item;

public enum taxType {
    raw{
        @Override
        public void calculateTax(Item item) {
            double tax;
            tax = item.getPrice()*(12.5/100);
            item.setTax(tax);

        }
    },
    manufactured{
        @Override
        public void calculateTax(Item item) {
            double tax;
            tax = item.getPrice()*12.5/100;
            tax += (item.getPrice() + tax)*2/100;
            item.setTax(tax);

        }
    },
    imported{
        @Override
        public void calculateTax(Item item) {
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
        }
    };
    public abstract void calculateTax(Item item);
}
