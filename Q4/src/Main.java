import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Thread{
    public static void main(String args[]){
        try{

//step2 create  the connection object
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Q4","root","1234567890");

//step3 create the statement object
            Statement stmt=con.createStatement();


//step4 execute query
                ResultSet rs=stmt.executeQuery("select * from Inventory");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getFloat(2)
                        +"  "+rs.getInt(3) + " " +rs.getString(4));

//step5 close the connection object
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}
