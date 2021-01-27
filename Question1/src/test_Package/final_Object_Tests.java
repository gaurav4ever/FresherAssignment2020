package test_Package;

import static org.junit.Assert.*; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import source_Package.start;
import source_Package.item;

//Tests for Three different types of inputs
public class final_Object_Tests {
	
	static int num=0;
	double sales_tax[] = {2500,15500,1475};
	double final_price[] = {22500,115500,11475};

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting New Test *******************************************************");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending Test **************************************************************");
	}

	@Test
	public void test_one() {
		
		System.out.println("Inside First Test");
		item i = start.test_func("-name Laptop -quantity 1 -price 20000 -type raw");
		assertNotNull("Value of Object Returned is Null",i);
		assertEquals("Names are not Equal",i.get_name(),"Laptop");
		assertEquals("Type Not Equal",i.get_type(),"raw");
		assertEquals("Price Not Equal",(int)i.get_price(),20000);
		assertEquals("Quantity Not Equal",i.get_quantity(),1);
		assertEquals("Sales Tax Not Equal",(int)i.get_sales_tax(),(int)sales_tax[num]);
		assertEquals("Final Price Not Equal",(int)i.get_final_price(),(int)final_price[num]);
		++num;
	}

	@Test
	public void test_two() {
		
		System.out.println("Inside Second Test");
		item i = start.test_func("-name Car -quantity 2 -price 50000 -type imported");
		assertNotNull("Value of Object Returned is Null",i);
		assertEquals("Names are not Equal",i.get_name(),"Car");
		assertEquals("Type Not Equal",i.get_type(),"imported");
		assertEquals("Price Not Equal",(int)i.get_price(),50000);
		assertEquals("Quantity Not Equal",i.get_quantity(),2);
		assertEquals("Sales Tax Not Equal",(int)i.get_sales_tax(),(int)sales_tax[num]);
		assertEquals("Final Price Not Equal",(int)i.get_final_price(),(int)final_price[num]);
		++num;
	}
	
	@Test
	public void test_three() {
		
		System.out.println("Inside Third Test");
		item i = start.test_func("-name Chair -quantity 10 -price 1000 -type manufactured");
		assertNotNull("Value of Object Returned is Null",i);
		assertEquals("Names are not Equal",i.get_name(),"Chair");
		assertEquals("Type Not Equal",i.get_type(),"manufactured");
		assertEquals("Price Not Equal",(int)i.get_price(),1000);
		assertEquals("Quantity Not Equal",i.get_quantity(),10);
		assertEquals("Sales Tax Not Equal",(int)i.get_sales_tax(),(int)sales_tax[num]);
		assertEquals("Final Price Not Equal",(int)i.get_final_price(),(int)final_price[num]);
	}
	
}
