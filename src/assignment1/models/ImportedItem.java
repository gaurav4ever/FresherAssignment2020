package assignment1.models;

public class ImportedItem extends Item {
    public ImportedItem(String name, Double price) {
        super(name, price);
        tax = 10.0 / 100 * price;
        if (tax <= 100) tax += 5;
        else if (tax >= 100 && tax <= 200) tax += 10;
        else tax += 5.0 / 100 * (tax + price); // 5 % of final cost which means original price + tax
        setTax(tax);
    }
}
