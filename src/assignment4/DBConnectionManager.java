package assignment4;

import assignment1.models.Item;
import java.sql.*;
import assignment4.Exceptions.AllRecordsFetchException;

public class DBConnectionManager {
    static Connection con = null;
    static ResultSet rs = null;

    public static Connection getConnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nuclei","root","7#9@Mysql");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static void initOperation()throws Exception{
        con = getConnection();
        if(con == null){
            throw new Exception("failed : connection from db");
        }
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery("select * from Item");
    }
    public static Item getNextItem()throws Exception{
        if(rs.next()){
            Item item = new Item(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
            return item;
        }else{
            con.close();
            throw new AllRecordsFetchException();
        }
    }
}
