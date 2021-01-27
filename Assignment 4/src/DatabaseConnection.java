import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private Statement statement = null;

    public List<Item> items = new ArrayList<Item>();

    public void readItemFromDatabase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/Items", "root", "root");
            //here Items is database name, root is username and password
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Items");
            writeItemsToList(resultSet);
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void writeItemsToList(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Item item = new Item();
            //now getting the details of item from database and storing it to the list to display
            String name;
            name = resultSet.getString("itemname");
            item.setName(name);
            double price;
            price = resultSet.getDouble("itemprice");
            item.setPrice(price);
            int quantity;
            quantity = resultSet.getInt("itemquantity");
            item.setQuantity(quantity);
            String type;
            type = resultSet.getString("type");
            item.setType(type);
            Main.items.add(item);
            System.out.println("Itemname: " + name + " Price: " + price + " Quantitiy: " + quantity + " Type: " + type);
        }
        System.out.println(Main.items);
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {

        }
    }


}
