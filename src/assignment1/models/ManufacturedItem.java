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
        Double rawTax = RAW_ITEM_TAX_RATE * price;
        Double manufacturedItemTax = MANUFACTURED_ITEM_ADDITIONAL_TAX_RATE * (price + rawTax);

        return   rawTax + manufacturedItemTax;
    }
}
