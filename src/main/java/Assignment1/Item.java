package Assignment1;

public class Item {
    String name;
    double price, tax;
    int quantity;
    enum ITEM_TYPE {RAW, MANUFACTURED, IMPORTED };
    ITEM_TYPE type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ITEM_TYPE getType() {
        return type;
    }

    public void setType(ITEM_TYPE type) {
        this.type = type;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
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
}
