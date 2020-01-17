package models;

public class RawItem extends Item {
    public RawItem(String name) {
        super(name);
    }

    public RawItem(String name, Integer quantity) {
        super(name, quantity);
    }

    public RawItem(String name, Double price) {
        super(name, price);
    }

    public RawItem(String name, Double price, Integer quantity) {
        super(name, price, quantity);
    }

    @Override
    public Double calculateTax() {
        return RAW_ITEM_TAX_RATE * price;
    }
}
