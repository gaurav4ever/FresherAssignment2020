package assignment1;

import assignment1.exceptions.InvalidCommandLineArgument;

import java.util.Scanner;

class ItemManager {

    private void displayItem(ItemDetail itemDetail){
        System.out.println("========    Item Details    ========");
        System.out.println("Name = " + itemDetail.item.getName());
        System.out.println("Type = " + itemDetail.item.getClass().getSimpleName());
        if(itemDetail.item.getPrice()!=null) System.out.println("Price = " + itemDetail.item.getPrice());
        System.out.println("Quantity = " + itemDetail.quantity);
        System.out.println("Sales tax = " + itemDetail.item.getTax());
        System.out.println("Final Price = " + (itemDetail.item.getPrice()+itemDetail.item.getTax())) ;
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
