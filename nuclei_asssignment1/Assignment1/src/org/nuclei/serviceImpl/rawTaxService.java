package org.nuclei.serviceImpl;

import org.nuclei.model.Item;
import org.nuclei.service.TaxService;

public class rawTaxService implements TaxService {

    @Override
    public Item calculateTax(Item item) {
        double tax;
        tax = item.getPrice()*(12.5/100);
        item.setTax(tax);
        return item;
    }
}