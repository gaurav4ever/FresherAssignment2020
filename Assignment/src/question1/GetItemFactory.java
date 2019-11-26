package question1;

import question1.Item;

public class GetItemFactory {

    //use getPlan method to get object of type Plan   
    public Item getItem(String itemType) {
        if (itemType == null) {
            return null;
        }
        if ("RAW".equalsIgnoreCase(itemType)) {
            return new RawItem();
        } else if ("MANUFACTURED".equalsIgnoreCase(itemType)) {
            return new ManufacturedItem();
        } else if ("IMPORTED".equalsIgnoreCase(itemType)) {
            return new ImportedItem();
        }
        return null;
    }
}

class ManufacturedItem extends Item {

    public ManufacturedItem() {
        this.setType("Manufactured");

    }

    @Override
    public void calculateTaxes() {
        this.setTaxes(0.1475 * this.getPrice());
    }

}

class RawItem extends Item {

    public RawItem() {
        this.setType("Raw");

    }

    @Override
    public void calculateTaxes() {
        this.setTaxes(0.125 * this.getPrice());
    }

}

class ImportedItem extends Item {

    public ImportedItem() {
        this.setType("Imported");

    }

    @Override
    public void calculateTaxes() {
        double taxes = 0;
        taxes = 1.1 * this.getPrice();

        //surcharge
        if (taxes <= 100) {
            taxes = taxes + 5;
        } else if (taxes > 200) {
            taxes = 1.05 * taxes;

        } else {
            taxes = taxes + 10;
        }
        this.setTaxes(taxes);
    }

}
