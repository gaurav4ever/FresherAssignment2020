package assignment4;

import assignment1.Constants;
import assignment1.ItemFactory;
import assignment1.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemDAO {
    public void putItemsIntoList(List<ItemDetail> items) {
        Connection con = DBConnectionManager.getConnection();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from Item");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs != null && rs.next()) {

                Item item = ItemFactory.getItem(rs.getString(Constants.NAME) ,
                        rs.getString(Constants.TYPE),
                        rs.getDouble(Constants.PRICE)
                );

                System.out.println("Got Item : " + item.getName() + " from db");
                synchronized (item){
                    items.add(new ItemDetail(item, rs.getInt(Constants.QUANTITY)));
                }
                Thread.sleep(new Random().nextInt(1000)) ;
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
