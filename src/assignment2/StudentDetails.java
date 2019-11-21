package assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import assignment2.Comparators.RollNumberComparator;
import assignment2.Comparators.AgeComparator;
import assignment2.Comparators.AddressComparator;

import assignment2.Exceptions.CourseFieldException;
import assignment2.Exceptions.InvalidAgeFieldException;
import assignment2.Exceptions.InvalidNameFieldException;
import assignment2.Exceptions.NullFieldException;
import assignment2.Exceptions.RollNumberAlreadyExistsException;

class StudentDetails {
	static ArrayList<Student> students = new ArrayList<Student>();
	Scanner sc = new Scanner(System.in);
	public StudentDetails() {
		HashMap<ArrayList<Student>,ArrayList<Integer>> hmap = ObjectSerialization.retriveObject();
		for (HashMap.Entry<ArrayList<Student>,ArrayList<Integer>> h : hmap.entrySet()) {
			students = h.getKey();
			Student.usedRollNumberList=h.getValue();
		}
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
		try {
		System.out.println("1.Name\n2.Roll Number\n3.Age\n4.Address");
		System.out.println("Enter the field to sort:");
		int sortField = Integer.parseInt(sc.nextLine());
		System.out.println("1.Ascending\n2.Descending");
		System.out.println("Enter your choice:");
		int sortOrder = Integer.parseInt(sc.nextLine());
		if(sortField<1 || sortField > 4 || sortOrder < 1 || sortOrder >2)
			throw new NumberFormatException();
		if(sortOrder==1) {
			switch(sortField) {
			case 1: Collections.sort(students); break;
			case 2: Collections.sort(students,new RollNumberComparator()); break;
			case 3: Collections.sort(students,new AgeComparator()); break;
			case 4: Collections.sort(students, new AddressComparator());break;
			}
		}
		else {
			switch(sortField) {
			case 1: Collections.sort(students, Collections.reverseOrder()); break;
			case 2: Collections.sort(students,Collections.reverseOrder(new RollNumberComparator())); break;
			case 3: Collections.sort(students,Collections.reverseOrder(new AgeComparator())); break;
			case 4: Collections.sort(students,Collections.reverseOrder(new AddressComparator()));
		}
		}
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid Choice!");
		}
		System.out.println("--------------------------------------------------------------");
		System.out.printf("%-14s %-12s %-4s %-18s %-10s\n", "Name", "Roll Number", "Age", "Address", "Courses");
		System.out.println("--------------------------------------------------------------");
		for(Student student:students) {
			System.out.printf("%-14s %-12s %-4s %-18s %-10s\n",student.getFullName(),student.getRollNumber(),student.getAge(),student.getAddress(),student.getCourses());
		}
	}
	public void deleteUserDetails() {
		System.out.println("Enter the roll number:");
		int deleteRollNumber= Integer.parseInt(sc.nextLine());
		if (Student.usedRollNumberList.contains(deleteRollNumber)) {
			Iterator<Student> itr = students.iterator();
			while(itr.hasNext()) {
				int rollNumber = itr.next().getRollNumber();
				if (rollNumber == deleteRollNumber) {
					itr.remove();
					System.out.println("Student Detail deleted!");
				}
			}
		}
		else {
			System.out.println("This roll number does not exists!");
		}
	}
	public void saveUserDetails() {
		ObjectSerialization.saveObject(students,Student.usedRollNumberList);
	}
}
