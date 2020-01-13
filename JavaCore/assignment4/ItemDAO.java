package assignment4;

import assignment1.Constants;
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

                switch (rs.getString(Constants.TYPE)) {
                    case Constants.RAW:
                        item = new RawItem(rs.getString(Constants.NAME), rs.getDouble(Constants.PRICE));
                        break;
                    case Constants.IMPORTED:
                        item = new ImportedItem(rs.getString(Constants.NAME), rs.getDouble(Constants.PRICE));
                        break;
                    case Constants.MANUFACTURED:
                        item = new ManufacturedItem(rs.getString(Constants.NAME), rs.getDouble(Constants.PRICE));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + rs.getString(Constants.TYPE));
                }

                items.add(new ItemDetail(item, rs.getInt(Constants.QUANTITY)));
            }
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
