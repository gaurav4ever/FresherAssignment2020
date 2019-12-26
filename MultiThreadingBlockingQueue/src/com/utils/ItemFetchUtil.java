package com.utils;

import com.dao.impl.DAOImpl;
import com.models.ItemDetails;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemFetchUtil implements Runnable {
  BlockingQueue<ItemDetails> itemDetails;
  Logger logger = Logger.getLogger(ItemFetchUtil.class.getName());
  public ItemFetchUtil(BlockingQueue<ItemDetails> blockingQueue){
    this.itemDetails = blockingQueue;
  }
  @Override
  public void run() {
    DAOImpl idao = new DAOImpl("root","nuclei@123");
    try {
      idao.retrieveAllItems(itemDetails);
    } catch (Exception e) {
      logger.log(Level.INFO,"Error in fetching items.");
    }
  }
}
