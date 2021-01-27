package org.nuclei.util;

import org.nuclei.model.Item;
import java.util.concurrent.BlockingQueue;

public class CalcTaxThreadUtil {
    public static void calcTax(BlockingQueue<Item> blockingQueue) {
        while (true) {
            try {
                Item item = blockingQueue.take();
                item.getType().calculateTax(item);
                ItemUtility.itemOutput(item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
