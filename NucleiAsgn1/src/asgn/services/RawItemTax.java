package asgn.services;

public class RawItemTax implements CalculateTaxes {

	@Override
	public double calculateTax(double price) {
		return (price * 12.5) / 100;
	}
}
