
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import question2.saveDetails;

class saveDetailsTest {

	@Test
	void testSave() {
		saveDetails savedetails = new saveDetails();
	assertThrows(IOException.class,()-> savedetails.save(),"IO Exception");
		
	}

}
