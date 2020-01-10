package com.company.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Details {

    private List<Item> items = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    String name;
    Double price,quantity;
    Type type;
    public enum Type{
        RAW,IMPORTED,MANUFACTURED;
    }
   // Item its=new Item();
    void input()
    {
        Item item = new Item();

        System.out.println("Item details: ");
        for(int i=0;i<4;i++)
        {
            String command = input.next();
            if(command.equals("-name") && input.hasNext()){
                if(item.isNameFlag()) {
                    System.out.println("Item name already exists ");
                    i--;
                    input.next();
                    continue;
                }
                name = input.nextLine();
                item.setNameFlag(true);
                System.out.println("Name is added");
            }
            else if(command.equals("-price") && input.hasNext()){
                if(item.isPriceFlag()) {
                    System.out.println("Item Price already exists ");
                    i--;
                    input.next();
                    continue;
                }
                price = input.nextDouble();

                item.setPriceFlag(true);
                System.out.println("Price is added");
            }
            else if(command.equals("-quantity") && input.hasNext()){
                if(item.isQuantityFlag()) {
                    System.out.println("Item Quantity is already exists ");
                    i--;
                    input.next();
                    continue;
                }
                quantity=input.nextDouble();

                item.setPriceFlag(true);
                System.out.println("Quantity is added");
            }
            else if(command.equals("-type") && input.hasNext("RAW|IMPORTED|MANUFACTURED")){
                if(item.isTypeFlag()) {
                    System.out.println("Item Type is already exists ");
                    i--;
                    input.next();
                    continue;
                }
                //type=input.next("RAW|IMPORTED|MANUFACTURED");
                type = Type.valueOf(input.next());
                item.setTypeFlag(true);
                System.out.println("Type is added");
            }else{
                System.out.println("Enter valid commands : ");
                i--;
                input.next();
            }

        }
        item.Assign(name, price,quantity,type);
        item.setTax(new Tax().getTax(item));
        //items.add(item);
        addItem(item);
        System.out.println("Item added successfully");
    }

    public String addItem(Item item) {
        if(item.getName().equals(""))
            return "Please enter a valid name";
        if(item.getPrice()<0)
            return "Please enter valid price";
        if(item.getQuantity()<0)
            return "Please enter valid quantity";
        if(item.getType().equals(""))
            return "Please enter valid type";
    items.add(item);
    return "item added successfully";
    }

    public void DisplayItems()
    {
        System.out.println("NAME\t\tTAX\t\tPRICE\t\tFINAL PRICE");
        System.out.println("-----------------------------------------------------------------------------");
        for( Item item: items)
            System.out.println(item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getTax() + "\t\t" + (item.getPrice() + item.getTax()));
    }

    public static class Tax {
        public double getTax(Item item) {
            double tax=0;
            switch (item.getType()) {
                case RAW:
                    tax = item.getPrice() * 0.125;
                    break;
                case MANUFACTURED:
                    tax = item.getPrice() * 0.125 + (item.getPrice() * 0.125 + item.getPrice()) * 0.02;
                    break;
                case IMPORTED:
                    tax = 0.1 * item.getPrice();
                    if (tax <= 100) tax += 5;
                    else if (tax <= 200) tax += 10;
                    else tax += 0.05 * (item.getPrice() + tax);
                    break;
            }
            return tax*item.getQuantity();
        }
    }
}
