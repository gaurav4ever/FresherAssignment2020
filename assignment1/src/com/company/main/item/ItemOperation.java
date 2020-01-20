package com.company.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemOperation {
    private List<ItemModel> items = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    String name;
    Double price;
    int quantity;
    ItemModel.Type type;

    void inputCommand() {
        String command;

        System.out.println("Command line options : ");
        System.out.println("-name ItemName");
        System.out.println("-price ItemPrice");
        System.out.println("-quantity ItemQuantity");
        System.out.println("-type ItemType");

        do {
            validateInputCommand();
            System.out.println("More Items? : y/n");
            command = scan.next();
        } while (command.equals("y"));
    }

    void validateInputCommand() {
        ItemModel item = new ItemModel();
        System.out.println("Item details: ");
        for (int commandNumber = 0; commandNumber < 4; commandNumber++) {
            String command = scan.next();

            //Name verification
            if (command.equals("-name") && scan.hasNext()) {
                if (item.isNameFlag()) {
                    System.out.println("Item name already exists ");
                    commandNumber--;
                    scan.next();
                    continue;
                }
                name = scan.nextLine();
                item.setNameFlag(true);
                item.setName(name);
                System.out.println("Name is added");
            }

            //Price verification
            else if (command.equals("-price") && scan.hasNext()) {
                if (item.isPriceFlag()) {
                    System.out.println("Item Price already exists ");
                    commandNumber--;
                    scan.next();
                    continue;
                }
                price = scan.nextDouble();
                item.setPriceFlag(true);
                item.setPrice(price);
                System.out.println("Price is added");
            }

            //Quantity verification
            else if (command.equals("-quantity") && scan.hasNext()) {
                if (item.isQuantityFlag()) {
                    System.out.println("Item Quantity is already exists ");
                    commandNumber--;
                    scan.next();
                    continue;
                }
                quantity = scan.nextInt();
                item.setQuantityFlag(true);
                item.setQuantity(quantity);
                System.out.println("Quantity is added");
            }

            //Type verification
            else if (command.equals("-type") && scan.hasNext("RAW|IMPORTED|MANUFACTURED")) {
                if (item.isTypeFlag()) {
                    System.out.println("Item Type is already exists ");
                    commandNumber--;
                    scan.next();
                    continue;
                }
                type = ItemModel.Type.valueOf(scan.next());
                item.setTypeFlag(true);
                item.setType(type);
                System.out.println("Type is added");
            } else {
                System.out.println("Enter valid commands : ");
                commandNumber--;
                scan.next();
            }
        }
        item.setTax(new TaxCalculator().getTax(item));
        items.add(item);
    }

    public void displayItems() {
        System.out.println("------------------------------------------------------");
        System.out.println("NAME\t\tPRICE\t\tTAX\t\t\tFINAL PRICE");
        System.out.println("------------------------------------------------------");
        for (ItemModel item : items)
            System.out.println(item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getTax() + "\t\t" + ((item.getPrice() * item.getQuantity()) + item.getTax()));
        System.out.println("------------------------------------------------------");
    }
}
