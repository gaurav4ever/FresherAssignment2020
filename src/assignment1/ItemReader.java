package assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import assignment1.Exceptions.InvalidArgumentFormatException;
import assignment1.Exceptions.InvalidNumberOfArgumentsException;
import assignment1.Exceptions.InvalidTypeValueException;
import assignment1.Exceptions.TypeNotProvidedException;

public class ItemReader {
	public static ArrayList<Item> getItems(String[] params) {
		ArrayList<Item> items = new ArrayList<Item>();
		char continueAdding='y';
		Scanner sc = new Scanner(System.in);
		try {
			items.add(getItem(params));
			while(true) {
				System.out.print("Do you want to enter details of any other item (y/n): ");
				continueAdding = sc.nextLine().charAt(0);
				if(continueAdding=='y') {
					System.out.println("Enter details of the item: ");
					String args=sc.nextLine();
					items.add(getItem(args.substring(0, args.length()).split(" ")));
				}
				else
					break;
			}
		}
		catch(InvalidTypeValueException itve) {
			System.out.println(itve.getMessage());
		}
		catch(TypeNotProvidedException tnpe) {
			System.out.println(tnpe.getMessage());
		}
		catch(InvalidArgumentFormatException ivafe) {
			System.out.println(ivafe.getMessage());
		}
		catch(InvalidNumberOfArgumentsException inoae) {
			System.out.println(inoae.getMessage());
		}
		sc.close();
		return items;
	}
	private static Item getItem(String[] params) throws InvalidTypeValueException,TypeNotProvidedException,InvalidArgumentFormatException,InvalidNumberOfArgumentsException {
		if(params.length%2!=0) {
			throw new InvalidNumberOfArgumentsException();
		}
		HashMap<String,String> paramMap = new HashMap<String,String>();
		for(int i=0;i<params.length;i+=2) {
			if(params[i].charAt(0)=='-') {
				paramMap.put(params[i].substring(1), params[i+1]);
			}
			else
				throw new InvalidArgumentFormatException();
		}
		if(!paramMap.containsKey("type")) {
			throw new TypeNotProvidedException();
		}
		if(!"raw".equals(paramMap.get("type"))&&!"imported".equals(paramMap.get("type"))&&!"manufactured".equals(paramMap.get("type"))) {
			throw new InvalidTypeValueException();
		}
		Item item;
		switch(paramMap.get("type")) {
		case "raw": item = new RawItem(paramMap); break;
		case "manufactured": item = new ManufacturedItem(paramMap); break;
		default: item = new ImportedItem(paramMap);
		}
		
		return item;
	}
}
