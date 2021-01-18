package asgn.services;

import asgn.services.impl.ImportedItemTax;
import asgn.services.impl.ManufacturedItemTax;
import asgn.services.impl.RawItemTax;

public class TaxObject {

	public CalculateTaxService getTax(int type) {
		switch (type) {
		case 1:
			return new RawItemTax();
		case 2:
			return new ManufacturedItemTax();
		case 3:
			return new ImportedItemTax();
		default:
			System.out.println("You have entered a wrong choice!");
			System.exit(0);
		}
		return null;
	}
}