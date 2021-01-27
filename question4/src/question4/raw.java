package question4;

public class raw extends items implements Tax {
	
	 public float calculateTax(float price) {
		 float tax=0.0f;
		 tax=(float)(0.125*price);
		 return tax;
	 }
}
