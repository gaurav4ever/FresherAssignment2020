package assignment4.src.com.company;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConncetionDb extends Thread{
    int sleep = 1000;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Item> itemList1;

    public void databaseOperatons(){

        Operations operations = new Operations();
        Item item = new Item();
        Thread inputThread = new Thread(){
            public void run(){
                try {
                    Connection connection = DriverManager.getConnection(dbDetails.dbAddress, dbDetails.userName, dbDetails.password);
                    Statement smt = connection.createStatement();
                    ResultSet resultSet = smt.executeQuery(dbDetails.query);
                    while(resultSet.next()){
                        item.setName(resultSet.getString(1));
                        item.setQuantity(resultSet.getInt(2));
                        item.setPrice(resultSet.getDouble(3));
                        item.setType(resultSet.getString(4));
                        items.add(item);
                        Thread.sleep(sleep);
                    }
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        //Tax calculation Method Call
        Thread tax = new Thread(){
            public void run(){
                itemList1 = operations.taxCalculate(items);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //Display Method
        operations.displayItems(itemList1);

    }

}

