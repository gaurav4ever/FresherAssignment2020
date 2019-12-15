package org.nuclei.util;

import org.nuclei.DAO.ItemDAO;
import org.nuclei.DAO.impl.ItemDAOImpl;
import org.nuclei.model.Item;

import java.sql.SQLException;
import java.util.List;

public class ItemFetchUtility implements Runnable {

    private ItemDAO handler = new ItemDAOImpl("Nuclei", "Items", "root", "nuclei@123");
    private List<Item> items;

    public ItemFetchUtility(List<Item> items){
        this.items = items;
    }

    void getItemsFromDB() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        handler.retrieveAllItems(this.items);
    };

    @Override
    public void run() {
        System.out.println("Started fetch thread");
        try {
            getItemsFromDB();
            for(Item item : items){ ItemUtility.itemOutput(item); }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
