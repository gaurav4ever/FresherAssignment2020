package userdetailmanagement.UserUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import userdetailmanagement.model.User;
import userdetailmanagement.service.UserService;

public class UserUtil {
	static Scanner sc=new Scanner(System.in);
	static UserService service = new UserService();
//	static TreeMap<String,User> tm = new TreeMap<String,User>();
//	static TreeMap<String, ArrayList<User>> tm = new TreeMap<String, ArrayList<User>>();
//	static ArrayList<Integer> roll=new ArrayList<>();
	public static User getUserInput() {
		User user = new User();
		sc.nextLine();
		System.out.println("Enter name");
		user.setName(sc.nextLine());
		System.out.println("Enter age");
		user.setAge(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter address");
		user.setAddress(sc.nextLine());
		System.out.println("Enter roll no");
		user.setRollNo(sc.nextInt());
		System.out.println("Select atleast 4 courses");
		int count=6;
		ArrayList<String> courses = new ArrayList<>();
		String ch="y";
		while(count>0) {
			System.out.println("count "+count);
			if(count<=2) {
				System.out.println("Do you want to select more or exit.(y/n)");
				ch=sc.next();
				sc.nextLine();
				if(ch.equals("n")) {
					break;
				}
			}
			System.out.println("Select course out of the following. 1.A 2.B 3.C 4.D 5.E 6.F");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				if(!(courses.contains("A"))) {
					courses.add("A");
					count--;
				}
				else {
					System.out.println("You have already selected this. Please choose another");
					System.out.println(courses);
					count++;
				}
				break;
			case 2:
				if(!(courses.contains("B"))) {
					courses.add("B");
					count--;
				}
				else {
					System.out.println("You have already selected this. Please choose another");
					System.out.println(courses);
					count++;
				}
				break;
			case 3:
				if(!(courses.contains("C"))) {
					courses.add("C");
					count--;
				}
				else {
					System.out.println("You have already selected this. Please choose another");
					System.out.println(courses);
					count++;
				}
				break;
			case 4:
				if(!(courses.contains("D"))) {
					courses.add("D");
					count--;
				}
				else {
					System.out.println("You have already selected this. Please choose another");
					System.out.println(courses);
					count++;
				}
				break;
			case 5:
				if(!(courses.contains("E"))) {
					courses.add("E");
					count--;
				}
				else {
					System.out.println("You have already selected this. Please choose another");
					System.out.println(courses);
					count++;
				}
				break;
			case 6:
				if(!(courses.contains("F"))) {
					courses.add("F");
					count--;
				}
				else {
					System.out.println("You have already selected this. Please choose another");
					System.out.println(courses);
					count++;
				}
				break;
			default : 
				System.out.println("You have entered wrong input. Please choose again.");
				count++;
				break;
			}
			if(count==0) {
				break;
			}
			
			
		}
		user.setCourses(courses);
		return user;
	}
	public static void start() {
		while(true) {
			System.out.println("Select an option - \n1.Add user\n2.Display user\n3.Delete user\n4.Save user\n5.Exit");
			int t=sc.nextInt();
			switch(t) {
			case 1:
				User user = getUserInput();
				service.addUser(user);
				//service.addUser(tm,roll);
				break;
			case 2:
				service.displayUser();
				break;
			case 3:
				service.deleteUser();
				break;
			case 4:
				service.saveUser();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Wrong option. Please select correct option.");
				break;	
			}
		}
	}
}
