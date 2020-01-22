package assignment4.src.com.company;

public class Item {

    protected String name;
    protected int quantity;
    protected double price, tax;
    protected String type;

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setType(String type){
        this.type = type;
    }

    public Double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public  String getType(){
        return type;
    }

    public void setTax(double tax){
        this.tax = tax;
    }

    public double getTax(){
        return tax;
    }

}
