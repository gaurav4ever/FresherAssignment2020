package com.company.main;

import com.company.main.Details.Type;
public class Item {

    private String name;
    Type type;
    private double price, tax, quantity;
    private boolean pFlag, nFlag, qFlag, tFlag;

    public Item() {
        this.pFlag = false;
        this.nFlag = false;
        this.qFlag = false;
        this.tFlag = false;
    }
    public Item(String name, double price, double qty, Type type){
        this.name=name;
        this.price=price;
        this.quantity=qty;
        this.type=type;
    }

    public void Assign(String name, double price, double qty, Type type){
        this.name=name;
        this.price=price;
        this.quantity=qty;
        this.type=type;

    }
    public boolean isPriceFlag() {
        return pFlag;
    }

    public void setPriceFlag(boolean priceFlag) {
        this.pFlag = priceFlag;
    }

    public boolean isNameFlag() {
        return nFlag;
    }

    public void setNameFlag(boolean nameFlag) {
        this.nFlag = nameFlag;
    }

    public boolean isQuantityFlag() {
        return qFlag;
    }

    public void setQuantityFlag(boolean quantityFlag) {
        this.qFlag = quantityFlag;
    }

    public boolean isTypeFlag() {
        return tFlag;
    }

    public void setTypeFlag(boolean typeFlag) {
        this.tFlag = typeFlag;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

}
