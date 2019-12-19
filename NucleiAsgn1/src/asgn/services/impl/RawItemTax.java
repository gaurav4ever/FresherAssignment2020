package asgn.services.impl;

import asgn.services.CalculateTaxService;

public class RawItemTax implements CalculateTaxService {

	@Override
	public double calculateTax(double price) {
		return (price * 12.5) / 100;
	}
}
