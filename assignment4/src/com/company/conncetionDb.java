package assignment4.src.com.company;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conncetionDb {
    boolean flah;

    public void databaseOperatons() throws Exception{
        try {
            Connection connection = DriverManager.getConnection(dbDetails.dbAddress, dbDetails.userName, dbDetails.password);
            Statement smt = connection.createStatement();
            ResultSet resultSet = smt.executeQuery(dbDetails.query);
            while(resultSet.next()){

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

