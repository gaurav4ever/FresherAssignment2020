package question4;

import test.*;
import java.util.ArrayList;

public class home {
	
	private int id;
	
	public home(int id) {
		this.id =id;
	}

	public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
		
		sqlOperationClass connect = new sqlOperationClass();
		RetrievalAndComputation retrieveAndCompute = new RetrievalAndComputation();
		connect.create();
		
		/*
		connect.createNewTable();
		connect.insert("iphone", 1, 12000, "raw");
		connect.insert("Back Case", 2, 249, "manufactured");
		connect.insert("one plus", 2, 37000, "imported");
		connect.insert("Acer", 1, 63000, "raw");
		connect.insert("Dell", 2, 70000, "imported");
		connect.insert("Nokia", 2, 10000, "imported");
	    connect.select();
		*/
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					retrieveAndCompute.select();
				} catch (InterruptedException e) {
					System.out.println("Exception while Reading from database");
				}
			}	
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					retrieveAndCompute.CalculateTaxAndUpdatePrice();
				} catch (InterruptedException e) {	
					System.out.println("Exception while Reading from database");
				}
			}
		});

		 t1.start();
		 t2.start();
		
		 t1.join(); 
	     	 t2.join();
	      
	     	 System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
	     	 System.out.println("Name"+"              "+"Quantity"+"       "+"Price"+"         "+"Type");
	     	 System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			
	      
	     	 for(items i1: retrieveAndCompute.finalPricedItems)
	     	  {
	    	      System.out.println(i1.getName()+"               "+i1.getQuantity()+"          "+i1.getPrice()+"          "+i1.getType());
		      System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

	     	  }
	      
	 }
}
