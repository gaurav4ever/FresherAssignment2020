package Assignment1;

import Assignment1.Item;
import com.sun.tools.javac.comp.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {

    List<Item> items;
    Scanner scan;
    Item item;


    InventoryManager(){
        scan = new Scanner(System.in);
        items = new ArrayList<>();
    }

    void readData()
    {
        String ch;
        do{

            item = new Item();
            for(int i=0;i<4;i++) {
                String input = scan.nextLine();
                if( validateInput(input) )  i--;
            }
            item = taxCalculator(item);
            items.add(item);

            System.out.println("Do you want to add one more item (y/n) : ");
            ch = scan.nextLine();

        }while( ch.equals("y") );

        displayDetails();
    }

    void displayDetails() {
        for( Item item: items){
            StringBuilder message = new StringBuilder();
            message.append("Name : ");
            message.append(item.getName());
            message.append("\t");
            message.append("Price : ");
            message.append(item.getPrice());
            message.append("\t");
            message.append("Liable Tax : ");
            message.append(item.getTax());
            message.append("\t");
            message.append("Final Price : ");
            message.append("\t");
            message.append(item.getPrice() + item.getTax());
            System.out.println();
        }
    }

    Item taxCalculator(Item item) {
        double tax=0;
        if(item.getType() == Item.ITEM_TYPE.RAW)
            tax = item.getPrice()*0.125;
        else if(item.getType() == Item.ITEM_TYPE.MANUFACTURED)
            tax = item.getPrice()*0.125 + (item.getPrice()*0.125 + item.getPrice())*0.02;
        else if(item.getType() == Item.ITEM_TYPE.IMPORTED) {
            tax = 0.1 * item.getPrice();
            if ((item.getPrice() + tax) <= 100) tax+=5;
            else if ((item.getPrice() + tax) <= 200) tax+=10;
            else tax+=0.05*item.getPrice();
        }
        item.setTax(tax);
        return item;
    }

    boolean validateInput(String input) {

        //FIXME Update the following
        // - validate the input
        // - update the item

        return true;
    }

}
