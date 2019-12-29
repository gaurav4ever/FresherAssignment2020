package test_Package;
import source_Package.start;
import source_Package.student;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Checks if each user has been initiated the right way
public class add_user {
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Starting New Test ********************************");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending Test ***************************************");
	}

	@Test
	public void testone() {
		student stud = start.add_user_test("Ashish",160911234,"flat687",22);
		assertNotNull("Value of Student is Null",stud);
		assertEquals("Name Doesnt Equal","Ashish",stud.get_name());
		assertEquals("Roll Number Doesnt Equal",160911234,stud.get_roll());
		assertEquals("Address Doesnt Equal","flat687",stud.get_addr());
		assertEquals("Age Doesnt Equal",stud.get_age(),22);
	}

}
