package util;
import model.Item;
import java.util.Scanner;
import exception.InvalidItemTypeException;
import service.CalculateTaxObject;

public class InputItemUtil {
Scanner s = new Scanner(System.in);
	
	public Item inputItem() {
		Item item = new Item();
	
		System.out.println("Please Enter the details of the item:-");
		System.out.print("-name : ");
		item.setItemName(s.nextLine());
		System.out.print("-price : ");
		item.setItemPrice(s.nextDouble());
		System.out.print("-quantity : ");
		item.setItemQuantity(s.nextInt());
		System.out.print("-type : ");
		item.setItemType(s.next());
		
		return item;
	
	}
	
	public char isNext() {
		System.out.println("Do you want to add more items? (y/n)");
		char ch = s.next().charAt(0);
		if(ch == 'y' || ch == 'Y' || ch =='n' || ch == 'N') {
			s.nextLine();
			return ch;
		}
		else {
			System.out.println("Invalid Option! Please Choose Again.");
			return isNext();
		}
	}
	
	public void run() {
		CalculateTaxObject obj= new CalculateTaxObject();
		InputItemUtil obj1 = new InputItemUtil();
		OutputItemUtil obj2 = new OutputItemUtil();
		Item item = null;
		char ch = 'y';
		while(true) {
			item = obj1.inputItem();
			try {
				item = obj.calculateTax(item);
			}
			catch(InvalidItemTypeException e) {
				e.printStackTrace();
			}
			obj2.itemOutput(item);
			ch = obj1.isNext();
			if(ch == 'N' || ch == 'n')
				break;
		}
	}
}
