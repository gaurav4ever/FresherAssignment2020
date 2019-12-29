package Assignment1;

public class TaxCalculator {

    public double getTax(Item item) {
        double tax=0;
        switch (item.getType()) {
            case "RAW":
                tax = item.getPrice() * 0.125;
                break;
            case "MANUFACTURED":
                tax = item.getPrice() * 0.125 + (item.getPrice() * 0.125 + item.getPrice()) * 0.02;
                break;
            case "IMPORTED":
                tax = 0.1 * item.getPrice();
                if (tax <= 100) tax += 5;
                else if (tax <= 200) tax += 10;
                else tax += 0.05 * (item.getPrice() + tax);
                break;
        }
        return tax*item.getQuantity();
    }

}
