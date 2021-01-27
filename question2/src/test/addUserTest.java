/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import question2.addUser;

class addUserTest {

	@Test
	void testAddUser() {
		// fail("Not yet implemented");
		
		addUser newUser = new addUser();
		newUser.AddUser();
		assertEquals(addUser.user1,addUser.users.get(addUser.users.size()-1),"User was not Added");
	}

}
