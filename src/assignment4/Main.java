package assignment4;

import assignment1.models.ItemDetail;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ItemDetail> itemCollection = new ArrayList<>() ;
        Producer producer = new Producer(itemCollection) ;
        Consumer consumer = new Consumer(itemCollection) ;

        Thread producerThread = new Thread(producer) ;
        Thread consumerThread = new Thread(consumer) ;

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
