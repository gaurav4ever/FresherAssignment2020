package org.nuclei.dao.impl;

import org.nuclei.dao.ItemDAO;
import org.nuclei.enums.TaxType;
import org.nuclei.model.Item;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ItemDAOImpl implements ItemDAO {

    private String databaseName;
    private String tableName;
    private String userName;
    private String userPassword;

    public ItemDAOImpl(String databaseName, String tableName, String userName, String userPassword) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.userName = userName;
        this.userPassword = userPassword;

    }

    @Override
    public void retrieveAllItems(BlockingQueue<Item> items) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName, userName, userPassword);
        ResultSet rs;
        Statement statement = null;
        String sql = ("SELECT * FROM " + tableName + " ;");
        statement = con.createStatement();
        rs = statement.executeQuery(sql);

        while(rs.next()) {
            Item resultItem = new Item();
            resultItem.setName(rs.getString("Name"));
            resultItem.setPrice(rs.getDouble("Price"));
            resultItem.setQuantity(rs.getInt("Quantity"));
            resultItem.setType(TaxType.valueOf(rs.getString("Type")));
            items.add(resultItem);
        }
    }

    @Override
    public void addItem(Item item) {
        //TODO: implementation
    }

    @Override
    public void updateTax(Item item) {
        //TODO: implementation
    }

    @Override
    public List<Item> getItem(String itemName) throws ClassNotFoundException, SQLException {

        //TODO: implementation
        return Collections.emptyList();
    }
}
