package org.nuclei.DAO.impl;

import org.nuclei.DAO.ItemDAO;
import org.nuclei.model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private String databaseName = null;
    private String tableName = null;
    private String userName = null;
    private String userPassword = null;

    public ItemDAOImpl(String databaseName, String tableName, String userName, String userPassword) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.userName = userName;
        this.userPassword = userPassword;

    }

    /*ResultSet executeStatement(String query) throws SQLException {

        return resultSet;
    }*/

    @Override
    public void retrieveAllItems(List<Item> items) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName, userName, userPassword);
        ResultSet rs = null;
        Statement statement = null;
        String sql = ("SELECT * FROM " + tableName + " ;");
        statement = con.createStatement();
        rs = statement.executeQuery(sql);
        //items = new ArrayList<>();

        while(rs.next()) {
            Item resultItem = new Item();
            resultItem.setName(rs.getString("Name"));
            resultItem.setPrice(rs.getDouble("Price"));
            resultItem.setQuantity(rs.getInt("Quantity"));
            resultItem.setType(Item.TaxType.valueOf(rs.getString("Type")));
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

        /*List<Item> items;
        items = new ArrayList<>();
        String sql = ("SELECT * FROM " + tableName + "where Name="+ itemName +" ;");
        ResultSet rs = executeStatement(sql);

        Item resultItem = new Item();
        if(rs.next()) {
            resultItem.setName(rs.getString("Name"));
            resultItem.setPrice(rs.getDouble("Price"));
            resultItem.setQuantity(rs.getInt("Quantity"));
            resultItem.setType(Item.TaxType.valueOf(rs.getString("Type")));
            items.add(resultItem);
        }*/
        return null;
    }
}
