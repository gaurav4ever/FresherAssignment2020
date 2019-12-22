/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import question2.user;
import org.junit.jupiter.api.Test;

class userTest {

	@Test
	void test() {
		// fail("Not yet implemented");
		ArrayList<String> course = new ArrayList<>();
		user user1 = new user("Adarsh",21,11,"Mysore",course);
		
		assertEquals("Adarsh", user1.getName());
		assertEquals(21,user1.getAge());
		assertEquals(11,user1.getRollno());
		assertEquals("Mysore",user1.getAddress());
	}

}
