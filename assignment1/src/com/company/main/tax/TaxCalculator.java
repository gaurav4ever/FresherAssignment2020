package com.company.main;

public class TaxCalculator {
    public double getTax(ItemModel item) {

       switch (item.getType()) {

            case RAW:
                ItemRaw r =new ItemRaw(item.getName(),item.getPrice(),item.getQuantity());
                return r.getTax();
            case MANUFACTURED:
               ItemManufactured m = new ItemManufactured(item.getName(),item.getPrice(),item.getQuantity());
                return m.getTax();
            case IMPORTED:
                ItemImported i = new ItemImported(item.getName(),item.getPrice(),item.getQuantity());
                return i.getTax();
            default:
                return 0;
        }
    }
}
