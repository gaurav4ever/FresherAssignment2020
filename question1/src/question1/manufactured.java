package question1;

public class manufactured extends item implements Tax{

	 public float calculateTax(float price)
	 {
		 float tax=0.0f;
		 float tax2=(float)(0.125*price);
		 float tax1=(float)(0.2 *(tax2+price));
		 tax=tax2+tax1;
		 return tax;
		 
	 }
	
}
