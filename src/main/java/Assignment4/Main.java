package Assignment4;

import java.sql.SQLException;

public class Main {
    public static void main (String [] args ) throws ClassNotFoundException, SQLException {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.start();
    }
}