package asgn.services.impl;

import asgn.services.CalculateTaxService;

public class ImportedItemTax implements CalculateTaxService {

	@Override
	public double calculateTax(double price) {
		double tax = (price * 12.5) / 100;
		double importDuty = (price * 10) / 100;
		double finalCost = tax + importDuty;
		double surcharge = 0;
		if (finalCost <= 100) {
			surcharge = 5;
		} else if (finalCost <= 200) {
			surcharge = 10;
		} else {
			surcharge = (finalCost * 5) / 100;
		}
		return finalCost + surcharge;
	}

}
