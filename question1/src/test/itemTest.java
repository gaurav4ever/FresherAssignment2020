package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import question1.*;

class itemTest {

	@Test
	void testCalculateTax() {
		
		item item1 = new item("Nokia",1,3000,"raw");
		float expected = 375;
		assertEquals(expected, item1.calculateTax(3000, item1.getType()));
		float expectedFinalPrice=3375;
		assertEquals(expectedFinalPrice,item1.getFinalPrice());
		
		item item2 = new item("Nokia",2,6000,"manufactured");
		expected=2100;
		assertEquals(expected, item2.calculateTax(6000, item2.getType()));
		expectedFinalPrice=16200;
		assertEquals(expectedFinalPrice,item2.getFinalPrice());
		
		item item3 = new item("Nokia",2, 4567,"imported");
		expected=251.18501f;
		assertEquals(expected, (float)item3.calculateTax(4567, item3.getType()));
		expectedFinalPrice=(float)(4818.18501*2);
		assertEquals(expectedFinalPrice,item3.getFinalPrice());
	}

}
