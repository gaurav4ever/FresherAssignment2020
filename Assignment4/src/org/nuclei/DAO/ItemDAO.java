package org.nuclei.DAO;

import org.nuclei.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO{

    void retrieveAllItems(List<Item> items) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException;
    void addItem(Item item);
    void updateTax(Item item);
    List<Item> getItem(String id) throws ClassNotFoundException, SQLException;
}
