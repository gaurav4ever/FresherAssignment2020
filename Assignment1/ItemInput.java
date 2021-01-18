import java.util.*;
import java.util.Scanner;

public class ItemInput {

    public Item_Values inputItems() {

        Scanner sc = new Scanner(System.in);
        Item_Values item = new Item_Values();

        

        System.out.println("Item name:");
        item.setName(sc.next());

        System.out.println("Item price:");
        
        item.setPrice(Double.parseDouble(sc.next()));
            
        

        System.out.println("Item quantity");
       
        item.setQuantity(Integer.parseInt(sc.next()));
             

        System.out.println("Item type:- raw, manufactured or imported:");
        item.setType(sc.next().toLowerCase());

        item.setTax(item.calculateTax());

        return item;

    }

}