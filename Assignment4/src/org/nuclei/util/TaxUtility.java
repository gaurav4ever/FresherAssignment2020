package org.nuclei.util;

import org.nuclei.model.Item;

import java.util.concurrent.BlockingQueue;

public class TaxUtility implements Runnable{

    BlockingQueue<Item> items;
    Thread fetchThread;

    public TaxUtility(BlockingQueue<Item> items, Thread fetchThread){
        this.items = items;
        this.fetchThread = fetchThread;
    }

    @Override
    public void run() {

        System.out.println("Started Tax Thread");
        boolean threadAlive = true;
        while(threadAlive) {

            Item item;
            try {
                item = items.take();
                item.getType().calculateTax(item);
                ItemUtility.itemOutput(item);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            //To close the thread if no more items are fetched.
            threadAlive = fetchThread.isAlive()||!items.isEmpty();
        }
    }
}
