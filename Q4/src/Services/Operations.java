package Services;

import Constants.Constants;
import model.Item;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Operations{
    ArrayList<Item> items = new ArrayList();
    Vector<Item> taxedItems = new Vector();
    int sleep = 500;
    boolean flag;

    public void databaseOperation() throws Exception{
        try{
            Connection con = DriverManager.getConnection(Constants.DB_ADDRESS, Constants.USER_NAME, Constants.PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Constants.RESULT_QUERY);
            flag = false;
            while(rs.next()){
                Item item = new Item();
                item.setName(rs.getString(1));
                item.setPrice(rs.getDouble(2));
                item.setQuantity(rs.getInt(3));
                item.setType(rs.getString(4));
                items.add(item);
                Thread.sleep(sleep);
            }
            flag = true;
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void taxOperation() throws Exception{
        double tax;
        while(items.isEmpty()){
            Thread.sleep(sleep);
        }
        while(!items.isEmpty()){
            Item item = items.get(0);
            items.remove(0);
            tax = item.getTaxes();
            item.setTaxes(tax);
            taxedItems.add(item);
            Thread.sleep(sleep);
        }
    }

    public void displayItem() throws Exception{
        System.out.format("%-15s%-15s%-15s%-15s\n", "Name", "Price", "Quantity", "Type");
        for(Item item:taxedItems){
            System.out.format("%-15s%-15s%-15s%-15s\n",item.getName(), item.getPrice(), item.getQuantity(), item.getType());
        }
    }
}
