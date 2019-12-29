package test_Package;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import source_Package.start;
import source_Package.student;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//To check if file saving and reading is working
public class save_details {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting New Test...................................................");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending Test..........................................................");	
	}

	@Test
	public void test() {
		student stud = start.add_user_test("Ashish",160911234,"flat687",22);
		try
		{
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Mahe\\Desktop\\dot.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(stud);
			oos.close();
			fos.close();
			FileInputStream fis = new FileInputStream("C:\\Users\\Mahe\\Desktop\\dot.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			stud = (student)ois.readObject();
			ois.close();
			fis.close();
		}
		catch(IOException | ClassNotFoundException e)
		{
			fail("Problems with Saving and Retrieving");
			return;
		}
		assertNotNull("Value of retrieved student Null",stud);
		assertEquals("Name Not Equal","Ashish",stud.get_name());
		assertEquals("Age Not Equal",22,stud.get_age());
		assertEquals("Roll Number Not Equal",160911234,stud.get_roll());
		assertEquals("Address Not Equal","flat687",stud.get_addr());
	}

}
