package source_Package;

import java.util.ArrayList;

public class start {
	static String sql_list_name;
	static String sql_list_type;
	static int sql_list_quantity,check1;
	public static int check2;
	static double sql_list_price;

	static String final_list_name;
	static String final_list_type;
	static int final_list_quantity;
	static double final_list_price,final_list_sales_tax,final_list_final_price;
	
	static ArrayList<sql_objects> sql_list = new ArrayList<>();
	public static ArrayList<final_objects> final_list = new ArrayList<>();
	
	//Only Used for Junit Testing
	public static ArrayList<final_objects> test_list = new ArrayList<>();
	
	//Synchronization ensures that one thread can access this function
	static synchronized void access_sql_list(int req)
	{
        if(req==1)
        {
              sql_list.add(new sql_objects(sql_list_name,sql_list_quantity,sql_list_price,sql_list_type));
 //             System.out.println("SQL_LIST_ADD");
        }
        else
        {
            if(!sql_list.isEmpty())
            {
                sql_objects temp = sql_list.get(0);
                double sales_tax,final_price;
                switch (temp.get_type()) {
                    case "raw":
                        sales_tax = 0.125*temp.get_price()*temp.get_quantity();
                        final_price = (temp.get_price()*temp.get_quantity() + sales_tax);
                        break;
                    case "manufactured":
                        sales_tax = (0.125*temp.get_price() + 0.02*(temp.get_price() +0.125*temp.get_price()))*temp.get_quantity();
                        final_price = (temp.get_price()*temp.get_quantity() + sales_tax);
                        break;
                    case "imported":
                        sales_tax = 0.1*temp.get_price();
                        final_price = temp.get_price() + sales_tax;
                        if(final_price<=100)
                        {
                            final_price += 5;
                        }
                        else if(final_price>100 && final_price<200)
                        {
                            final_price += 10;
                        }
                        else
                        {
                            final_price += 0.05*final_price;
                        }
                        sales_tax = (final_price - temp.get_price())*temp.get_quantity();
                        final_price *= temp.get_quantity();
                        break;
                    default:
                        System.out.println("Wrong Type ! Not mentioned");
                        sql_list.remove(0);
                        return;
                }
                
                final_list_name = temp.get_name();
                final_list_quantity = temp.get_quantity();
                final_list_type = temp.get_type();
                final_list_price = temp.get_price();
                final_list_sales_tax = sales_tax;
                final_list_final_price = final_price;
 //               System.out.println("CALCULATE");
                access_final_list(1);
                sql_list.remove(0);
            }
        }
	}
	
	static synchronized void access_final_list(int req)
	{
        if(req==1)
        {
            final_list.add(new final_objects(final_list_name,final_list_quantity,final_list_price,final_list_type,final_list_sales_tax,final_list_final_price));
//            System.out.println("FINAL_LIST_ADD");
        }
        else
        {
            if(!final_list.isEmpty())
            {
                final_objects temp = final_list.get(0);  
                System.out.println(temp.get_name()+" "+temp.get_price()+" "+temp.get_quantity()+" "+temp.get_type()+" "+temp.get_sales_tax()+" "+temp.get_final_price());
                test_list.add(temp);
                final_list.remove(0); 
            }
        }

	}
	
	//Through some of Systems outputs in console it was proved that All threads were working concurrently hence there
	//was optimal usage of threads
	//Deadlock cannot happen proof through graph method is there(No Cycles)
	public static void main(String[] args) {
        sql_reader t1 = new sql_reader();
        translator t2 = new translator();
        check1=1;
        check2=1;
        t1.start();
        t2.start();
        while(check2==1 || !final_list.isEmpty())
        {
            access_final_list(2);
        }		

	}

}
