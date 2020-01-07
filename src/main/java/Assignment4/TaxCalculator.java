package Assignment4;

import Assignment4.models.Item;

class TaxCalculator {

    void calculate() {
        int index = 0;
        while (true) {
            System.out.print("");
            if (index == InventoryManager.items.size() && InventoryManager.completed) {
                System.out.println("Tax calculation completed");
                break;
            }
            while (InventoryManager.lock) ;
            InventoryManager.lock = true;
            if (index > (InventoryManager.items.size() - 1)) {
                InventoryManager.lock = false;
                continue;
            }
            Item item = InventoryManager.items.get(index);
            InventoryManager.lock = false;
            double tax = 0;
            switch (item.getType()) {
                case "RAW":
                    tax = item.getPrice() * 0.125;
                    break;
                case "MANUFACTURED":
                    tax = item.getPrice() * 0.125 + (item.getPrice() * 0.125 + item.getPrice()) * 0.02;
                    break;
                case "IMPORTED":
                    tax = 0.1 * item.getPrice();
                    if (tax <= 100) tax += 5;
                    else if (tax <= 200) tax += 10;
                    else tax += 0.05 * (item.getPrice() + tax);
                    break;
            }
            item.setTax(tax * item.getQuantity());
            displayDetails(item, index + 1);
            while (InventoryManager.lock) ;
            InventoryManager.lock = true;
            InventoryManager.items.get(index).setTax(tax * item.getQuantity());
            index++;
            InventoryManager.lock = false;
        }
    }

    private void displayDetails(Item item, int index) {
        System.out.println("CALCULATED TAX FOR ITEM " + index + "\t=>\tNAME: " + item.getName() + "\tPRICE: " +
                item.getPrice() + "\tTYPE: " + item.getType() + "\tTAX: " + item.getTax() + "\tFINAL PRICE: " +
                (item.getPrice() + item.getTax()));
    }

}