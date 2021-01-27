package org.nuclei.dao;
import org.nuclei.enums.taxType;
import org.nuclei.model.Item;
import org.nuclei.util.ItemUtility;

import java.sql.*;

import java.util.concurrent.BlockingQueue;

public class DAO {
    public static void getItems(BlockingQueue<Item> items){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Nuclei","root","nuclei@123");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from Item");
        while(rs.next())
        { Item item = new Item();
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
            item.setQuantity(rs.getInt("quantity"));
            item.setType(taxType.valueOf(rs.getString("itemType")));
            items.put(item);
            System.out.print("Item Fetched\n");
        }
        con.close();
    } catch(Exception e){ System.out.println(e);}
    }



}
