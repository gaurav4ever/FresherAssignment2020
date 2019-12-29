package source_Package;

//This is the initial type of object that we get from MySQL with fields name,quantity,price,type 
public class sql_objects {
    
	private String item_name;
    private int item_quantity;
    private double item_price;
    private String item_type;
    
    sql_objects(String item_name,int item_quantity,double item_price,String item_type)
    {
        this.item_name = item_name;
        this.item_quantity = item_quantity;
        this.item_price = item_price;
        this.item_type = item_type;
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
    
    public String get_type()
    {
    	return item_type;
    }
}
