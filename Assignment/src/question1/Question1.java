
package question1;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

    

    class ItemServices{

  
    
    ArrayList<Item> itemList=new ArrayList<>();

   

  
    Scanner sc=new Scanner(System.in);
    String error="Incorrect Input!!! Try Again";
    public Item readItem(){
        Item item=new Item();
        out.println("Enter name");
        String name=sc.next();
        item.setName(name);

    
    while(true){
        try{
            double price=item.readPrice();
            item.setPrice(price);
            break;
        }
        catch(NumberFormatException e){
            System.out.println(error);
        }
    }
        
    while(true){
        try{
            int quantity=item.readQuantity();
            item.setQuantity(quantity);
            break;
        }
        catch(NumberFormatException e){
            System.out.println(error);
        }
    }
    
    
    
    out.println("Enter Type (Raw, Manufactured,Imported)");
    String type=sc.next();
    item.setType(type);
    while(!item.validateType()){
        out.println(error);
        item.setType(sc.next().toLowerCase());
    }
  
    double taxes=item.calculateTaxes();
    item.setTaxes(taxes);
    return item;
       
    }

    public ArrayList<Item> readItems()
    {
        Item newItem;
        String ans="y";
        while("y".equals(ans) || "Y".equals(ans))
        {
            newItem = readItem();
            itemList.add(newItem);
            out.println("Do you want to enter details of any other item (y/n):");
            ans=sc.next();
            
        }
        return itemList;
    }
}
public class Question1 {
    Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args) {
        
        ItemServices service = new ItemServices();
        service.readItems();
        ArrayList<Item> items=service.itemList;
        System.out.println("Item\tPrice\tTaxes\tFinal Price");
        for(Item item:items)
        {
            double price=Math.round(item.getPrice());
            double taxes=Math.round(item.getTaxes());
            double finalPrice=price+taxes;
            String outputItem=item.getName()+"\t"+price+"\t"+taxes+"\t"+finalPrice;
            System.out.println(outputItem);
        }
        
        
    }
    
}
