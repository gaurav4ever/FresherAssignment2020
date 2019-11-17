package question1;
import static java.lang.System.out;
import java.util.Scanner;

public class Item
{
    Scanner sc=new Scanner(System.in);
    private String name;
    private double price;
    private int quantity=0;
    private String type;
    private double taxes;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double readPrice() throws NumberFormatException{
    out.println("Enter Price");
    double price=Float.parseFloat(sc.next());
    return price;
}
    public int getQuantity() {
        
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int readQuantity() throws NumberFormatException{
    out.println("Enter quantity");
    int quantity=Integer.parseInt(sc.next());
    return quantity;
}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
     public boolean validateType(){
       
        return this.type.equals("raw") || this.type.equals("manufactured") || this.type.equals("imported");
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

  
    
    public double calculateTaxes(){
        double taxes=0;
        if(this.type.equals("raw"))
        {
            taxes=0.125* this.price;
        }
        else if(this.type.equals("manufactured")){
            /*
            12.5% of the item cost + 2% of (item cost + 12.5% of the item cost)
            =14.75% of price;
            */
            taxes=0.1475*this.price;
        }
        else 
        {
            taxes=1.1*this.price;
            
            //surcharge
            if(taxes<=100)
            {
                taxes+=5;
            }
            else if(taxes>200)
            {
                taxes=1.05*taxes;
            
        }
            else
            {
               taxes+=10;            }
       
    }
         return taxes;
    }
}