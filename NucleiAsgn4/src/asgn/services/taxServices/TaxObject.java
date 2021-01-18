package asgn.services.taxServices;

import asgn.services.taxServices.impl.ImportedItemTax;
import asgn.services.taxServices.impl.ManufacturedItemTax;
import asgn.services.taxServices.impl.RawItemTax;

public class TaxObject {
	public CalculateTaxes getTax(int type) {
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