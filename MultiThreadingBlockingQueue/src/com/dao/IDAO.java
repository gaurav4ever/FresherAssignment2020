package com.dao;

import com.models.ItemDetails;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public interface IDAO {
  void retrieveAllItems(BlockingQueue<ItemDetails> items) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException;
  List<ItemDetails> getItem(String id) throws ClassNotFoundException, SQLException;
  void writeItemsFromResultSet(BlockingQueue<ItemDetails> items) throws SQLException;
}
