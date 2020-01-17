package models;

public abstract class Item {
    protected static final Double RAW_ITEM_TAX_RATE = 0.125;
    protected static final Double MANUFACTURED_ITEM_ADDITIONAL_TAX_RATE = 0.02;
    protected static final Double IMPORT_DUTY = 0.10;
    protected static final Double SURCHARGE_FOR_ITEM_COST_WITH_IMPORT_DUTY_UP_TO_100 = 5.0;
    protected static final Double SURCHARGE_FOR_ITEM_COST_WITH_IMPORT_DUTY_UP_TO_200 = 10.0;
    protected static final Double SURCHARGE_PERCENTAGE_FOR_ITEM_COST_WITH_IMPORT_DUTY_GREATER_THAN_200 = 0.05;
    public String name;
    public Double price;
    public Integer quantity;

    public Item(String name) {
        this.name = name;
        this.price = 0.0;
        this.quantity = 0;
    }

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public Item(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = 0.0;
    }

    public Item(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract Double calculateTax();

    public Double calculateFinalPrice() {
        return this.price + calculateTax();
    }

    public String toString() {
        return "Item name : " + name + " Item price : " + price + " Sales Tax Liability : " + calculateTax()
                + " Final Prize : " + calculateFinalPrice();
    }
}
