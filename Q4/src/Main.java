import Util.InputUtil;
import Util.OutputUtil;
import model.Item;
import Constants.Constants;
import Services.CalculateTaxService;
import Services.Tax;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main extends Thread{
    private static ArrayList<Item> productList = new ArrayList<Item>();
    public static void main(String args[]){

        try{
            productList = InputUtil.getInputItem();
            calculateTax();



//step2 create  the connection object
            Connection con= DriverManager.getConnection(
                    Constants.DB_ADDRESS,Constants.USER_NAME,Constants.PASSWORD);

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
                ResultSet rs=stmt.executeQuery(Constants.RESULT_QUERY);
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getFloat(2)
                        +"  "+rs.getInt(3) + " " +rs.getString(4));

//step5 close the connection object
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
    private static void calculateTax() {
        for (Item arrayListItem : productList) {
            double salesTax = getCalculatedTax(arrayListItem.productType, arrayListItem.productPrice);
            double totalPrice = (arrayListItem.productPrice + salesTax) * arrayListItem.productQuantity;
            OutputUtil.printOutput(arrayListItem, salesTax, totalPrice);
        }
    }

    private static double getCalculatedTax(int type, double price){
        CalculateTaxService calculateTaxService = new Tax().getTax(type);
        return calculateTaxService.calculateTax(price);
    }
}
