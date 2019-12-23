package com.utils;

import com.models.ItemDetails;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ItemsUtility {
  BlockingQueue<ItemDetails> blockingQueue = new LinkedBlockingDeque<>();
  public void run(){
      ItemFetchUtil fetch = new ItemFetchUtil(this.blockingQueue);
      Thread fetchTread = new Thread(fetch);
      fetchTread.setPriority(10);

      CalculateTaxUtil tax = new CalculateTaxUtil(this.blockingQueue,fetchTread);
      Thread taxTread = new Thread(tax);
      taxTread.setPriority(5);

      fetchTread.start();
      taxTread.start();
    }
}
