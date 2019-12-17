package org.nuclei.service.implementation;
import org.nuclei.model.Item;
import org.nuclei.exception.InvalidItemException;
import org.nuclei.service.TaxService;

public class TaxServiceImpl {

    public static Item calculateTax(Item item) throws InvalidItemException {
        String type = item.getType();
        TaxService service;
        switch(type) {
            case "raw":
                service = new RawTaxService();
                service.calculateTax(item);
                break;
            case "manufactured":
                service = new ManufacturedTaxService();
                service.calculateTax(item);
                break;
            case "import":
                service = new ImportTaxService();
                service.calculateTax(item);
                break;
            default:
                throw new InvalidItemException("Invalid Type for Item");
        }

        return item;
    }
}