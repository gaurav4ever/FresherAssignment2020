package org.nuclei.serviceImpl;
import org.nuclei.model.Item;
import org.nuclei.exception.InvalidItemException;
import org.nuclei.service.TaxService;

public class TaxServiceImpl {

    public static Item calculateTax(Item item) throws InvalidItemException {
        String type = item.getType();
        TaxService service;
        switch(type) {
            case "raw":
                service = new rawTaxService();
                service.calculateTax(item);
                break;
            case "manufactured":
                service = new manufacturedTaxService();
                service.calculateTax(item);
                break;
            case "import":
                service = new importTaxService();
                service.calculateTax(item);
                break;
            default:
                throw new InvalidItemException("Invalid Type Item");
        }

        return item;
    }
}