package test_Package;

import source_Package.start;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*Following are the values in the MYSQL Database taken as input :
Laptop 20000.0 1 raw
Car 50000.0 2 imported
Chair 1000.0 10 manufactured
Junit Testing was done based on these inputs
*/
public class testing_final_output {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting New Test ************************************************************");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending Test *******************************************************************");
	}

	@Test
	public void test() {
		start.main(new String[0]);
		while(start.check2==1);
		assertEquals("Name Not Equal 1st item",start.test_list.get(0).get_name(),"Laptop");
		assertEquals("Name Not Equal 2nd item",start.test_list.get(1).get_name(),"Car");
		assertEquals("Name Not Equal 3rd item",start.test_list.get(2).get_name(),"Chair");
		assertEquals("Final Price Not Equal 1st Item",(int)start.test_list.get(0).get_final_price(),22500);
		assertEquals("Final Price Not Equal 2nd Item",(int)start.test_list.get(1).get_final_price(),115500);
		assertEquals("Final Price Not Equal 3rd Item",(int)start.test_list.get(2).get_final_price(),11475);
		assertEquals("Type Not Equal 1st Item",start.test_list.get(0).get_type(),"raw");
		assertEquals("Type Not Equal 2nd Item",start.test_list.get(1).get_type(),"imported");
		assertEquals("Type Not Equal 3rd Item",start.test_list.get(2).get_type(),"manufactured");
	}

}
