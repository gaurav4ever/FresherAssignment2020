package Assignment4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class connectionClass {

    /** Items is a Shared Variable */
    private ArrayList<Items> Items = new ArrayList<>();
    public  ArrayList<Items> finalPricedItems = new ArrayList<>();
    public ArrayList<Items> ItemsRead= new ArrayList<>();


    public void create() throws ClassNotFoundException
    {

        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test","root","Sini@@17");

        }
        catch(SQLException e) {
            System.out.println("SQL Exception while Creating Connection");
        }

    }

    public void createNewTable() {
        // SQLite connection string


        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS items (Name text PRIMARY KEY,Quantity integer,Price real,Type text);";

        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test","root","root");
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Table Created");
        } catch (SQLException e) {
            System.out.println("SQL Exception in Creating Table");
        }
    }

    public void insert(String name, int quantity, float price, String type) {

        String sql = "INSERT INTO items(Name, Quantity, Price, Type) VALUES(?,?,?,?)";

        try{
            Connection conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test","root","root");
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, quantity);
            pstmt.setFloat(3, price);
            pstmt.setString(4, type);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception while Inserting in Database");
        }
    }


}