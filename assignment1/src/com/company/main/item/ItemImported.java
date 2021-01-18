package com.company.main;

public class ItemImported extends ItemModel{
    public ItemImported(String name,double price,int quantity){
        super(name,price,quantity);
        tax = 0.1 * price;
        if (tax <= 100) tax += 5;
        else if (tax <= 200) tax += 10;
        else tax += 0.05 * (price + tax);
        tax = tax * quantity;
        tax = price * 0.125;
    }
}
