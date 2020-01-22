package assignment1.src.com.company;

public class TaxEvaluation {

    public double calculateRawTax(double price) {
        return 0.125 * price;
    }

    public double calculateImportedTax(double price) {
        double surcharge = 0, tax;
        tax = price * 0.1 + 0.125 * price;
        if (price + tax < 100) {
            surcharge = 5;
        } else if (price + tax < 200) {
            surcharge = 10;
        } else if (price + tax >= 200) {
            surcharge = 0.05 * (price + tax);
        }
        tax = tax + surcharge;
        return tax;
    }

    public double calculateManufacturedTax(double price) {
        return (price + 0.125 * price) * 0.02 + 0.125 * price;
    }
}
