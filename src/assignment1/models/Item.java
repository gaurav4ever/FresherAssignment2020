package assignment1.models;

public class Item {
    public String name;
    public String type;
    public Double price;
    public Integer quantity;

    public Item(String name, String type){
        this.name = name;
        this.type = type;
        this.price = 0.0;
        this.quantity = 0;
    }
    public Item(String name, String type, Double price){
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = 0;
    }
    public Item(String name,String type,Integer quantity){
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = 0.0;
    }
    public Item(String name, String type, Double price, Integer quantity )throws Exception{
        if( name == null || name.isEmpty() ){
            throw new Exception("name should not be null or empty");
        }
        if(type == null || ! ( type.equals("raw") || type.equals("manufactured") || type.equals("imported"))){
            throw new Exception("type is mandatory and should raw/manufactured/imported");
        }
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public Double calculateTax(){
        Double tax = 0.0;

        if(type.equals("raw")){
            tax = 0.125 * price;
        }else if(type.equals("manufactured")){
            tax =  0.125  * price + 0.02 * ( price + 0.125 * price);
        }else if(type.equals("imported")){
            Double importDuty = 0.10 * price;
            Double itemCostWithImportDuty = price + importDuty;
            Double surcharge = 0.0;
            if(itemCostWithImportDuty <=100){
                surcharge =  5.0;
            }else if(itemCostWithImportDuty <=200){
                surcharge =  10.0;
            }else {
                surcharge = 0.05 * (itemCostWithImportDuty);
            }
            tax = importDuty + surcharge;
        }
        return tax;
    }

    public Double calculateFinalPrice(){
        return this.price + calculateTax();
    }

    public String toString(){
        return "Item name : " + name + " Item price : " + price +
                " Sales Tax Liability : " + calculateTax() +
                " Final Prize : " + calculateFinalPrice();
    }
}
