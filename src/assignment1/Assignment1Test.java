package assignment1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class Assignment1Test {

	@Test
	void test_type_raw() {
		HashMap<String,String> hmap = new HashMap<String,String>();
		hmap.put("name","item1");
		hmap.put("type","raw");
		hmap.put("price","1000");
		hmap.put("quantity","5");
		try {
		Item item = new Item(hmap);
		assertEquals(125,item.getSalesTax());
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	void test_type_manufactured() {
		HashMap<String,String> hmap = new HashMap<String,String>();
		hmap.put("name","item2");
		hmap.put("type","manufactured");
		hmap.put("price","1000");
		hmap.put("quantity","5");
		try {
		Item item = new Item(hmap);
		assertEquals(147.5,item.getSalesTax());
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	void test_type_imported() {
		HashMap<String,String> hmap = new HashMap<String,String>();
		hmap.put("name","item3");
		hmap.put("type","imported");
		hmap.put("price","1000");
		hmap.put("quantity","5");
		try {
		Item item = new Item(hmap);
		assertEquals(155,item.getSalesTax());
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
