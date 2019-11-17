/*
 * Created by Manu KJ 
 */
package Assignment4;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestAssignment4 {

	@Test
	void test_for_connectivity() {
		DataBase DataBase = new DataBase();
		assertEquals(true, DataBase.connectToDatabase());
	}

	@Test
	void test_for_Row() {
		DataBase DataBase = new DataBase();
		assertEquals(true, DataBase.connectToDatabase());
		assertEquals(2, DataBase.getTotalRow());
	}

}
