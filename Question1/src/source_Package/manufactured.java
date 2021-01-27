package source_Package;

public class manufactured extends item implements tax {

    manufactured(String name,double price,int quantity,String type)
	{
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
		calculate_tax(price);
	}
	
	public void calculate_tax(double price)
	{
		sales_tax = (0.125*price + 0.02*(price + 0.125*price))*quantity;
		final_price = (sales_tax + price*quantity);
	}
	
}
