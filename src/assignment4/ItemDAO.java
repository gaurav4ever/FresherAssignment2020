package assignment4;

import assignment1.Strings;
import assignment1.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public void create(ItemDetail itemDetail) {
        Connection con = DBConnectionManager.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("insert into Item values (? , ? , ? ,?)");
            preparedStatement.setString(1, itemDetail.getItem().getName());
            preparedStatement.setDouble(2, itemDetail.getItem().getPrice());
            preparedStatement.setInt(3, itemDetail.getQuantity());
            preparedStatement.setString(4, itemDetail.getItem().getClass().getSimpleName().toLowerCase());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ItemDetail> getItems() {
        Connection con = DBConnectionManager.getConnection();
        List<ItemDetail> items = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from Item");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs != null && rs.next()) {

                Item item;

                switch (rs.getString(Strings.type)) {
                    case Strings.raw:
                        item = new RawItem(rs.getString(Strings.name), rs.getDouble(Strings.price));
                        break;
                    case Strings.imported:
                        item = new ImportedItem(rs.getString(Strings.name), rs.getDouble(Strings.price));
                        break;
                    case Strings.manufactured:
                        item = new ManufacturedItem(rs.getString(Strings.name), rs.getDouble(Strings.price));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + rs.getString(Strings.type));
                }

                items.add(new ItemDetail(item, rs.getInt(Strings.quantity)));
            }
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
