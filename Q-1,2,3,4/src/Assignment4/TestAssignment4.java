/*
 * Created by Manu KJ 
 */
package Assignment4;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mysql.fabric.xmlrpc.base.Data;

class TestAssignment4 {
	DataBase  database = DataBase.getInstance();
	@Test
	void test_for_connectivity() {
		assertEquals(true, database.connectToDatabase());
	}

	@Test
	void test_for_Row() {
		assertEquals(true, database.connectToDatabase());
		assertEquals(3, database.getTotalRow());
	}

}

