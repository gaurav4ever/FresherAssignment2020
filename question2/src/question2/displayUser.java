package question2;

import question2.user;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class displayUser {
	public static int rollasc;
	
	public ArrayList<user> readFromFile() {
		
		ArrayList<user> object1=null;
		String filename="userdata.txt";
		ArrayList<user> us1 = new ArrayList<user>();
		
		try {    
	        // Reading the object from a file 
	           FileInputStream file = new FileInputStream(filename); 
	           ObjectInputStream in = new ObjectInputStream(file); 
	       
	           object1=(ArrayList<user>) in.readObject();
	           us1.addAll(object1);     
	        }catch(EOFException e) {
	    	   System.out.println("EOF here");
		}catch(Exception ex) {
	           System.out.println("IOException is caught" ); 
	        }
		
		nameCompare namec = new nameCompare(1);
		if(!us1.isEmpty())
			Collections.sort(us1,namec);
		
		return us1;
	}
	
	public void takeDisplayOptions()
	{
		System.out.println("Enter 1 to sort Based on Name");
		System.out.println("Enter 2 to sort Based on Age");
		System.out.println("Enter 3 to sort Based on Address");
		System.out.println("Enter 4 to sort Based on RollNo");
		
		Scanner sc = new Scanner(System.in);
		int choice1 = sc.nextInt();
		
		System.out.println("Enter 1 to sort in ascending and 2 to sort in descending");
		
		int choice2 = sc.nextInt();
		rollasc=choice2;
		
		switch(choice1)
		{
		case 1 : 
			nameCompare namec = new nameCompare(choice2);
			Collections.sort(addUser.users,namec);
			break;
		case 2 :
			AgeCompare agec = new AgeCompare(choice2);
			Collections.sort(addUser.users,agec);
			break;
		case 3:
			AddressCompare addressc = new AddressCompare(choice2);
			Collections.sort(addUser.users,addressc);
			break;
			
		case 4:
			rollCompare rollc = new rollCompare(choice2);
			Collections.sort(addUser.users,rollc);
			break;
			
			default:
				System.out.println("Enter the Right Choice");
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        	System.out.println("Name\t\t\tRoll Number\t\tAge\t\t\tAddress\t\t\tCourses");
        	System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		
		for( user u1 : addUser.users)
		{
			System.out.println(u1.getName()+"\t\t\t"+ u1.getRollno()+"\t\t\t"+ u1.getAge()+"\t\t\t"+ u1.getAddress()+"\t\t"+u1.getCourse().toString());
	        	System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

		}
	}
}
