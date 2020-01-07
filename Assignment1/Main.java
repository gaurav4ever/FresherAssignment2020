import java.lang.System;
import java.util.*;
import java.util.Scanner;

public class Main{

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Item_Values> ar = new ArrayList<Item_Values>();
        ItemInput items = new ItemInput();

        Boolean proceed = true;
        while (proceed) {
            ar.add(items.inputItems());
            System.out.println("Do you want to enter details of any other item (y/n):");
            String res = sc.next();
            if(res.equals("n")){
                proceed=false;
            }
            else if(res!="y"&&res!="n"){
                System.out.println("Please provide above answer either in the form of y or n.");
            }
        }

        System.out.println("Item\tPrice\tTax\tFinal Price");
        for (Item_Values item : ar) {
            System.out.println(item.getName() + "\t" + item.getPrice()+ "\t" + item.getTax() + "\t" + item.getFinalPrice());
        }

    }
}