/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleiassign1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Nilesh Gajwani
 */
class NucleiAssign1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String input;
        int i = 1;
        System.out.println("------------------------------------------------------------");
        System.out.println("                 Welcome to the Inventory System            ");
        System.out.println("------------------------------------------------------------");
        System.out.println("Please follow the below mentioned rules to add or view inventory");
        System.out.println("-view    To view the current inventory");
        System.out.println("-next    To start adding a new item");
        System.out.println("-exit    To exit");
        System.out.println("Please make sure to add the name of the item first");
        System.out.println("-name <name of the item>");
        System.out.println("-price <price of the item>");
        System.out.println("-type <manufactured/raw/imported>");
        System.out.println("-quantity <quantitity of the item");
        System.out.println("Please note that item type and name are mandatory to log an item, other arguments are optional");
//        input = br.readLine();
//        input = input.trim();
//        if (input.equals("-view")) {
//
//        }

        //String endInput = "";
        ArrayList<imported_Item> importedItems = new ArrayList<imported_Item>();
        ArrayList<raw_Item> rawItems = new ArrayList<raw_Item>();
        ArrayList<manufactured_Item> manufacturedItems = new ArrayList<manufactured_Item>();
        String name = "";
        int quantity = 1;
        float price = 0.0f;
        String itemType = "";
        ItemType type = null;
        while (1 > 0) {

            //Item newItem;
            String itemInput = br.readLine().trim();
            if (itemInput.equals("-next")) {
                if (name.equals("")) {
                    System.out.println("No item entered");
                } else if (type == null) {
                    System.out.println("Type of item not entered");
                } else {

                    switch (type.toString()) {
                        case "Raw":
                            raw_Item newRawItem = new raw_Item(name, price, quantity);
                            rawItems.add(newRawItem);
                            System.out.println("Added:");
                            System.out.println(newRawItem.toString());
                            name = "";
                            price = 0.0f;
                            quantity = 1;
                            type = null;
                            break;
                        case "Manufactured":
                            manufactured_Item newManufacturedItem = new manufactured_Item(name, price, quantity);
                            manufacturedItems.add(newManufacturedItem);
                            System.out.println("Added:");
                            System.out.println(newManufacturedItem.toString());
                            name = "";
                            price = 0.0f;
                            quantity = 1;
                            type = null;
                            break;
                        case "Imported":
                            imported_Item newImportedItem = new imported_Item(name, price, quantity);
                            importedItems.add(newImportedItem);
                            System.out.println("Added:");
                            System.out.println(newImportedItem.toString());
                            name = "";
                            price = 0.0f;
                            quantity = 1;
                            type = null;
                            break;

                    }
                }
            } else if (itemInput.equals("-end")) {
                break;
            } else {
                String[] keywords = itemInput.split(" ");
                String key = keywords[0];
                String value = keywords[1];
                if (key.equals("-name")) {
                    name = value;
                    System.out.println("Entered:   " + name);
                }
                if (!(name.equals(""))) {
                    if (key.equals("-quant")) {
                        try {
                            quantity = Integer.parseInt(value);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid qunatity");
                        }
                    } else if (key.equals("-price")) {
                        try {
                            price = Float.parseFloat(value);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid price");
                        }
                    } else if (key.equals("-type")) {
                        try {
                            type = ItemType.valueOf(value);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid item type entered.. Please enter a valid item type");

                        }
                    }
                } else {
                    System.out.println("Please enter name of the item first");
                }
            }
        }

    }
}
