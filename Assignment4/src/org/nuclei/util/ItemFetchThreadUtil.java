package org.nuclei.util;

import org.nuclei.dao.DAO;
import org.nuclei.model.Item;

import java.util.concurrent.BlockingQueue;

public class ItemFetchThreadUtil {

    public static void fetchItem(BlockingQueue<Item> blockingQueue) {
            DAO.getItems(blockingQueue);
    }
}
