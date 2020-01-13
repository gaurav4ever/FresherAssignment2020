package assignment4;

import assignment1.models.Item;
import java.sql.*;

import assignment1.models.ManufacturedItem;
import assignment1.models.RawItem;
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
            Item item = null;
            String type = rs.getString(2);
            if(type.equals("raw")) {
                item = new RawItem(rs.getString(1), rs.getDouble(3), rs.getInt(4));
            }else if(type.equals("manufactured")){
                item = new ManufacturedItem(rs.getString(1),rs.getDouble(3),rs.getInt(4));
            }else if(type.equals("imported")) {
                item = new RawItem(rs.getString(1), rs.getDouble(3), rs.getInt(4));
            }else{
                throw new Exception("item type is not valid type "+ type);
            }
            return item;
        }else{
            con.close();
            throw new AllRecordsFetchException();
        }
    }
}
