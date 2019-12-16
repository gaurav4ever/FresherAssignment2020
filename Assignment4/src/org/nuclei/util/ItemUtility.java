package org.nuclei.util;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.nuclei.model.Item;

public class ItemUtility {

    BlockingQueue<Item> items = new LinkedBlockingDeque<>();
    static Scanner sc = new Scanner(System.in);

    public static void itemOutput(Item item) {
        System.out.println("Item Name    		 :  " + item.getName());
        System.out.println("Item Price   		 :  " + item.getPrice());
        System.out.println("Tax per Item		 :  " + item.getTax());
        System.out.println("Total Price per Item 	 :  " + (item.getTax() + item.getPrice()));
        System.out.println("Total price for " + item.getQuantity() + " items  : " +
                " " + item.getQuantity()*(item.getTax() + item.getPrice()) );
        System.out.println("-----------------------------------------------------------");
    }

    public void run() {
        
        ItemFetchUtility fetch = new ItemFetchUtility(this.items);
        Thread fetchThread = new Thread(fetch);
        fetchThread.setPriority(10);

        TaxUtility tax = new TaxUtility(this.items, fetchThread);
        Thread taxThread = new Thread(tax);
        taxThread.setPriority(5);

        fetchThread.start();
        taxThread.start();
    }
}
