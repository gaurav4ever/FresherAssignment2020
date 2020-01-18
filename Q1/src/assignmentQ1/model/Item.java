package assignmentQ1.model;

// Properties of item
public class Item {
    public String name;
    public double price;
    public int quantiy;
    public int type;

    public Item(String name, double price, int quantiy, int type) {
        this.name = name;
        this.price = price;
        this.quantiy = quantiy;
        this.type = type;
    }
}
