package com.company.main;

public class ItemManufactured extends ItemModel{
    public ItemManufactured(String name,double price,int quantity){
        super(name,price,quantity);
        tax = price * 0.125 + (price * 0.125 + price) * 0.02;
        tax = price * 0.125;
    }
}
