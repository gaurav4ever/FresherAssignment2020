package assignment1.src.com.company;

public class Item {

    private String name;
    private int quantity;
    private double price;
    private String type;

    public Item () {
        name = "";
        quantity = 0;
        price = 0.0;
        type = "";
    }

    public void setPrice( final Double price ) {
        this.price = price;
    }

    public void setName( final String name ) {
        this.name = name;
    }

    public void setQuantity( final int quantity ){
        this.quantity = quantity;
    }

    public void setType( final String type ){
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

}
