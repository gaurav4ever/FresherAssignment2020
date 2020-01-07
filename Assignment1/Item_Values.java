import java.util.Scanner;

public class Item_Values
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
                    System.out.println("Type should be manufactured or imported or raw!");
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