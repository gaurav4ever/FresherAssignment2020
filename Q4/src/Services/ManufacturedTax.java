package Services;

public class ManufacturedTax implements CalculateTaxService {

    @Override
    public double calculateTax(double price) {
        double tax = (price * 12.5) / 100;
        return tax + 2 * tax / 100;
    }
}
