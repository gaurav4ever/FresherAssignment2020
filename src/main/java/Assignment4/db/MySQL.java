package Assignment4.db;

import Assignment4.InventoryManager;
import Assignment4.models.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
    private Connection conn;
    public MySQL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connectionUrl = "jdbc:mysql://localhost:3306/assignment5?useUnicode=true&characterEncoding=UTF-8&user=root&password=";
        try {
            conn = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getItem() {
        try {
            ResultSet rs = conn.prepareStatement("select * from items").executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setName(rs.getString(1));
                item.setType(rs.getString(2));
                item.setQuantity(rs.getDouble(3));
                item.setPrice(rs.getDouble(4));
                while (InventoryManager.lock) ;
                InventoryManager.lock = true;
                InventoryManager.items.add(item);
                InventoryManager.lock = false;
                System.out.println("Addeed new item: "+ InventoryManager.items.size()+" to list");
            }
            InventoryManager.completed = true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
