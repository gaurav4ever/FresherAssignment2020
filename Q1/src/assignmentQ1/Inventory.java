package assignmentQ1;

import java.util.ArrayList;
import assignmentQ1.model.Item;
import assignmentQ1.services.CalculateTaxService;
import assignmentQ1.services.Tax;
import assignmentQ1.util.InputUtil;
import assignmentQ1.util.OutputUtil;

public class Inventory {
    private static ArrayList<Item> productList = new ArrayList<Item>();

    public static void main(String[] args) {
       try {
           productList = InputUtil.getInputItem();
           calculateTax();
       } catch (Exception e) {
            //prints exception which is caught
            System.out.println(e.getMessage());
        }
    }
//    to calc tax of all items
    private static void calculateTax() {
        for (Item arrayListItem : productList) {
            double salesTax = getCalculatedTax(arrayListItem.productType, arrayListItem.productPrice);
            double totalPrice = (arrayListItem.productPrice + salesTax) * arrayListItem.productQuantity;
            OutputUtil.printOutput(arrayListItem, salesTax, totalPrice);
        }
    }

//    select rule
    private static double getCalculatedTax(int type, double price){
        CalculateTaxService calculateTaxService = new Tax().getTax(type);
        return calculateTaxService.calculateTax(price);
    }
}

