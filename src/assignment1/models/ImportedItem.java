package assignment1.models;

public class ImportedItem extends Item{
    public ImportedItem(String name){
        super(name);
    }
    public ImportedItem(String name,Integer quantity){
        super(name,quantity);
    }
    public ImportedItem(String name, Double price){
        super(name,price);
    }
    public ImportedItem(String name, Double price, Integer quantity){
        super(name,price,quantity);
    }
    @Override
    public Double calculateTax() {
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
        return importDuty + surcharge;
    }

}
