package assignmentQ1.services;

public class ImportedTax implements CalculateTaxService {
    @Override
    public double calculateTax(double price) {
        double tax = (price * 12.5) / 100;
        double importDuty = (price * 10) / 100;
        double finalCost = tax + importDuty;
        double surcharge = 0;
        if (finalCost <= 100) {
            surcharge = 5;
        } else if (finalCost <= 200) {
            surcharge = 5;
        } else {
            surcharge = (finalCost * 5) / 100;
        }
        return finalCost + surcharge;
    }
}
