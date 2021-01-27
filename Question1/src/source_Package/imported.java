package source_Package;

public class imported extends item implements tax {
	
	imported(String name,double price,int quantity,String type)
	{
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
		calculate_tax(price);
	}
	
	public void calculate_tax(double price)
	{
		sales_tax = 0.1*price;
		if(sales_tax+price<=100)
		{
			sales_tax+=5;
		}
		else if((sales_tax+price)>100 && (sales_tax+price)<=200)
		{
			sales_tax+=10;
		}
		else
		{
			sales_tax+=0.05*(sales_tax+price);
		}
		sales_tax = sales_tax*quantity;
		final_price = sales_tax + (price*quantity);
	}

}