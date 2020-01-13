package assignment1.models;

public class ItemDetail {
    private Item item;
    private int quantity;

    public ItemDetail(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void display() {
        System.out.println("========    Item Details    ========");
        System.out.println("Name = " + item.getName());
        System.out.println("Type = " + item.getClass().getSimpleName());
        if (item.getPrice() != null) System.out.println("Price = " + item.getPrice());
        System.out.println("Quantity = " + quantity);
        System.out.println("Sales tax = " + item.getTax());
        System.out.println("Final Price = " + (item.getPrice() + item.getTax()));
        System.out.println("====================================");
        System.out.println("\n");
    }
}
