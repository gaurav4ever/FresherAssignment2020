package Assignment4;

import Assignment4.db.MySQL;
import Assignment4.models.Item;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    public static List<Item> items;
    public static boolean lock;
    public static boolean completed;

    InventoryManager(){
        items = new ArrayList<>();
        lock = false;
        completed = false;
    }

    void start()
    {
        new Thread(() -> new MySQL().getItem()).start();
        new Thread(() -> new TaxCalculator().calculate()).start();
    }

}
