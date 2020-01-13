package assignment1.models;

public abstract class Item {
    public String name;
    public Double price;
    public Integer quantity;

    public Item(String name){
        this.name = name;
        this.price = 0.0;
        this.quantity = 0;
    }
    public Item(String name, Double price){
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }
    public Item(String name,Integer quantity){
        this.name = name;
        this.quantity = quantity;
        this.price = 0.0;
    }
    public Item(String name, Double price, Integer quantity ){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract Double calculateTax();

    public Double calculateFinalPrice(){
        return this.price + calculateTax();
    }

    public String toString(){
        return "Item name : " + name + " Item price : " + price +
                " Sales Tax Liability : " + calculateTax() +
                " Final Prize : " + calculateFinalPrice();
    }
}
