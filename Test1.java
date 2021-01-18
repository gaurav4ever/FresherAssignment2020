package Assignment1;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
public class Test1 {
	Details obj = new Details();
	@Test
	void test_type_raw() {
		try {
			obj.setType("raw");
			obj.setPrice(800); 
			obj.calculateTax();
			assertEquals(100,obj.getTax());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void test_type_manufactured() {
		try {
			obj.setType("manufactured");
			obj.setPrice(300); 
			obj.calculateTax();
			assertEquals(44.25,obj.getTax());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void test_type_imported() {
		try {
			obj.setType("imported");
			obj.setPrice(1000); 
			obj.calculateTax();
			assertEquals(155,obj.getTax());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

