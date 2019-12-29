package Assignment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        InventoryManager inventoryManager = new InventoryManager();
        String ch="";
        do{
            inventoryManager.readData();
            System.out.println("Do you want to add one more item (yes/no) : ");
            ch = scan.nextLine();
        }while( ch.equals("yes") );

        inventoryManager.displayDetails();
    }
}
