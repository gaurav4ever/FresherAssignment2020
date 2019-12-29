package source_Package;

import java.util.HashMap;
import java.util.Scanner;

public class parser {
	
	private String name,addr;
	private int roll,age,num;
	
	//This class is used to Enter all inputs and error check parameters for appropriate values
	//All Fields are mandatory
	public int parseme(HashMap<Integer,student> hp)
	{
		String someres;
		Scanner sc = new Scanner(System.in);
		
		//To check Roll Number
		while(true)
		{
			System.out.println("Enter Roll Number of Student");
			try
			{
				roll = Integer.parseInt(sc.nextLine());
				if(!hp.containsKey(roll) && roll>0)
				{
					break;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Entry! Try Again");
			}
			System.out.println("Press N to restart Process");
			someres = sc.nextLine();
			if(someres.equals("N"))
			{
				System.out.println("Wanted To End Process While Entering Roll Number");
				return -1;
			}
		}
		
		//To Check Name
		while(true)
		{
			System.out.println("Enter Name of the Student");
			name = sc.nextLine();
			if(name.equals(""))
			{
				System.out.println("Name Field Empty! Try Again");
			}
			else
			{
				break;
			}
			System.out.println("Press N to restart Process");
			someres = sc.nextLine();
			if(someres.equals("N"))
			{
				System.out.println("Wanted To End Process While Entering Name");
				return -1;
			}
		}
		
		//To check Age
		while(true)
		{
			System.out.println("Enter Age of Student");
			try
			{
				age = Integer.parseInt(sc.nextLine());
				if(age>0)
				{
					break;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Entry! Try Again");
			}
			System.out.println("Press N to restart Process");
			someres = sc.nextLine();
			if(someres.equals("N"))
			{
				System.out.println("Wanted To End Process While Entering Age Number");
				return -1;
			}		
		}
		
		//To check address
		while(true)
		{
			System.out.println("Enter Address of the Student");
			addr = sc.nextLine();
			if(addr.equals("") || addr.length()<5)
			{
				System.out.println("Name Field Empty or Less than 5 characters! Try Again");
			}
			else
			{
				break;
			}
			System.out.println("Press N to restart Process");
			someres = sc.nextLine();
			if(someres.equals("N"))
			{
				System.out.println("Wanted To End Process While Entering Address");
				return -1;
			}			
		}
		
		//To enter the Number of Courses
		while(true)
		{
			System.out.println("Enter Number of Courses Student is taking");
			try
			{
				num = Integer.parseInt(sc.nextLine());
				if(num>=4 && num<=6)
				{
					break;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Entry for Number of courses!Try Again.");
			}
			System.out.println("Press N to restart Process");
			someres = sc.nextLine();
			if(someres.equals("N"))
			{
				System.out.println("Wanted To End Process While Entering Address");
				return -1;
			}	
		}
		return 0;
	}
	
	public int get_roll()
	{
		return roll;
	}
	
	public int get_age()
	{
		return age;
	}
	
	public String get_name()
	{
		return name;
	}
	
	public String get_addr()
	{
		return addr;
	}
	
	public int get_num_courses()
	{
		return num;
	}

}
