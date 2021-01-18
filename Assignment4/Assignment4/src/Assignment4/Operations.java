import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Operations {


    public ArrayList<Items> Items = new ArrayList<>();
    public ArrayList<Items> finalPricedItems = new ArrayList<>();
    private boolean stopCalculation=true;

    public void select() throws InterruptedException{
        String sql = "SELECT * FROM items";


        int maxCapacity=3;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test?useSSl=false","root","Sini@@17");
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {

                synchronized(this)
                {

                    if(Items.size()==maxCapacity)
                        wait();

                    Items item1= new Items(rs.getString("Name"),rs.getInt("Quantity"), rs.getFloat("Price"), rs.getString("Type"));
                    Items.add(item1);

                    System.out.println("Item Added");
                    notify();

                    Thread.sleep(1000);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception while Reading from Database");
            stopCalculation=false;
        }

        stopCalculation=false;
    }

    public void CalculateTaxAndUpdatePrice() throws InterruptedException
    {

        while(stopCalculation || Items.size()!=0) {
            synchronized (this)
            {
                // consumer thread waits while list
                // is empty
                while (Items.size() == 0)
                    wait();

                Items i1= new Items();
                Items item = (Items) Items.get(0);
                double tax = i1.calculateTax(item.getType(), item.getPrice());

                Items itemfinal = new Items(item.getName(),item.getQuantity(),((item.getPrice()+tax)*item.getQuantity()),item.getType());

                finalPricedItems.add(itemfinal);
                Items.remove(0);
                System.out.println("Item Retrieved");
                // Wake up producer thread
                notify();

                // and sleep
                Thread.sleep(1000);
            }
        }

    }

}