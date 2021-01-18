package Question1;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {
	
	 static class Details {
		private String name;
		private double price;
		private int quantity;
		private String type;
		private double tax;
		Details(String name,double price,int quantity,String type,double tax) {
		    this.name=name;
			this.price=price;
			this.quantity=quantity;
			this.type=type;
			this.tax=tax;
		}
	}
	
    public static Details getItemDetails(String[] args) {
    	String name="";
    	double price=0.0;
    	int quantity=0;
    	String type="";
    	for(int i=0;i<args.length;i++) {
    		//check if all the fields have correct values 
    		try {
    			if("-name".compareTo(args[i])==0 && "-type".compareTo(args[i+1])!=0 && "-price".compareTo(args[i+1])!=0 && "-quantity".compareTo(args[i+1])!=0) {
    				name=args[i+1];
    				i=i+1;
    			}
    		} catch (ArrayIndexOutOfBoundsException e) {
    			System.out.println("Value not entered!");
    			System.exit(0);
    		}
    		try {
    			if("-type".compareTo(args[i])==0 && "-price".compareTo(args[i+1])!=0 && "-quantity".compareTo(args[i+1])!=0 && "-name".compareTo(args[i+1])!=0) {
    				type=args[i+1];
    				i=i+1;
    			}
    		} catch (ArrayIndexOutOfBoundsException e) {
    			System.out.println("Value not entered!");
    			System.exit(0);
    		}
    		try {
    			if("-price".compareTo(args[i])==0 && "-type".compareTo(args[i+1])!=0 && "quantity".compareTo(args[i+1])!=0 && "-name".compareTo(args[i+1])!=0) {
    				try {
    					price=Double.parseDouble(args[i+1]);
    					i=i+1;
    				} catch (NumberFormatException e) {
    					System.out.println("Invalid Input!");
    					System.exit(0);
    				}
    			}
    		} catch (ArrayIndexOutOfBoundsException e) {
    			System.out.println("Value not entered!");
    			System.exit(0);
    		}
    		try {
    			if("-quantity".compareTo(args[i])==0 && "-type".compareTo(args[i+1])!=0 && "-price".compareTo(args[i+1])!=0 && "-name".compareTo(args[i+1])!=0) {
    				try {
    					quantity=Integer.parseInt(args[i+1]);
    					i=i+1;
    				} catch (NumberFormatException e) {
    					System.out.println("Invalid Input!");
    					System.exit(0);
    				}
    			}
    		} catch (ArrayIndexOutOfBoundsException e) {
    			System.out.println("Value not entered!");
    			System.exit(0);
    		}
    	}
    	double tax=calculateTax(type,price);
    	Details obj=new Details(name,price,quantity,type,tax);
    	return obj;
    }
    
    public static double calculateTax(String type,double price) {
    	double tax=0.0;
    	if(price!=0) {
    		switch(type) {
    		case "raw": tax=0.125*price;
    		      break;
    		case  "manufactured": tax=0.125*price + (0.02*(price+0.125*price));
    		      break;
    		case "imported": tax=price*0.1;
    		                 double surcharge=0.0;
    		                 double final_price=price+tax;
    		                 if(final_price<=100) {
    		                	 surcharge=5;
    		                 }
    		                 else if(final_price<=200) {
    		                	 surcharge=10;
    		                 }
    		                 else {
    		                	 surcharge=0.05*final_price;
    		                 }
    		                 tax=tax+surcharge;
    		        break;
    		default: System.out.println("Wrong type field!");
    		         System.exit(0);
    	}
    	}
    	return tax;	   
    }
    
    public static void printDetails(ArrayList<Details> items) {
    	for(int i=0;i<items.size();i++) {
    		Details item_detail=items.get(i);
    		if(item_detail.type=="") {
        		System.out.println("Missing type field!");
        		continue;
        	}
    		if(item_detail.name=="") {
    			System .out.println("name not entered!");
    		}
    		else {
    			System.out.println("Item name is "+item_detail.name);
    		}
    		System.out.println("Item price is "+item_detail.price);
    		System.out.println("Tax per item is "+item_detail.tax);
    		System.out.println("Total price is "+(item_detail.price+item_detail.tax));
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Details> items = new ArrayList<Details>();
        Scanner sc=new Scanner(System.in);
        char choice='n';
        do {
        	System.out.println("Enter new item details:");
        	String input=sc.next();
        	input+=sc.nextLine();
        	String inputArray[]=input.split(" ");
        	Details item_detail=getItemDetails(inputArray);
        	items.add(item_detail);
        	System.out.println("Do you want to enter details of other items (y/n):");
        	choice=sc.next().charAt(0);
        } while(choice=='y');
        printDetails(items);
	}

}