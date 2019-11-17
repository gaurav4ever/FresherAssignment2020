package util;

import java.util.Scanner;

import model.Item;
import service.TaxService;

public class ItemUtility {

    static Scanner sc = new Scanner(System.in);
    static TaxService taxService = new TaxService();

    public static Item getItemInput() {
        Item item = new Item();

        System.out.println("Enter Details of Item");
        System.out.println("-name ");
        item.setName(sc.nextLine());
        System.out.println("-price ");
        item.setPrice(sc.nextDouble());
        System.out.println("-quantity ");
        item.setQuantity(sc.nextInt());
        System.out.println("-type ");
        item.setType(sc.next());
        sc.nextLine();

        return item;
    }

    public static char addNextItem() {
        System.out.println("Want to add more items? (y/n):");
        char ch = sc.next().toLowerCase().charAt(0);
        if(ch == 'n' || ch == 'y'){
            return ch;
        }
        else{
            System.out.println("Invalid input, try again");
            return addNextItem();
        }
    }

    
}