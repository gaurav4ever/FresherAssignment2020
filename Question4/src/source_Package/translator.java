package source_Package;

//This thread picks objects from SQL_LIST, calculates sales_tax and final_price based on type of object and updates another 
//Arraylist called final_list
public class translator extends Thread{

	@Override
	public void run()
	{
		while(start.check1==1 || !start.sql_list.isEmpty())
		{
			start.access_sql_list(2);   
		}
		start.check2=0;
	}
    
}
