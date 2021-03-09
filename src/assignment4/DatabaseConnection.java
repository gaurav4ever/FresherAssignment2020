package assignment4;
import java.sql.*;
public class DatabaseConnection {
	private static DatabaseConnection instance = null;
	private static Connection conn = null;
	public static DatabaseConnection DatabaseConnection() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}
	public void connectToDatabase() {
		if(conn == null) {
			String url = "jdbc:mysql://localhost:3306/Items?serverTimezone=UTC";
			String user ="root";
			String password = "";
			try {
				conn = DriverManager.getConnection(url,user,password);
			}
			catch (Exception e) {
				System.out.println("Problem in connecting to Database!");;
			}
		}
	}
	public ResultSet getResultset() {
		ResultSet resultSet = null;
		try {
		PreparedStatement statement = conn.prepareStatement("select * from Item",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		resultSet = statement.executeQuery();
		}
		catch(Exception e) {
			System.out.println("Problem in fetching details from database!");
		}
		return resultSet;
	}
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Problem in closing the connection..");
		}
	}
}
