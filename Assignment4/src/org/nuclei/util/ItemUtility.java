package org.nuclei.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.nuclei.DAO.ItemDAO;
import org.nuclei.DAO.impl.ItemDAOImpl;
import org.nuclei.exception.InvalidItemException;
import org.nuclei.model.Item;
import org.nuclei.service.impl.TaxServiceImpl;


public class ItemUtility {

    List<Item> items = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    /*public static Item getItemInput() {
        Item item = new Item();

        System.out.println("Enter Details of Item");
        System.out.println("-name ");
        item.setName(sc.nextLine());
        System.out.println("-price ");
        item.setPrice(sc.nextDouble());
        System.out.println("-quantity ");
        item.setQuantity(sc.nextInt());
        System.out.println("-type ");
        item.setType(Item.TaxType.valueOf(sc.next()));
        sc.nextLine();

        return item;
    }*/

    /*public static char addNextItem() {
        System.out.println("Want to add more items? (y/n):");
        char ch = sc.next().toLowerCase().charAt(0);
        if(ch == 'n' || ch == 'y'){
            return ch;
        }
        else{
            System.out.println("Invalid input, try again");
            return addNextItem();
        }
    }*/

    public static void itemOutput(Item item) {
        System.out.println("Item Name    		 :  " + item.getName());
        System.out.println("Item Price   		 :  " + item.getPrice());
        System.out.println("Tax per Item		 :  " + item.getTax());
        System.out.println("Total Price per Item 	 :  " + (item.getTax() + item.getPrice()));
        System.out.println("Total price for " + item.getQuantity() + " items  : " +
                " " + item.getQuantity()*(item.getTax() + item.getPrice()) );
        System.out.println("----------------------------------------------------------------------------");
    }

    public void run() {
        /*Item item = null;
        char ch = 'y';
        while(true) {
            item = getItemInput();
            try {
                item = TaxServiceImpl.calculateTax(item);
            } catch (InvalidItemException e) {
                e.printStackTrace();
            }
            itemOutput(item);
            ch = addNextItem();
            if(ch=='n') break;
        }*/

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
