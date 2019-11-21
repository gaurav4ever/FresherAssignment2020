/**
 * Author: Bhavyadeep
 */
package assignment2;

import java.util.Scanner;

class Assignment2 {
	static StudentDetails studentDetails = new StudentDetails();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int ch;
		while(true) {
			System.out.println("1. Add student Details");
			System.out.println("2. Display student Details");
			System.out.println("3. Delete student Details");
			System.out.println("4. Save student Details");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			ch = Integer.parseInt(sc.nextLine());
			switch(ch) {
			case 1: studentDetails.addUserDetails(); break;
			case 2: studentDetails.displayUserDetails(); break;
			case 3: studentDetails.deleteUserDetails(); break;
			case 4: studentDetails.saveUserDetails(); break;
			case 5: System.out.println("Do you want to save the changes? (y/n)");
					String scChoice = sc.nextLine();
					if(scChoice.equals("y")) {
						studentDetails.saveUserDetails();
						System.out.println("Changes Saved!");
					}
					sc.close();
					System.exit(0);
			default: System.out.println("Invalid choice!");
			}
		}
	}
	

}
