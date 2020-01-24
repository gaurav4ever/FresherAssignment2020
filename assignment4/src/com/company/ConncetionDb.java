package assignment4.src.com.company;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConncetionDb extends Thread{
    private int sleep = 1000;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Item> itemList1;


    public void databaseOperatons(){

        final Operations operations = new Operations();
        final Item item = new Item();
        final Thread inputThread = new Thread(){
            public void run(){
                try {
                    Connection connection = DriverManager.getConnection(DbDetails.dbAddress, DbDetails.userName, DbDetails.password);
                    Statement smt = connection.createStatement();
                    ResultSet resultSet = smt.executeQuery(DbDetails.query);
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
                    System.out.println("Db Connection error ");
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
                    System.out.println("Thread Creation Error");
                }
            }
        };

        //Display Method
        operations.displayItems(itemList1);

    }

}

