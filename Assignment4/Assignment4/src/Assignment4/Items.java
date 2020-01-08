package Assignment4;

public class Items {

    String name;
    int quantity;
    double price;
    String type;
    double tax=0;

    public Items() {}

    public Items(String name, int quantity, double price, String type) {
        this.name=name;
        this.quantity=quantity;
        this.price= price;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public double calculateTax(String type, double price){
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
    public double getTax(){
        return tax;
    }
    public double getFinalPrice(){
        return price+tax;
    }
    @Override
    public String toString() {
        return "[name=" + name + ", quantity=" + quantity + ", price=" + price + ", type=" + type + "]";
    }


}