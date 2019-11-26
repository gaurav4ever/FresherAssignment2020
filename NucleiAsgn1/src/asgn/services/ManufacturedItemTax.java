package asgn.services;

public class ManufacturedItemTax implements CalculateTaxes {

	@Override
	public double calculateTax(double price) {
		double x = (price * 12.5) / 100;
		return x + 2 * x / 100;
	}
}
