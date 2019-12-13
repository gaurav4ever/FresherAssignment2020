import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator cal=new Calculator();
		int a = 123;
		int b= 456;
		int actual = cal.add(a, b);
		int expected = 579;
		assertEquals(expected,actual);
	}

	@Test
	public void testSubstract() {
		fail("Not yet implemented");
	}

}
