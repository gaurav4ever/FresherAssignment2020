package userdetailmanagement.UserUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import userdetailmanagement.model.User;
import userdetailmanagement.service.UserService;

public class UserUtil {
	static Scanner sc=new Scanner(System.in);
	static UserService service = new UserService();
	
	public static String inputName() {
		String fullname =  sc.nextLine();
		while(fullname.equals("")) {
			System.out.println("Please try again");
			fullname = sc.nextLine();
		}
		return fullname;
	}
	
	private static int inputAge() {
		System.out.print("-age [Integer] ");
		int age;
		try {
			age = sc.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("Age can only be integer. Please re-enter age");
			sc.nextLine();
			age = inputAge();
		}
		return age;
	}
	
	public static String inputAddress() {
		System.out.print("-address ");
		sc.nextLine();
		String address = sc.nextLine();
		while(address.equals("")) {			
			System.out.println("Please try again");
			address = sc.nextLine();
		}
		return address;
	}
	
	
	
	public static int inputRollNo() {
		System.out.print("-Roll Number [Integer] ");
		int rollno;
		try {
			rollno = sc.nextInt();
			if(service.verifiedRollNo(rollno)) {
				return rollno;
			}
			else {
				rollno=inputRollNo();
			}
		} catch (InputMismatchException e) {
			System.out.println("Roll no should be integer. Please re-enter");
			rollno = inputRollNo();
			sc.nextLine();
		}
		return rollno;
	}
	
	public static User getUserInput() {
		User user = new User();
		
		System.out.println("Enter the Details of the User");
		sc.nextLine();
		
		System.out.print("-Fullname ");
		String fullName = inputName();
		user.setName(fullName);
		
		int age = inputAge();
		user.setAge(age);
		
		String address = inputAddress();
		user.setAddress(address);
		
		int rollno = inputRollNo();
		user.setRollNo(rollno);
		
		System.out.println("Select atleast 4 courses");
		int count=6;
		ArrayList<String> courses = new ArrayList<>();
		String ch="y";
		while(count>0) {
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
	
	public static int getSortingMenu() {
		int choice =0;
		System.out.println("Select an attribute based on which you wanna sort");
		System.out.println("1. Name");
		System.out.println("2. Roll Number");
		System.out.println("3. Age");
		System.out.println("4. Address");
		try {
			choice = sc.nextInt();
		}catch(Exception e) {
			System.out.println("Invalid Choice");
		}
		if(choice==0)return getSortingMenu();
		else return choice;
	}
	public static void start() {
		service.bringDataInMemory();
		while(true) {
			System.out.println("Select an option - \n1.Add user\n2.Display user\n3.Delete user\n4.Save user\n5.Exit");
			int t=sc.nextInt();
			switch(t) {
			case 1:
				User user = getUserInput();
				service.addUser(user);
				break;
			case 2:
				List<User> users = service.findAllUser();
				service.displayUser(users);
				sc.nextLine();
				System.out.println("Press -> 's' for sorting menu");
				char check = sc.nextLine().toLowerCase().charAt(0);
				while(check =='s') {
					int choice = getSortingMenu();
					sc.nextLine();
					System.out.println("Press 'a' for ascending and 'd' for descending");
					char order = sc.nextLine().toLowerCase().charAt(0);
					users = service.getSortedUserDetails(choice, order);
					service.displayUser(users);
					System.out.println("Press -> 's' for sorting menu");
					check = sc.nextLine().toLowerCase().charAt(0);
				}
				break;
			case 3:
				System.out.println("Enter roll no of the user");
				int rollNo = sc.nextInt();
				sc.nextLine();
				service.deleteUser(rollNo);
				break;
			case 4:
				service.saveUserInDisk();
				break;
			case 5:
				sc.nextLine();
				System.out.println("Do you want to save the latest changes [y/n]");
				char ch = sc.nextLine().toLowerCase().charAt(0);
				if(ch=='y') service.saveUserInDisk();
				break;
			default:
				System.out.println("Wrong option. Please select correct option.");
				break;	
			}
		}
	}
}
