package inventory.service;

import inventory.model.Item;

public class GetItemFactory {
	private GetItemFactory(){}

	public static Item getItem(String itemType) {
		if(itemType == null) {
			return null;
		}
		if("RAW".equalsIgnoreCase(itemType)) {
			return new RawItem();
		}
		if("Manufactured".equalsIgnoreCase(itemType)) {
			return new ManufacturedItem();
		}
		if("Imported".equalsIgnoreCase(itemType)) {
			return new ImportedItem();
		}
		return null;
	}
}

class RawItem extends Item{
	public RawItem() {
		this.setType("Raw");
	}

	@Override
	public void calculateTaxes() {
		this.setTax(0.125 * this.getPrice());
	}
	
}

class ManufacturedItem extends Item{
	public ManufacturedItem() {
		this.setType("Manufactured");
	}
	
	@Override
	public void calculateTaxes() {
		this.setTax(0.1475 * this.getPrice());
	}
}

class ImportedItem extends Item{
	public ImportedItem() {
		this.setType("Imported");
	}

	@Override
	public void calculateTaxes() {
		double taxes = 0;
		taxes = 1.1 * this.getPrice();
		
		if(taxes<=100) {
			taxes = taxes + 5;
		}
		else if(taxes > 200) {
			taxes = 1.05 * taxes;
		}
		
		this.setTax(taxes);
	}
	
}