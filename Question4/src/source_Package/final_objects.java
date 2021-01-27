package source_Package;


//This the final type of object that contains sales_tax and final_price
public class final_objects {
    private String item_name;
    private int item_quantity;
    private double item_price;
    private String item_type;
    private double item_tax;
    private double item_final_price;
    final_objects(String item_name,int item_quantity,double item_price,String item_type,double item_tax,double item_final_price)
    {
        this.item_name = item_name;
        this.item_quantity = item_quantity;
        this.item_price = item_price;
        this.item_type = item_type;
        this.item_tax = item_tax;
        this.item_final_price = item_final_price;
    }  
    
    public String get_name()
    {
    	return item_name;
    }
    
    public int get_quantity()
    {
    	return item_quantity;
    }
    
    public double get_price()
    {
    	return item_price;
    }
    
    public double get_sales_tax()
    {
    	return item_tax;
    }
    
    public double get_final_price()
    {
    	return item_final_price;
    }
    
    public String get_type()
    {
    	return item_type;
    }
}
