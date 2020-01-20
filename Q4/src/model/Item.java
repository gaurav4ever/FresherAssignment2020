package model;

public class Item{
    private String name;
    private double price;
    private int quantity;
    private String type;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public double getTaxes() throws Exception{
        double tax = 0;
        if(type.equals("raw")){
            // 12.5% of the item cost
            tax = price*0.125;
        }

        else if(type.equals("manufactured")){
            // 12.5% of the item cost + 2% of (item cost + 12.5% of the item cost)
            double temp = price*0.125;
            tax = temp + 0.02*(price+temp);
        }

        else if(type.equals("imported")){
            /* 10% import duty on item cost + a surcharge (surcharge is: Rs. 5 if the final cost
             after applying tax & import duty is up to Rs. 100, Rs. 10 if the cost exceeds 100 and up to 200 and 5% of
             the final cost if it exceeds 200)*/
            if(price<=100){
                tax = price*0.1 + 5;
            }
            else if(price<=200){
                tax = price*0.1 + 10;
            }
            else{
                double temp = price*0.1;
                tax = temp + 0.05*(price+temp);
            }
        }

        return tax;
    }

    public void setTaxes(double tax){
        price += tax;
    }

}