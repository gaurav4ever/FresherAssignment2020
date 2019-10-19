package assignment1;

import assignment1.exceptions.InvalidCommandLineArgument;
import assignment1.models.ItemDetail;

import java.util.Scanner;

class ItemManager {

    private void displayItem(ItemDetail itemDetail){
        System.out.println("========    Item Details    ========");
        System.out.println("Name = " + itemDetail.getItem().getName());
        System.out.println("Type = " + itemDetail.getItem().getClass().getSimpleName());
        if(itemDetail.getItem().getPrice()!=null) System.out.println("Price = " + itemDetail.getItem().getPrice());
        System.out.println("Quantity = " + itemDetail.getQuantity());
        System.out.println("Sales tax = " + itemDetail.getItem().getTax());
        System.out.println("Final Price = " + (itemDetail.getItem().getPrice()+itemDetail.getItem().getTax())) ;
        System.out.println("====================================");
        System.out.println("\n");
    }

    private void promptForNewItemUntilExit(){
        System.out.println("Do you want to enter details of any other item (y/n): ");
        Scanner scan = new Scanner(System.in) ;
        String choice = scan.nextLine() ;

        while(choice.equals("y")){
            System.out.println("Enter name of item : ") ;
            String name = scan.nextLine() ;
            System.out.println("Enter type of item [ raw , manufactured , imported ] : ") ;
            String type = scan.nextLine() ;
            System.out.println("Enter price of item : ") ;
            String price = scan.nextLine() ;
            System.out.println("Enter quantity of item : ") ;
            String quantity = scan.nextLine() ;

            String[] arguments = new String[]{"-name" , name , "-type" , type , "-price" , price , "-quantity" , quantity} ;
            ItemDetail itemDetail = CommandLineParser.parse(arguments) ;
            displayItem(itemDetail);

            System.out.println("Do you want to enter details of any other item (y/n): ");
            choice = scan.nextLine() ;
        }
        System.out.println("Exiting ... Cya :)");
        System.exit(0) ;
    }

    void startManager(String[] args) {
        try {
            ItemDetail itemDetail =  CommandLineParser.parse(args);
            displayItem(itemDetail);
            promptForNewItemUntilExit();
        } catch (InvalidCommandLineArgument e) {
            System.out.println("Invalid input for Item : " + e.getMessage());
            System.exit(1);
        }
    }
}
