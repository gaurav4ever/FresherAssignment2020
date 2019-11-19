/**
 * Author: Bhavyadeep
 */
package assignment2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import assignment2.Exceptions.NullFieldException;
import assignment2.Exceptions.RollNumberAlreadyExistsException;
import assignment2.Exceptions.CourseFieldException;
import assignment2.Exceptions.InvalidAgeFieldException;
import assignment2.Exceptions.InvalidNameFieldException;

class Assignment2 {
	final static String FILE_NAME = "assignment2.txt";
	static ArrayList<User> users = new ArrayList<User>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		addStoredDetails();
		int ch;
		while(true) {
			System.out.println("1. Add User Details");
			System.out.println("2. Display User Details");
			System.out.println("3. Delete User Details");
			System.out.println("4. Save User Details");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			ch = Integer.parseInt(sc.nextLine());
			switch(ch) {
			case 1: addUserDetails(); break;
			case 2: displayUserDetails(); break;
			case 3: deleteUserDetails(); break;
			case 4: saveUserDetails(); break;
			case 5: sc.close(); System.exit(0);
			default: System.out.println("Invalid choice!");
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static void addStoredDetails() {
		try {
			FileInputStream fin = new FileInputStream(FILE_NAME);
			ObjectInputStream ois = new ObjectInputStream(fin);
			users = (ArrayList<User>) ois.readObject();
			ois.close();
			fin.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File: "+FILE_NAME+" not found!");
		}
		catch (EOFException e) {
			System.out.println("No previously saved data!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void addUserDetails() {
		User user = new User();
		try {
			System.out.println("Enter Full Name:");
			user.setFullName(sc.nextLine());
			System.out.println("Enter Age:");
			user.setAge(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Address:");
			user.setAddress(sc.nextLine());
			System.out.println("Enter Roll Number:");
			user.setRollNumber(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Courses (space separated):");
			user.setCourses(sc.nextLine());
			users.add(user);
		}
		catch(NullFieldException e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidAgeFieldException e) {
			System.out.println("Age can only be an integer.");
		}
		catch(NumberFormatException e) {
			System.out.println("Age can only be an integer.");
		}
		catch(InvalidNameFieldException e) {
			System.out.println(e.getMessage());
		} 
		catch (RollNumberAlreadyExistsException e) {
			System.out.println(e.getMessage());
		} 
		catch (CourseFieldException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void displayUserDetails() {
		System.out.println("--------------------------------------------------------------");
		System.out.printf("%-14s %-12s %-4s %-18s %-10s\n", "Name", "Roll Number", "Age", "Address", "Courses");
		System.out.println("--------------------------------------------------------------");
		for(User user:users) {
			System.out.printf("%-14s %-12s %-4s %-18s %-10s\n",user.getFullName(),user.getRollNumber(),user.getAge(),user.getAddress(),user.getAddress());
		}
		
	}
	private static void deleteUserDetails() {
		
	}
	private static void saveUserDetails() {
		
	}

}
