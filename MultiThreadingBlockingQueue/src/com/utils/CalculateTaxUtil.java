package com.utils;

import com.constants.Constants;
import com.models.ItemDetails;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculateTaxUtil implements Runnable {

  BlockingQueue<ItemDetails> items;
  Thread fetchThread;
  Logger logger = Logger.getLogger(CalculateTaxUtil.class.getName());
  public CalculateTaxUtil(BlockingQueue<ItemDetails> blockingQueue,Thread fetchThread){
    this.items = blockingQueue;
    this.fetchThread = fetchThread;
  }
  @Override
  public void run() {
    logger.log(Level.INFO, Constants.TAX_THREAD);
    boolean fetchThreadAlive = true;
    while(fetchThreadAlive){
      ItemDetails item;
      try{
        item = items.take();
        item.getType().calculateTax(item);
        ItemDetailOutput.itemOutput(item);
        Thread.sleep(500);
      }
      catch (Exception e) {
        logger.log(Level.INFO,e.getMessage());
      }
      fetchThreadAlive = fetchThread.isAlive() || !items.isEmpty();
    }
  }
}
