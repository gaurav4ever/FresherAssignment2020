package source_Package;

//Base Class for different types of items
public class item {
	
	protected String name,type;
    protected int quantity;
	protected double price,sales_tax,final_price;
	
	public double get_price()
	{
		return price;
	}
	
	public double get_sales_tax()
	{
		return sales_tax;
	}
	
	public double get_final_price()
	{
		return final_price;
	}
	
	public int get_quantity()
	{
		return quantity;
	}
	
	public String get_name()
	{
		return name;
	}
	
	public String get_type()
	{
		return type;
	}
}
