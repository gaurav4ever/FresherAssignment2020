package org.nuclei.util;

import org.nuclei.exception.InvalidItemException;
import org.nuclei.model.Item;
import org.nuclei.service.TaxService;
import org.nuclei.service.impl.TaxServiceImpl;

import java.util.List;

public class TaxUtility implements Runnable{

    List<Item> items;
    Thread fetchThread;

    public TaxUtility(List<Item> items, Thread fetchThread){
        this.items = items;
        this.fetchThread = fetchThread;
    }

    void calculateTaxForItems() throws InvalidItemException {
        for(Item item : items){
            item = TaxServiceImpl.calculateTax(item);
            ItemUtility.itemOutput(item);
        }
    };

    @Override
    public void run() {

        System.out.println("Started Tax Thread");
        boolean threadAlive = true;
        int index = 0;
        while(threadAlive) {
            while(!items.isEmpty()&&index<items.size()) {
                System.out.println("in here");
                try {
                    Item item = items.get(index);
                    item = TaxServiceImpl.calculateTax(item);
                    ItemUtility.itemOutput(item);
                    index++;
                    if(threadAlive==false){
                        break;
                    }
                    threadAlive = fetchThread.isAlive();
                    //calculateTaxForItems();
                } catch (InvalidItemException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
