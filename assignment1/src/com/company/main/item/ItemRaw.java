package com.company.main.item;

public class ItemRaw extends ItemModel {
    public ItemRaw(String name,double price,int quantity){
        super(name,price,quantity);
        System.out.println("creating raw item");
        tax = price * 0.125;
    }
}
