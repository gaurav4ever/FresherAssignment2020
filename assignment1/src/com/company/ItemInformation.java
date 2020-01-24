package assignment1.src.com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemInformation {
    private List<Item> arrayList= new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private Item item;
    protected double tax;

    ItemInformation(){
        item = new Item();
    }

    public void input() {
        final InputCheck inputCheck = new InputCheck();
        System.out.println("Enter Item details: ");
        char  valid;
        Boolean check = Boolean.TRUE;
        while(check){
            do {
                System.out.print("Name: ");
                item.setName(input.next());
            } while (inputCheck.checkName(item.getName()));

            String tempRead;
            do {
                System.out.print("Quantity: ");
                tempRead = input.next();
            } while (inputCheck.checkQuantity(String.valueOf(tempRead)));
            item.setQuantity(Integer.parseInt(tempRead));

            do {
                System.out.print("Price: ");
                tempRead = input.next();
            } while(inputCheck.checkPrice(String.valueOf(tempRead)));
            item.setPrice(Double.parseDouble(tempRead));

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
            else if( valid =='y' || valid == 'Y' ) {
                continue;
            }
        }
    }

    public void display(){
        final TaxEvaluation taxEvaluation = new TaxEvaluation();
        for( final Item item : arrayList ){
           //tax calculation method call
            if( item.getType().equals("raw") ) {
                tax = taxEvaluation.calculateRawTax(item.getPrice());
            }
            else if( item.getType().equals("manufactured") ) {
                tax = taxEvaluation.calculateManufacturedTax(item.getPrice());
            }
            else if( item.getType().equals("imported") ) {
                tax = taxEvaluation.calculateImportedTax(item.getPrice());
            }
            System.out.println("Name :\t" +item.getName() + "\tQuantity :\t" + item.getQuantity() + "\tPrice :\t" +item.getPrice() + "\tType :\t" + item.getType() + "\tTax :" + tax);
        }
    }

}
