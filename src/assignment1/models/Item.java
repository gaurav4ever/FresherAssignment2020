package assignment1.models;

public class Item {
    private String mName;
    private Double mPrice;

    public Item(String name, Double price) {
        this.mName = name;
        this.mPrice = price;
    }

    public String getName() {
        return mName;
    }

    public Double getTax() {
        return null;
    }

    public Double getPrice() {
        return mPrice;
    }
}

