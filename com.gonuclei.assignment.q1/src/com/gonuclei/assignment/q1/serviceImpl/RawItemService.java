package com.gonuclei.assignment.q1.serviceImpl;

import com.gonuclei.assignment.q1.model.Item;
import com.gonuclei.assignment.q1.service.ItemService;


public class RawItemService implements ItemService{
	
	
	public Item calculateTax(Item item) {
	
		double tax = item.getPrice()*(12.5/100);
		item.setTax(tax);
			
		return item;
	}
}
