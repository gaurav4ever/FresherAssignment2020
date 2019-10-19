package assignment1.models;

public class ItemDetail {
    private Item item ;
    private int quantity ;

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
}
