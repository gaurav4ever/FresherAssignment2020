package service;

//TODO: import exception and fix exception errors
import model.Item;

public class TaxService{
    
    public Item calculateTax(Item item) throws InvalidItemTypeException {
        String type = item.getType();
        double tax;
        switch(type) {
            case "raw":
                tax = item.getPrice()*(12.5/100);
                item.setTax(tax);
                break;
            case "manufactured":
                tax = item.getPrice()*12.5/100;
                tax += (item.getPrice() + tax)*2/100;
                item.setTax(tax);
                break;
            case "import":
                tax = item.getPrice()*10/100;
                if(tax + item.getPrice()<=100){
                    tax += 5;
                }
                else if(tax + item.getPrice()<=200){
                    tax += 10;
                }
                else {
                    tax += (item.getPrice() + tax)*5/100;
                }
                item.setTax(tax);
                break;
            default:
                throw new InvalidItemTypeException("Invalid Type for Item");
        }

        return item;
    }
}