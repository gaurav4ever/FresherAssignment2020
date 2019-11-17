/*
 * Created by Manu KJ 
 */
package Assignment1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class TestAssignment1 {

	@Test
	void test_for_type_row() {

		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "dsds");
		params.put("type", "raw");
		params.put("price", "55");
		params.put("quality", "3");
		Items it = new Items(params);
		it.calculate_tax();
		assertEquals(6.875, it.getTax());
	}

	@Test
	void test_for_type_imported() {

		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "dsds");
		params.put("type", "imported");
		params.put("price", "55");
		params.put("quality", "3");
		Items it = new Items(params);
		it.calculate_tax();
		assertEquals(10.5, it.getTax());
	}

	@Test
	void test_with_mixed_order() {
		String args[] = "-name itemdd -type imported -quality 2 -price 50 ".split(" ");
		// assertEquals(0,Assignment1.main(args),"Type valued is mandatory");
		try {
			assertEquals(1, Assignment1.main(args));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void test_with_no_type_argument() {
		String args[] = "-name item1 -price 50 -quality 2".split(" ");
		// assertEquals(0,Assignment1.main(args),"Type valued is mandatory");
		assertThrows(Exception.class, () -> Assignment1.main(args));
	}

}
