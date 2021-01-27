package com.nuclei.assignment.main;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.cli.*;
import com.nuclei.assignment.beans.Item;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String sent = "y";
		String name;
		double price;
		int quantity;
		String type;
		ArrayList<Item> list = new ArrayList<>();
		Options options = new Options();
		Option iname = new Option("name", "item name", true, "enter item name");
		iname.setRequired(true);
		options.addOption(iname);
		
		Option iprice = new Option("price", "item price", true, "enter item price");
		iprice.setRequired(true);
		options.addOption(iprice);
		
		Option iquantity = new Option("quantity", "item quantity", true, "enter item quantity");
		iquantity.setRequired(true);
		options.addOption(iquantity);
		
		Option itype = new Option("type", "item type", true, "enter item type");
		itype.setRequired(true);
		options.addOption(itype);
		
		CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }
		
        name = cmd.getOptionValue("name");
        price = Double.parseDouble(cmd.getOptionValue("price"));
        quantity = Integer.parseInt(cmd.getOptionValue("quantity"));
        type = cmd.getOptionValue("type");
        
		while(!type.equals("raw") && !type.equals("manufactured") && !type.equals("imported")) {
			System.out.println("Please enter valid item type \t raw, manufactured or imported");
			type = sc.nextLine();
		}
		list.add(new Item(name, price, quantity, type));
		System.out.print("Do you want to enter details of any other item (y/n): ");
		sent = sc.nextLine();
		while(sent.equals("y")) {
			name = sc.nextLine();
			price = sc.nextDouble();
			quantity = sc.nextInt();
			sc.nextLine();
			type = sc.nextLine();
			while(!type.equals("raw") && !type.equals("manufactured") && !type.equals("imported")) {
				System.out.println("Please enter valid item type \t raw, manufactured or imported");
				type = sc.nextLine();
			}
			list.add(new Item(name, price, quantity, type));
			System.out.print("Do you want to enter details of any other item (y/n): ");
			sent = sc.nextLine();
		}
		sc.close();
		for(Item a : list) {
			System.out.println(a);
		}
	}
}
