package org.nuclei.model;

public class Item {

    public enum TaxType{
        raw, manufactured, imported
    }

    private String name;
    private double price;
    private int quantity;
    private TaxType type;
    private double tax;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public TaxType getType() {
        return type;
    }
    public void setType(TaxType type) {
        this.type = type;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }

}