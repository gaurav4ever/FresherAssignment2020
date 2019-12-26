package com.dao.impl;

import com.dao.IDAO;
import com.enums.ItemType;
import com.models.ItemDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOImpl implements IDAO {
  ResultSet resultSet=null;
  Statement statement;
  Connection connect;
  String password;
  String id;
  Logger logger = Logger.getLogger(DAOImpl.class.getName());
  public DAOImpl(String id,String password){
    this.id=id;
    this.password=password;
  }
  @Override
  public void retrieveAllItems(BlockingQueue<ItemDetails> items) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Items",id,password);
      statement=connect.createStatement();
      resultSet = statement.executeQuery("select * from Item");

    } catch (Exception e) {
      logger.log(Level.INFO,e.getMessage());
    } finally {
      try {
        if (resultSet != null) {
          resultSet.close();
        }

        if (statement != null) {
          statement.close();
        }

        if (connect != null) {
          connect.close();
        }
      } catch (Exception e) {
          logger.log(Level.INFO,e.getMessage());
      }
    }
    writeItemsFromResultSet(items);
  }

  @Override
  public List<ItemDetails> getItem(String id) throws ClassNotFoundException, SQLException {
    return Collections.emptyList();
  }
  @Override
  public void writeItemsFromResultSet(BlockingQueue<ItemDetails> items) {
    try {
      while (resultSet.next()) {
        ItemDetails resultItemDetails = new ItemDetails();
        resultItemDetails.setName(resultSet.getString("Name"));
        resultItemDetails.setPrice(resultSet.getDouble("Price"));
        resultItemDetails.setQuantity(resultSet.getInt("Quantity"));
        resultItemDetails.setType(ItemType.valueOf(resultSet.getString("Type")));
        items.add(resultItemDetails);
      }
    } catch (NullPointerException | SQLException e) {
      logger.log(Level.INFO, "No data present.");
    }
  }
}
