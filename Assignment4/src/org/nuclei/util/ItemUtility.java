package org.nuclei.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import org.nuclei.model.Item;
public class ItemUtility {

    //   static Scanner sc = new Scanner(System.in);
//    public static char addNextItem() {
//        System.out.println("Want to add more items? (y/n):");
//        char ch = sc.next().toLowerCase().charAt(0);
//        if(ch == 'n' || ch == 'y'){
//            return ch;
//        }
//        else{
//            System.out.println("Invalid input, try again");
//            return addNextItem();
//        }
//    }

    public static void itemOutput(Item item) {
        System.out.println("Item Name    		 :  " + item.getName());
        System.out.println("Item Price   		 :  " + item.getPrice());
        System.out.println("Tax per Item		 :  " + item.getTax());
        System.out.println("Total Price per Item 	 :  " + (item.getTax() + item.getPrice()));
        System.out.println("Total price for " + item.getQuantity() + " items  : " +
                " " + item.getQuantity()*(item.getTax() + item.getPrice()) );
    }

    public static void run() {
        BlockingQueue<Item> blockingQueue = new LinkedBlockingDeque<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable calcTax = ()-> CalcTaxThreadUtil.calcTax(blockingQueue);
        Runnable  fetchItem = ()-> ItemFetchThreadUtil.fetchItem(blockingQueue);
        executor.execute(fetchItem);
        executor.execute(calcTax);
        executor.shutdown();
    }
}
