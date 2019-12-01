package asgn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//to establish db connection and get number of rows
public class DBConnection {
	Connection con;
	int size = 0;

	//establish db connection
	public ResultSet getConnection() {
		try {
			Class.forName(Constants.driver);
			// here demo is database name, root is user name and password
			con = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = st.executeQuery(Constants.query);

			// get total number of rows in table
			rs.last();
			size = rs.getRow();
			rs.beforeFirst();

			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//get number of rows
	public int getTotalRows() {
		return size;
	}

	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}