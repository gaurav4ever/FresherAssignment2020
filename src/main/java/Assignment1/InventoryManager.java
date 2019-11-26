package Assignment1;

import com.sun.tools.javac.comp.Todo;

import java.util.List;
import java.util.Scanner;

public class InventoryManager {

    List<Item> items;
    Scanner scan;
    Item item;


    InventoryManager(){
        scan = new Scanner(System.in);
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
            items.add(item);

            System.out.println("Do you want to add one more item (y/n) : ");
            ch = scan.nextLine();

        }while( ch.equals("y") );
    }

    boolean validateInput(String input) {

        //FIXME Update the following
        // - validate the input
        // - update the item

        return true;
    }

}
