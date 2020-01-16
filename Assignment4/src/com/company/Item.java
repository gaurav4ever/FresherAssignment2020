package com.company;

public class Item {
    private String name;
    Details.Type type;
    private double price, tax, quantity;
    private boolean priceFlag, nameFlag, quantityFlag, typeFlag;

    public Item() {
        this.priceFlag = false;
        this.nameFlag = false;
        this.quantityFlag = false;
        this.typeFlag = false;
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

    public void setName(String name) {
        this.name = name;
    }

    public Details.Type getType() {
        return type;
    }

    public void setType(int type) {
        switch(type) {
            case 1: this.type = Details.Type.RAW; break;
            case 2: this.type = Details.Type.IMPORTED; break;
            case 3: this.type = Details.Type.MANUFACTURED; break;
        }
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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
