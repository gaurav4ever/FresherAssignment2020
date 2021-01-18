package com.company.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String s;
        Details d = new Details();
	    System.out.println("Command line options : ");
	    System.out.println("-name ItemName");
        System.out.println("-price ItemPrice");
        System.out.println("-quantity ItemQuantity");
        System.out.println("-type ItemType");

        do{
            d.input();
            System.out.println("More Items? : y/n");
            s = input.nextLine();

        }while(s.equals("y"));

        d.DisplayItems();
    }
}
