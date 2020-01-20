package assignmentQ1.services;

public class Tax {
    public CalculateTaxService getTax(int type) {
        switch (type) {
        case 1:
            return new RawTax();
        case 2:
            return new ManufacturedTax();
        case 3:
            return new ImportedTax();
        default:
            System.out.println("You have entered a wrong choice!");
            System.exit(0);
        }
        return null;
    }
}
