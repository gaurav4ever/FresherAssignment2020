package assignment1.models;

public class RawItem extends Item {
    public RawItem(String name, Double price) {
        super(name, price);
        tax = 12.5 / 100 * price;
    }
}
