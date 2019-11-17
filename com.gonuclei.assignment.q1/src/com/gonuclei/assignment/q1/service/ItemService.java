package com.gonuclei.assignment.q1.service;

import com.gonuclei.assignment.q1.exception.InvalidItemTypeException;
import com.gonuclei.assignment.q1.model.Item;


public class ItemService{
	
	public Item calTax(Item item) throws InvalidItemTypeException {
		String type = item.getType();
		double tax;
		switch(type) {
			case "raw":
				tax = item.getPrice()*(12.5/100);
				item.setTax(tax);
				break;
			case "manufactured":
				tax = item.getPrice()*12.5/100;
				tax += (item.getPrice() + tax)*2/100;
				item.setTax(tax);
				break;
			case "imported":
				tax = item.getPrice()*10/100;
				if(tax + item.getPrice()<=100)
					tax += 5;
				else if(tax + item.getPrice()<=200)
					tax += 10;
				else tax += (item.getPrice() + tax)*5/100;
				item.setTax(tax);
				break;
			default: throw new InvalidItemTypeException("Invalid Type for Item");
		}
			
		return item;
	}
}
