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
            if( name == null || name.isEmpty() ){
                System.out.println("name should not be null or empty");
                continue;
            }

            System.out.print(" -price : ");
            Double price = sc.nextDouble();

            System.out.print(" -quantity : ");
            int quantity = sc.nextInt();

            System.out.print(" -type : ");
            String type = sc.next();
            try {
                Item item = null;
                if(type.equals("raw")) {
                    item = new RawItem(name, price, quantity);
                }else if(type.equals("manufactured")){
                    item = new ManufacturedItem(name, price, quantity);
                }else if(type.equals("imported")){
                    item = new ImportedItem(name,price,quantity);
                }else{
                    System.out.println("type is mandatory and should raw/manufactured/imported");
                    continue;
                }
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
