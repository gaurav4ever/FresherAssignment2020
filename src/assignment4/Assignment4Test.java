package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Assignment4Test {

	@Test
	void test_database() {
		DatabaseConnection dc = DatabaseConnection.DatabaseConnection();
		assertAll(
				()->dc.connectToDatabase(),
				()->dc.getResultset(),
				()->dc.closeConnection()
				);
	}
	@Test
	void test() {
		assertAll(()->Assignment4.main(null));
	}
}
