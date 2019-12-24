public class Item {
    private String name;
    private double price;
    private int quantity;
    private String type;
    private double tax;
    private double overallTax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getOverallTax() {
        return overallTax;
    }

    public void setOverallTax(double overallTax) {
        this.overallTax = overallTax;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", type='" + type + '\'' +
                ", tax=" + tax +
                ", overallTax=" + overallTax +
                '}';
    }
}
