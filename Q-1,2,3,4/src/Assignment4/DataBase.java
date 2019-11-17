/*
 * Created by Manu KJ 
 */
package Assignment4;

import java.sql.*;

public class DataBase {

	private ResultSet resultSet = null;
	private int totalRow = -1;
	private Connection connection = null;

	public Connection getConnection() {
		return connection;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public boolean connectToDatabase() {
		String user = "assignment4";
		String password = "12345%$#@!";
		String database = "Assignment4";
		String url = "jdbc:mysql://localhost:3306/" + database + "?autoReconnect=true&useSSL=false";
		try {
			this.connection = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = connection.prepareStatement("select * from Items",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			this.resultSet = statement.executeQuery();

			// to get the total row
			resultSet.last();
			this.totalRow = resultSet.getRow();
			resultSet.beforeFirst();

			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return false;
	}

}
