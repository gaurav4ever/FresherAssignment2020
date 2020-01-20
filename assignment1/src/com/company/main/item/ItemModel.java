package com.company.main;

public class ItemModel {

    public enum Type{
        RAW,IMPORTED,MANUFACTURED
    }
    private String name;
    Type type;
    private double price;
    protected double tax;
    private int quantity;
    private boolean priceFlag, nameFlag, quantityFlag, typeFlag;

    public ItemModel(String name, double price,int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ItemModel() {
        this.priceFlag = false;
        this.nameFlag = false;
        this.quantityFlag = false;
        this.typeFlag = false;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setType(Type type){
        this.type = type;
    }

    public boolean isPriceFlag() {
        return priceFlag;
    }

    public void setPriceFlag(boolean priceFlag) {
        this.priceFlag = priceFlag;
    }

    public boolean isNameFlag() {
        return nameFlag;
    }

    public void setNameFlag(boolean nameFlag) {
        this.nameFlag = nameFlag;
    }

    public boolean isQuantityFlag() {
        return quantityFlag;
    }

    public void setQuantityFlag(boolean quantityFlag) {
        this.quantityFlag = quantityFlag;
    }

    public boolean isTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(boolean typeFlag) {
        this.typeFlag = typeFlag;
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

    public int getQuantity() {
        return quantity;
    }

}
