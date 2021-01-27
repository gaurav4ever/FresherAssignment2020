package question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
public class home {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String filename = "userdata.txt";
		File fil = new File(filename);
		if(!fil.exists()) {
			try {
				FileOutputStream file = new FileOutputStream(filename);
			} catch (FileNotFoundException e1) {
				System.out.println("File Not Found Exception ");
			}
		}
		
		addUser a1 = new addUser();
		saveDetails sd = new saveDetails();
		displayUser d1 = new displayUser();
		while(true)
		{
			System.out.println("Enter 1 for Adding User details \n Enter 2 for Displaying User Details \n Enter 3 to Delete User Details \n Enter 4 to Save user details \n Enter 5 to Exit\n ");
			int choice = sc.nextInt();
			
			// Calling class to add details
			if(choice == 1 ) {  
				a1.AddUser();	
			}
			
			// calling class to display details
			else if(choice == 2) {
				ArrayList<user> us1 =d1.readFromFile();
				for (user u1:us1)
					System.out.println(u1.toString());
				d1.takeDisplayOptions();
			}
			
			// deleting details
			else if(choice == 3) {
				System.out.println("enter the roll number u want to delete");
				int roll = sc.nextInt();
				addUser.users = d1.readFromFile();
				for(user u1 : addUser.users) {
					if(u1.getRollno()==roll) {
						addUser.users.remove(u1);
						break;
					}
				}
				sd.save();
			}
	
			//save details
			else if(choice == 4) {
				sd.save();
			}
			
			//Exit 
			else if(choice == 5) {
				System.out.println("Do u want to save before exiting ? press Y to save !!");
				sc.nextLine();
				String input = sc.nextLine();
				if(input.equalsIgnoreCase("Y"))
					sd.save();
				System.exit(0);
			}
			
		}

	}

}
