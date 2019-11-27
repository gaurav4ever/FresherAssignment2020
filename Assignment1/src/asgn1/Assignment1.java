//Assignment 1 completed
package asgn1;

import java.util.Scanner;

public class Assignment1 {
	public static void main(String args[]) {
		var sc=new Scanner(System.in);
		int i=1;
		double tax=0;
		double cost=0;
//loop continues to take item input and give output until user chooses 'n'		
		while (2>i) {
		System.out.print("Enter an item: ");
		String name=sc.next();
		double price=0.0;
		int quantity=0;
		String type="raw";
//Since the input order can be random. here we distinguish the type of the input and save it in a variable accordingly.
//it is assumed that item price is entered as a double value and not an integer. 
		for(int j=0;j<3;j++) {
			if (sc.hasNextInt()) { quantity=sc.nextInt();}
			else if (sc.hasNextDouble()) { price=sc.nextDouble();}
			else if (sc.hasNext()) { type=sc.next();}
		}
		//System.out.println("The item is: " +name+"  price: "+price+"  type: "+type+"  quantity: "+quantity);

//calculating tax for the item according to its type		
		if (type.equalsIgnoreCase("raw")){
			tax=calRawTax(price);
			cost=(price+tax)*quantity;
		}
		else if (type.equalsIgnoreCase("manufactured")){
			tax=calManufacturedTax(price);
			cost=(price+tax)*quantity;
		}
		else if (type.equalsIgnoreCase("imported")){
			tax=calImportedTax(price);
			cost=(price+tax)*quantity;
		}
		else {
			System.out.println("Invalid item type.");
			continue;
		}
//printing output
		System.out.println("The item is: " +name+"  price: "+price+"  tax liablity: "+tax+"  final cost: "+cost);
		
		System.out.print("Do you want to add another item (y/n) : ");
		char choice=sc.next().charAt(0);
//if the user chooses n, loop terminates
		if (choice=='n') { i=9;}
		
		} //end of while loop

		System.out.print("end of the program.");
	}
	
	//method to calculate tax for raw item type
	public static double calRawTax(double price) {
		double tax=0.125*price;
		return tax;
	}
	//method to calculate tax for manufactured item type
	public static double calManufacturedTax(double price) {
		double tax=(price+0.125*price)*0.02 + 0.125*price;
		return tax;
	}
	//method to calculate tax for imported item type
	public static double calImportedTax(double price) {
		double surcharge=0;
		double tax=price*0.1 + 0.125*price;
		if (price+tax <100) {surcharge=5;}
		else if (price+tax <200) {surcharge=10;}
		else if (price+tax >=200) {surcharge=0.05*(price+tax);}
		tax=tax+surcharge;
		return tax;
	}
}

