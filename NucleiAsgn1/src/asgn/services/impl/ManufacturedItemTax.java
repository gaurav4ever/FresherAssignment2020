package asgn.services.impl;

import asgn.services.CalculateTaxService;

public class ManufacturedItemTax implements CalculateTaxService {

	@Override
	public double calculateTax(double price) {
		double x = (price * 12.5) / 100;
		return x + 2 * x / 100;
	}
}
