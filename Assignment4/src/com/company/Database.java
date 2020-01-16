package com.company;

import java.sql.*;

public class Database {
    private Connection connection;

    public Database(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String connectionUrl = "jdbc:mysql://localhost:3306/itemManager?useUnicode=true&characterEncoding=UTF-8&user=root&password=";
        try{
            connection = DriverManager.getConnection(connectionUrl);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void getItem(){
        System.out.println("Thread 1 in getItem()");
        try{
            System.out.println("Inside try Database-getItem");
            ResultSet rs = connection.prepareStatement("select * from items").executeQuery();

            while(rs.next()){
                System.out.println("Thread 1 - while 1");
                Item item = new Item();
                item.setName(rs.getString(1));
                item.setPrice(rs.getDouble(2));
                item.setQuantity(rs.getDouble(3));
                item.setType(rs.getType());
                System.out.println("item details fetched from db");
                while (Details.lock);
                Details.lock = true;
                Details.items.add(item);
                Details.lock = false;
                System.out.println("Added new item : "+Details.items.size()+" to list");
            }
            Details.completed = true;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
