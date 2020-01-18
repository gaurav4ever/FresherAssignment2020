package assignmentQ1;

import java.util.ArrayList;
import assignmentQ1.model.Item;
public class Inventory {
    private static ArrayList<Item> arrayListItems = new ArrayList<Item>();

    public static void main(String[] args) {

    }
//    to calc tax of all items
    private static void calculateTax() {
        for (Item arrayListItem: arrayListItems) {
            double salesTax = getCalculatedTax(arrayListItem.type, arrayListItem.price);
        }
    }

//    select rule
    private static double getCalculatedTax(int type, double price){
       return 0;
    }
}

