package question4;

public class imported extends items implements Tax{
	
	public float calculateTax(float price) {
		 float tax=0.0f;
		 tax=(float) (0.1*price);
			if(price+tax <= 100)
				tax=tax+5;
			else if (price+tax >100 && price+tax <=200)
				tax=tax+10;
			else 
				tax=(float)(0.05*(tax+price));
		 return tax;
	 }
}
