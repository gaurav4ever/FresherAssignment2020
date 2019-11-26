package assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import assignment2.Exceptions.CourseFieldException;
import assignment2.Exceptions.InvalidAgeFieldException;
import assignment2.Exceptions.InvalidNameFieldException;
import assignment2.Exceptions.NullFieldException;
import assignment2.Exceptions.RollNumberAlreadyExistsException;

class StudentDetails {
	static ArrayList<Student> students;
	static Scanner sc = new Scanner(System.in);
	public StudentDetails() {
		students = ObjectSerialization.retriveObject();
	}
	public void addUserDetails() {
		Student student = new Student();
		try {
			System.out.println("Enter Full Name:");
			student.setFullName(sc.nextLine());
			System.out.println("Enter Age:");
			student.setAge(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Address:");
			student.setAddress(sc.nextLine());
			System.out.println("Enter Roll Number:");
			student.setRollNumber(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Courses (space separated):");
			student.setCourses(sc.nextLine());
			students.add(student);
		}
		catch(NullFieldException e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidAgeFieldException e) {
			System.out.println("Age can only be an integer.");
		}
		catch(NumberFormatException e) {
			System.out.println("This field can only be an integer.");
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
		Collections.sort(students);
	}
	public void displayUserDetails() {
		System.out.println("--------------------------------------------------------------");
		System.out.printf("%-14s %-12s %-4s %-18s %-10s\n", "Name", "Roll Number", "Age", "Address", "Courses");
		System.out.println("--------------------------------------------------------------");
		for(Student student:students) {
			System.out.printf("%-14s %-12s %-4s %-18s %-10s\n",student.getFullName(),student.getRollNumber(),student.getAge(),student.getAddress(),student.getAddress());
		}
		
	}
	public void deleteUserDetails() {
		
	}
	public void saveUserDetails() {
		
	}
}
