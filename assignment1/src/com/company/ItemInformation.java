package assignment1.src.com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemInformation {
    private List<Item> arrayList= new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    protected double tax;

    void input(){
        InputCheck inputCheck = new InputCheck();
        System.out.println("Enter Item details: ");
        char  valid;
        Boolean check = Boolean.TRUE;
        while(check){
            Item item = new Item();
            do {
                System.out.print("Name: ");
                item.setName(input.next());
            } while (inputCheck.checkName(item.getName()));

            String x;
            do {
                System.out.print("Quantity: ");
                x = input.next();
            } while (inputCheck.checkQuantity(String.valueOf(x)));
            item.setQuantity(Integer.parseInt(x));

            String y;
            do {
                System.out.print("Price: ");
                y = input.next();
            } while(inputCheck.checkPrice(String.valueOf(y)));
            item.setPrice(Double.parseDouble(y));

            do {
                System.out.print("Type: ");
                item.setType(input.next());
            } while (inputCheck.checkType(item.getType()));
            arrayList.add(item);

            System.out.println("Do you want to enter details of any other item (y/n):");
            valid = input.next().charAt(0);
            if( valid =='n' || valid == 'N' ){
                System.out.println("End Input");
                check = Boolean.FALSE;
            }
            else if( valid =='y' || valid == 'Y' )
                continue;
        }
    }

    void display(){
        TaxEvaluation te = new TaxEvaluation();
        for(Item item:arrayList){

           //tax calculation method call
            if( item.getType() == "raw" )
                tax = te.calculateRawTax(item.getPrice());
            else if( item.getType() == "manufactured")
                tax = te.calculateManufacturedTax(item.getPrice());
            else if( item.getType() == "imported")
                tax = te.calculateImportedTax(item.getPrice());

            System.out.println("Name :\t" +item.getName() + "\tQuantity :\t" + item.getQuantity() + "\tPrice :\t" +item.getPrice() + "\tType :\t" + item.getType() + "\tTax :" + tax);
        }
    }

}
