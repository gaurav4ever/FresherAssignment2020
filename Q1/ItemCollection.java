import models.Item;
import java.util.*;

public class ItemCollection {
    public ArrayList<Item> items;
    int noOfItems;

    public ItemCollection() {
        items = new ArrayList<Item>();
        noOfItems = 0;
    }

    public Boolean addItem(Item item) {
        items.add(item);
        return true;
    }

    public void displayItem() {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
