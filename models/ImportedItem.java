package models;

public class ImportedItem extends Item {
    public ImportedItem(String name) {
        super(name);
    }

    public ImportedItem(String name, Integer quantity) {
        super(name, quantity);
    }

    public ImportedItem(String name, Double price) {
        super(name, price);
    }

    public ImportedItem(String name, Double price, Integer quantity) {
        super(name, price, quantity);
    }

    @Override
    public Double calculateTax() {
        Double importDuty = IMPORT_DUTY * price;
        Double itemCostWithImportDuty = price + importDuty;
        Double surcharge = 0.0;

        if (itemCostWithImportDuty <= 100) {
            surcharge = SURCHARGE_FOR_ITEM_COST_WITH_IMPORT_DUTY_UP_TO_100;
        } else if (itemCostWithImportDuty <= 200) {
            surcharge = SURCHARGE_FOR_ITEM_COST_WITH_IMPORT_DUTY_UP_TO_200;
        } else {
            surcharge = SURCHARGE_PERCENTAGE_FOR_ITEM_COST_WITH_IMPORT_DUTY_GREATER_THAN_200 * (itemCostWithImportDuty);
        }

        return importDuty + surcharge;
    }
}
