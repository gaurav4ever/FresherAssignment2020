package com.nuclei.assignment2.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.nuclei.assignment2.beans.Student;
import com.nuclei.assignment2.service.StudentService;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int choice;
		String name;
		int age = 0;
		String address;
		int rollNo;
		String course[] = new String[4];
		ArrayList<Student> students = StudentService.readService();
		boolean con = true;
		while(true) {
			System.out.println("Enter \n1. Add User Details \t 2. Display User Details \t 3. Delete User Details \t 4. Save User Details \t 5. Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:	//User Input
					System.out.println("Enter full name");
					name = sc.nextLine();
					System.out.println("Enter age");
					while(con) {
						try {
							age = sc.nextInt();
							con = false;
						}catch(InputMismatchException e) {
							sc.next();
							System.out.println("Please enter a valid number");
						}
					}
					sc.nextLine();
					System.out.println("Enter Address");
					address = sc.nextLine();
					System.out.println("Enter Roll No.");
					rollNo = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Courses, 4 out of 6: A, B, C, D, E, F");
					for(int i = 0; i < 4; i++) {
						System.out.println("Enter course "+(i+1));
						course[i] = sc.nextLine();
						while(!"A".equals(course[i]) && !"B".equals(course[i]) && !"C".equals(course[i]) && !"D".equals(course[i]) && !"E".equals(course[i]) && !"F".equals(course[i])) {
							System.out.println("Enter valid course!");
							course[i] = sc.nextLine();
						}
					}
					students.add(new Student(name, age, address, rollNo, course));
					Collections.sort(students);
					break;
			case 2:	//Display
					System.out.println("----------------------------------------------------------------------------------------------------");
					System.out.println("Name \t Roll Number \t Age \t Address \t Courses");
					System.out.println("----------------------------------------------------------------------------------------------------");
					for(Student s : students) {
						System.out.println(s.getName()+" \t"+s.getRollNo()+" \t"+s.getAge()+" \t"+s.getAddress()+" \t"+s.getCourse()[0]+","+s.getCourse()[1]+","+s.getCourse()[2]+","+s.getCourse()[3]);
					}
					break;
			case 3: //Delete record
					System.out.println("Enter the Roll Number to delete");
					int dRoll = sc.nextInt();
					Student remove = null;
					boolean found = false;
					for(Student student : students) {
						if(student.getRollNo() == dRoll) {
							found = true;
							remove = student;
						}
					}
					students.remove(remove);
					Collections.sort(students);
					System.out.println("Record Deleted!");
					if(!found) {
						System.out.println("No such Roll Number exists!");
					}
					break;
			case 4: //Save records
					StudentService.saveService(students);
					break;
			case 5: //Exit program
					System.out.println("Do you want to save the details before exit? y/n");
					String ch = sc.nextLine();
					if("y".equals(ch) || "yes".equals(ch)) {
						StudentService.saveService(students);
					}
					sc.close();
					System.exit(0);
					break;
			default: System.out.println("Enter valid option!");
			}
		}
	}
}