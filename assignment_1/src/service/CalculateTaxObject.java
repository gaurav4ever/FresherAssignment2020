package service;

import exception.InvalidItemTypeException;
import model.Item;

public class CalculateTaxObject {
	
	public Item calculateTax (Item item)throws InvalidItemTypeException{
		switch (item.getItemType()){
		case "raw" :
			RawItem obj = new RawItem();
			return obj.calculateTax(item);
		case "manufactured":
			ManufacuredItem obj1 = new ManufacuredItem();
			return obj1.calculateTax(item);
		case "imported":
			ImportedItem obj2 = new ImportedItem();
			return obj2.calculateTax(item); 
		default:
			throw new InvalidItemTypeException("Invalid Type!");
		}
	}
}
