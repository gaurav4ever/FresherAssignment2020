package com.gonuclei.assignment.q1.serviceImpl;

import com.gonuclei.assignment.q1.model.Item;
import com.gonuclei.assignment.q1.service.ItemService;

public class ImportedItemTaxService implements ItemService{

	@Override
	public Item calculateTax(Item item) {
		double tax = item.getPrice()*10/100;
		
		if(tax + item.getPrice()<=100) {			
			tax += 5;
		}
		else if (tax + item.getPrice()<=200) {
			tax += 10;			
		}
		else {
			tax += (item.getPrice() + tax)*5/100;
			item.setTax(tax);
		}

		return item;
	}
	
}
