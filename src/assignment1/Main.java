package assignment1;

import assignment1.models.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        System.out.println("Enter the item details ");
        Boolean flag = true;
        ItemCollection items = new ItemCollection();

        while(true){
            System.out.print(" -name : ");
            String name  = sc.next();
            System.out.print(" -price : ");
            Double price = sc.nextDouble();
            System.out.print(" -type : ");
            String type = sc.next();
            System.out.print(" -quantity : ");
            int quantity = sc.nextInt();
            try {
                Item item = new Item(name, type, price, quantity);
                items.addItem(item);
                System.out.println("done : item added");
            }catch (Exception e){
                System.out.println(" failed : item is not added ");
                e.printStackTrace();
            }
            System.out.print("Do you want to add more items? (y/n)");
            String choice = sc.next();
            if(choice.equals("n")){
                break;
            }
        }
        items.displayItem();
    }
}
