import java.util.ArrayList;
import java.util.List;


public class CalculateTax extends DatabaseConnection implements Runnable {
	public List<Item> itemTax=new ArrayList<Item>();
	public Item calculateTax(Item item){
		String type=item.getType();
		double tax;
		switch(type) {
		case "raw" : 
			tax=item.getPrice()*(12.5/100);
			item.setTax(tax);
			item.setOverallTax(tax*item.getQuantity());
			break;
		case "manufactured" :
			tax=item.getPrice()*(12.5/100);
			tax = tax + (item.getPrice() + tax)*2/100;
			item.setTax(tax);
			item.setOverallTax(tax*item.getQuantity());
			break;
		case "imported" : 
			tax = item.getPrice()*10/100;
			if(tax+item.getPrice() <= 100) {
				tax+=5;
			}
			else if(tax+item.getPrice() <= 200) {
				tax+=10;
			}
			else {
				tax+=(item.getPrice() + tax)*5/100;
			}
			item.setTax(tax);
			item.setOverallTax(tax*item.getQuantity());
			break;
		//default	: 
			//throw new InvalidItemException("This type of item does not exist. Please re-enter.");
		}
		return item;
	}
	
	@Override
	public void run() {
		try
		{
			boolean threadEnd = false;
			int index = 0;
			while(true){
				
				System.out.println("Thread for Calculate Tax is running");
				
//				
				while(!(Main.items.isEmpty())&&index<Main.items.size()) {
					try {
						Item item = Main.items.get(index);
						item = calculateTax(item);
						itemTax.add(item);
						index++;
					}
					catch(Exception ex) {
						ex.printStackTrace();
						
					}
				}
				System.out.println(itemTax);
				if(threadEnd)
					break;
				if(!Main.thread1.isAlive())
					threadEnd = true;
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}
