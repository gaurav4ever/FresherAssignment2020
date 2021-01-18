package com.gonuclei.assignment.q1.serviceImpl;

import com.gonuclei.assignment.q1.model.Item;
import com.gonuclei.assignment.q1.service.ItemService;

public class ManufacturedItemTaxService implements ItemService {

	@Override
	public Item calculateTax(Item item) {
		double tax = item.getPrice()*12.5/100;
		tax += (item.getPrice() + tax)*2/100;
		item.setTax(tax);
		return item;
	}

}
