package assignment1.models;

public class ManufacturedItem extends Item{
    public ManufacturedItem(String name){
        super(name);
    }
    public ManufacturedItem(String name,Integer quantity){
        super(name,quantity);
    }
    public ManufacturedItem(String name, Double price){
        super(name,price);
    }
    public ManufacturedItem(String name, Double price, Integer quantity){
        super(name,price,quantity);
    }
    @Override
    public Double calculateTax() {
        return  0.125  * price + 0.02 * ( price + 0.125 * price);
    }
}
