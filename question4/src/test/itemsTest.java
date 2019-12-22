package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import question4.items;

class itemsTest {

	@Test
	void test() {
		
		items item = new items("Redmi",2,10000,"raw");
		
		assertNotNull(item);
		assertNotNull(item.getName(),"Name is Required");
		assertNotNull(item.getType(),"Type is Mandatory");
		assertEquals("Redmi", item.getName(),"Item name is not Matching");
		assertEquals(2,item.getQuantity(),"Item quantity is not Matching");
		assertEquals(10000,item.getPrice(),"Item Price is not Matching");
		assertEquals("raw",item.getType(),"Item Type is not Matching");
		
		items item1 = new items("Iphone",1,12000,"raw");
		float expected = 1500;
		assertEquals(expected, item1.calculateTax(12000, item1.getType()));
		float expectedFinalPrice=13500;
		assertEquals(expectedFinalPrice,(item1.getPrice()+item1.calculateTax(item1.getPrice(), item1.getType()))*item1.getQuantity());
		
		items item2 = new items("BackCase",2,249,"manufactured");
		expected=87.15f;
		assertEquals(expected, item2.calculateTax(249, item2.getType()));
		expectedFinalPrice=672.3f;
		assertEquals(expectedFinalPrice,(item2.getPrice()+item2.calculateTax(item2.getPrice(), item2.getType()))*item2.getQuantity());
		
		items item3 = new items("One Plus",2, 37000,"imported");
		expected=2035;
		assertEquals(expected, (float)item3.calculateTax(37000, item3.getType()));
		expectedFinalPrice=78070.0f;
		assertEquals(expectedFinalPrice,(item3.getPrice()+item3.calculateTax(item3.getPrice(), item3.getType()))*item3.getQuantity());
		
		
	}

}
