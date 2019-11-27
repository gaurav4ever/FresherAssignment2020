package assignment1;

import assignment1.exceptions.InvalidCommandLineArgument;
import assignment1.models.ItemDetail;

import java.util.Scanner;

class ItemManager {

    private void promptForNewItemUntilExit() {
        System.out.println("Do you want to enter details of any other item (y/n): ");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();

        while ("y".equals(choice)) {
            System.out.println("Enter name of item : ");
            String name = scan.nextLine();
            System.out.println("Enter type of item [ raw , manufactured , imported ] : ");
            String type = scan.nextLine();
            System.out.println("Enter price of item : ");
            String price = scan.nextLine();
            System.out.println("Enter quantity of item : ");
            String quantity = scan.nextLine();

            String[] arguments = new String[]{"-name", name, "-type", type, "-price", price, "-quantity", quantity};
            ItemDetail itemDetail = new CommandLineParser().getItemDetail(arguments);
            itemDetail.display();

            System.out.println("Do you want to enter details of any other item (y/n): ");
            choice = scan.nextLine();
        }
        System.out.println("Exiting ... Cya :)");
        System.exit(0);
    }

    void startManager(String[] args) {
        try {
            ItemDetail itemDetail = new CommandLineParser().getItemDetail(args);
            itemDetail.display();
            promptForNewItemUntilExit();
        } catch (InvalidCommandLineArgument e) {
            System.out.println("Invalid input for Item : " + e.getMessage());
            System.exit(1);
        }
    }
}
