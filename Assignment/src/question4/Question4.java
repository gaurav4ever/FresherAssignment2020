package question4;

import question1.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Aditya
 */
class Operations {
    
    Queue<Item> itemListDB = new LinkedList<>();
     /* Flag to identify database operation complete or not. 
    If complete then true (allow exit) else false. */
    boolean exit;      
    int sleepTime = 200;
    ArrayList<Item> itemListTaxes = new ArrayList<>();

    public void displayItem(Item item) {

        double finalPrice = item.getPrice() + item.getTaxes();
        String outputItem = item.getName() + "\t" + item.getPrice() + "\t" + item.getType() + "\t" + finalPrice;
        System.out.println(outputItem);
    }

    public void databaseOperation() throws InterruptedException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/nuclei", "root", "");
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("select * from items");
            exit = false;
            GetItemFactory itemFactory=new GetItemFactory();
            Item item;
            while (rs.next()) {
                String type=rs.getString(5);
                item = itemFactory.getItem(type);
                item.setName(rs.getString(2));
                item.setPrice(rs.getDouble(3));
                item.setQuantity(rs.getInt(4));
                
                itemListDB.add(item);

                Thread.sleep(sleepTime);

            }
            exit = true;
        } catch (ClassNotFoundException e){
            System.out.println("Driver Class Not Fount!!");

        }
        catch(SQLException s)
        {
            System.out.println("Cant connect to Database");
        }
    }

    public void taxOperation() throws InterruptedException {
        System.out.println("Item\tPrice\tTaxes\tFinal Price");
        double taxes;

        while (!exit) {
            if (!itemListDB.isEmpty()) {
                Item item = itemListDB.poll();
                item.calculateTaxes();
                itemListTaxes.add(item);

                displayItem(item);
                Thread.sleep(sleepTime);
            }
        }

    }
}

public class Question4{

    //Database : nuclei
    //Table : Items
    public static void main(String[] args) {
        
        //Instance of Operation Class
        Operations opt = new Operations();
        
        //Thread for Database Operation
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    opt.databaseOperation();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        //Thread for Tax Calculation and Display
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    opt.taxOperation();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //Executing Threads
        t1.start();
        t2.start();

    }

}
