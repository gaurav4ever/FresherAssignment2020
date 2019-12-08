package assignment4;

import assignment1.Item;

public class CalculateTaxThread implements Runnable {
	int totalRows;
	public CalculateTaxThread(int totalRows) {
		this.totalRows=totalRows;
	}
	@Override
	public void run() {
		int count = 0;
		while(count<totalRows) {
			synchronized(Assignment4.items) {
				try {
					if(Assignment4.itemsUpdatedCount>=Assignment4.itemsRead)
							Assignment4.items.wait();
					Item item = Assignment4.items.get(count);
					float salesTax = item.getSalesTax();
					Assignment4.itemsUpdated.put(item,salesTax);
					Assignment4.itemsUpdatedCount+=1;
					count++;
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
