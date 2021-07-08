package assignment1.models;

abstract public class Item {
    private String name;
    private Double price;
    protected Double tax = 0.0 ;

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public Double getTax() {
        return tax;
    }

    public Double getPrice() {
        return price;
    }
}

