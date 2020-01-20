package assignmentQ1.services;

public class RawTax implements CalculateTaxService {
    @Override
    public double calculateTax(double price) {
        return (price * 12.5) / 100;
    }
}
