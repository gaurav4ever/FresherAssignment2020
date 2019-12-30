import java.lang.System;
import java.util.*;
import java.text.DecimalFormat;
import java.util.Scanner;

class Item
{ 
	String name; 
	double price; 
	int quantity;
        String type;
        double tax = 0;

        Scanner sc = new Scanner(System.in);
	public void setName(String name){
            this.name = name;
        }
        
        public String getName() 
	{ 
	return name; 
	} 

	public void setType(String type){
            while(true){
                if(!(type.equals("raw") || type.equals("manufactured") || type.equals("imported"))){
                    System.out.println("Please retype correct type!!");
                    type = sc.next().toLowerCase();
                }
                else
                    break;
            }
            this.type = type;
        }
        
        public String getType() 
	{ 
	return type; 
	}

	public void setPrice(double price){
            this.price = price;
        }
        
        public double getPrice(){
            return price;
        }
        
        public void setQuantity(int quantity){
            this.quantity = quantity;
        }
        
        public int getQuantity(){
            return quantity;
        }
        
        public double calculateTax(){
            if(type.equals("raw")){
                tax = 0.125*price;
            }
            else if(type.equals("manufactured")){
                tax = 0.1475*price;
            }
            else{
                tax = 0.125*price;
                if(tax<100)
                    tax+=5;
                else if(200<=tax)
                        tax+=0.05*tax;
                else
                    tax+=10;
            }
        
        return tax;
            
        }
        
        public void setTax(double tax){
            this.tax = tax;
        }
        
        public double getTax(){
            return tax;
        }
        
        public double getFinalPrice(){
            return price+tax;
        }
                    
  

} 

class ItemInput {

    public Item readItem() {

        Scanner sc = new Scanner(System.in);
        Item item = new Item();

        

        System.out.println("Item name:");
        item.setName(sc.next());

        System.out.println("Item price");
        
        item.setPrice(Double.parseDouble(sc.next()));
            
        

        System.out.println("Item quantity");
       
        item.setQuantity(Integer.parseInt(sc.next()));
             

        System.out.println("Item type:- raw, manufactured or imported:");
        item.setType(sc.next().toLowerCase());

        item.setTax(item.calculateTax());

        return item;

    }

}

public class Solution1{

    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Item> ar = new ArrayList<Item>();
        ItemInput items = new ItemInput();

        String choice = "y";
        while (choice.equals("y")) {
            ar.add(items.readItem());
            System.out.println("Do you want to enter details of any other item (y/n):");
            choice = sc.next();
        }

        System.out.println("Item\tPrice\tTax\tFinal Price");
        for (Item item : ar) {
            System.out.println(item.getName() + "\t" + df.format(item.getPrice()) + "\t" + df.format(item.getTax()) + "\t" + df.format(item.getFinalPrice()));
        }

    }
}