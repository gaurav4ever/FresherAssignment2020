package asgn2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import asgn2.sort.SortByName;
import asgn2.sort.SortByAddress;
import asgn2.sort.SortByAge;
import asgn2.sort.SortByRollno;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.NotSerializableException;

public class Assignment2 implements Serializable{
	static final long serialVersionUID=12L;
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[]) throws IOException{
	
	ArrayList<User> users=new ArrayList<User>();
	try{
		FileInputStream fis= new FileInputStream("file.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		users=(ArrayList) ois.readObject();
		ois.close();
		fis.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	boolean flag=true;
	while(flag ==true) {
		System.out.println("Choose your action : ");
		System.out.println("1. Add User Details");
		System.out.println("2. Display User Details");
		System.out.println("3. Delete User Details");
		System.out.println("4. Save User Details");
		System.out.println("5. Exit");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			User user=new User();
			user.userInput();
			boolean flag1=true;
			int num1=user.getRollno();
			for(User u:users) {
				if (u.getRollno()==num1) {
					System.out.println("Roll no already exits. PLease try again");
					flag1=false;
					break;
				}
			}
			if (flag1==true) {
				users.add(user);
				System.out.println("user added Successfully");
			}
			break;
			
		case 2:
			users=sorting(users);
			System.out.printf("%10s %10s %10s %25s %20s","Name","Rollno","Age","Address","Courses");
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------------------");
			for(User user1:users){
				System.out.printf("%10s %10s %10s %25s %20s", user1.getName(),user1.getRollno(), user1.getAge(), user1.getAddress(), user1.getCourse());
				System.out.println();
			}
			System.out.println();
			break;
		case 3:
			System.out.print("Enter the roll no to be deleted : ");
			int num2=sc.nextInt();
			boolean flag2=true;
			for (User u:users) {
				if(num2==u.getRollno()) {
					users.remove(u);
					System.out.println("Deleted successfully.");
					flag2=false;
					break;
				}
			}
			if(flag2==true) {
				System.out.println("No such roll no found.");
			}
			break;
		case 4:
			try{
				FileOutputStream fos= new FileOutputStream("file.txt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				for(User user1:users) {
					oos.writeObject(user1);
				}
				System.out.println("Saved.");
				oos.close();
				fos.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 5:
			flag=false;
			break;
		default:
			System.out.println("Invalid choice.");
			break;
			
		}	
	}
}
	public static ArrayList<User> sorting( ArrayList<User> users) {
		System.out.println("Enter your choice : ");
		System.out.println("1. Sort by name");
		System.out.println("2. Sort by rollno");
		System.out.println("3. Sort by age");
		System.out.println("4. Sort by address");
		int choice1=sc.nextInt();
		switch(choice1) {
		case 1:
			Collections.sort(users, new SortByName());
			break;
		case 2:
			Collections.sort(users, new SortByRollno());
			break;
		case 3:
			Collections.sort(users, new SortByAge());
			break;
		case 4:
			Collections.sort(users, new SortByAddress());
			break;
		default:
			System.out.print("Default sorting by name");
			Collections.sort(users, new SortByName());
			break;
		}
		return users;
	}
}	
