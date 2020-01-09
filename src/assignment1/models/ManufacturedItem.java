package assignment1.models;

public class ManufacturedItem extends Item {
    public ManufacturedItem(String name, Double price) {
        super(name, price);
        tax = 12.5 / 100 * price; // 12.5 % of price
        tax += 2.0 / 100 * (price + tax);  //  12.5 % of price + 2% of ( price + 12.5% of price)
    }
}
