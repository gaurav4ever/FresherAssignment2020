package org.nuclei.dao;

import org.nuclei.model.Item;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public interface ItemDAO{

    void retrieveAllItems(BlockingQueue<Item> items) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException;
    void addItem(Item item);
    void updateTax(Item item);
    List<Item> getItem(String id) throws ClassNotFoundException, SQLException;
}
