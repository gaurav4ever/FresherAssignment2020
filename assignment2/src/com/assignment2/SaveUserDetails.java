package com.assignment2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class SaveUserDetails implements Serializable{
	private static final long serialVersionUID = 1113799434508676095L;
	public User userInput() {
		Scanner s = new Scanner(System.in);
		User user = new User();
		while(true) {
			System.out.println("Enter Full Name:");
			String fullName = s.nextLine();
			if(fullName.isEmpty())
				System.out.println("This Field is Required");
			else
				user.setName(fullName);
				break;
		}
		while(true) {
			System.out.println("Enter the age:");
			int age = s.nextInt();
			user.setAge(age);
			break;
		}
		s.nextLine();
		while(true) {
			System.out.println("Enter the address:");
			String address = s.nextLine();
			if(address.isEmpty())
				System.out.println("This Field is Required");
			else
				user.setAddress(address);
				break;
		}
		while(true) {
			System.out.println("Enter the Roll Number:");
			int rollNo = s.nextInt();
			user.setRollNo(rollNo);;
			break;
		}
		s.nextLine();
		System.out.println("Select Courses(A/B/C/D/E/F):");
		while(true) {
			String c= s.next();
			if((user.courses).indexOf(c) == -1 && (c.equalsIgnoreCase("A") || c.equalsIgnoreCase("B") || c.equalsIgnoreCase("C") || c.equalsIgnoreCase("D") || c.equalsIgnoreCase("E") || c.equalsIgnoreCase("F") ))
				(user.courses).add(c);
			else System.out.println("Invalid! Enter Course Again!");
			if((user.courses).size() == 4) break;
		}
		
		return user;
	}
	
	public void askUserToDisplay() {
		Scanner s = new Scanner(System.in);
		//User u = new User();
		System.out.println("On the basis of which attribute you want to perform sorting!");
		System.out.println("1. Full Name");
		System.out.println("2. Age");
		System.out.println("3. Address");
		System.out.println("4. Roll No.");
		System.out.println("5. Default");
		//u.setChoice1(s.nextInt());
		User.choice1 = s.nextInt();
		System.out.println("In which order?");
		System.out.println("1. Ascending");
		System.out.println("2. Descending");
		System.out.println("3. Default");
		//u.setChoice2(s.nextInt());
		User.choice2 = s.nextInt();
	}
	public void run() {
		String fileName = "file.txt";
		Scanner sc = new Scanner(System.in);
		SaveUserDetails obj = new SaveUserDetails();
		ArrayList<User> users = new ArrayList<User>();
		boolean flag = true;
		//Reading data from disk
		try
        {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            users = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
		while(flag == true) {
			System.out.println("Select the operation you want to perform-:");
			System.out.println("1. Add User");
			System.out.println("2. Display Users");
			System.out.println("3. Delete User");
			System.out.println("4. Save Users to the disk");
			System.out.println("5. Exit");
			
			System.out.println("Please Enter the number of your choice:");
			int option = sc.nextInt();
			switch(option) {
			case 1: 
					User user = null;
					user = obj.userInput();
					int number = user.getRollNo();
					boolean flag1 = true;
					for(User user1:users) {
						if(user1.getRollNo() == number) {
							flag1 = false;
						}
					}
					if(flag1==true)users.add(user);
					else System.out.println("Roll Number Already Exists! please try again");
					Collections.sort(users);
				break;
			case 2:
				obj.askUserToDisplay();
				Collections.sort(users);
				System.out.println("--------------------------------------------------------------------------------------------------------------------------");
				//System.out.println("Name                   Age                      Address                  Roll No.                Courses                  ");
				System.out.printf("%20s %10s %25s %10s %15s", "Name", "Age", "Address", "Roll No.", "Courses");
				System.out.println();
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				
					for(User user1:users) {
						System.out.printf("%20s %10s %25s %10s %15s",user1.getName(), user1.getAge(), user1.getAddress(), user1.getRollNo(), user1.courses);
						System.out.println();
					}
				break;
			case 3:
				System.out.println("Enter the Roll Number of the student to delete:");
				int number1 = sc.nextInt();
				for (User u : users) {
					if(u.getRollNo() == number1) {
						users.remove(users.indexOf(u));
						System.out.println("User Details Deleted Successfully!!");
						break;
					}
				}
				break;
			case 4:
				try
		        {
		            FileOutputStream fos = new FileOutputStream(fileName);
		            ObjectOutputStream oos = new ObjectOutputStream(fos);
		            oos.writeObject(users);
		            oos.close();
		            fos.close();
		        }
		        catch (IOException ioe)
		        {
		            ioe.printStackTrace();
		        }
				break;
			case 5:
				System.out.println("Do you want to save the changes before exit?");
				String ch = sc.next();
				if(ch.equalsIgnoreCase("Y")){
					try
			        {
			            FileOutputStream fos = new FileOutputStream(fileName);
			            ObjectOutputStream oos = new ObjectOutputStream(fos);
			            oos.writeObject(users);
			            System.out.println("Changes Saved!");
			            oos.close();
			            fos.close();
			        }
			        catch (IOException ioe)
			        {
			            ioe.printStackTrace();
			        }
				}
				flag = false;
				break;
			default:
				System.out.println("Wrong Choice!");
				break;
			}
		}
	}
}
