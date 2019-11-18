/*
 * Created by Manu KJ 
 */
package Assignment2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentController {
	private FileOutputStream fileOutputStream = null;
	private ObjectOutputStream objectOutputStream = null;
	private FileInputStream fileInputStream = null;
	private ObjectInputStream objectInputStream = null;
	private final String FILE_NAME = "Assignment2";
	private List<Student> listOfStudents;
	private List<Integer> studentsRollNumber;

	private Input input = null;

//Constructor
	public StudentController() {
		input = new Input();
		listOfStudents = new ArrayList<Student>();
		studentsRollNumber = new ArrayList<Integer>();
		// Retrieve all the students data from the file
		retriveStudentDetails();

	}

//function to add the student in the list 
	public void addStudent() {
		Student s = new Student();
		System.out.println("Enter student Details (all the fields are mandatory)");
		System.out.println("RollNumber : ");
		s.setRollNumber(input.getValidInt("RollNumber"));
		// if the roll number already exist
		if (studentsRollNumber != null && studentsRollNumber.contains(s.getRollNumber())) {
			System.out.println("Roll Number already exist");
			return;
		}
		System.out.println("Full Name : ");
		s.setFullName(input.getValidString("FullName"));

		System.out.println("Age : ");
		s.setAge(input.getValidInt("Age"));

		System.out.println("Address : ");
		s.setAddress(input.getValidString("Address"));

		ArrayList<String> courses_list = new ArrayList<String>();
		courses_list.add("A");
		courses_list.add("B");
		courses_list.add("C");
		courses_list.add("D");
		courses_list.add("E");
		courses_list.add("F");
		s.setCoursenrolled(input.getValidCourseInput(courses_list, 4));

		listOfStudents.add(s);
		studentsRollNumber.add(s.getRollNumber());

	}

// function to display the user
	public void disaplayAlllistOfStudents(int c) {
		if (listOfStudents.size() != 0) {
			switch (c) {
			case 1:
				// sorting based on Names
				// students are already sorted based on Names
				break;
			case 2:
				// sorting based on roll Number
				Collections.sort(listOfStudents, new Comparator<Student>() {
					@Override
					public int compare(Student arg0, Student arg1) {
						
						return arg0.getRollNumber() - arg1.getRollNumber();
					}
				});
				break;
			case 3:
				// sorting based on age
				Collections.sort(listOfStudents, new Comparator<Student>() {

					@Override
					public int compare(Student arg0, Student arg1) {
						
						return arg0.getAge() - arg1.getAge();
					}
				});
				break;
			case 4:
				// sorting based on address
				Collections.sort(listOfStudents, new Comparator<Student>() {
					@Override
					public int compare(Student arg0, Student arg1) {
				
						return arg0.getAddress().compareTo(arg1.getAddress());
					}
				});
				break;
			default:
				System.out.println("Enter a valid choice");
				return;

			}

			System.out.println("--------------------------------------------------------------");
			System.out.printf("%-15s %-11s %-5s %-20s %-10s", "Roll Number", "Name", "Age", "Address", "Courses\n");
			System.out.println("--------------------------------------------------------------");

			for (Student eachStudent : listOfStudents) {
				System.out.printf("%-15s %-11s %-5s %-20s %-10s\n", eachStudent.getRollNumber(),
						eachStudent.getFullName(), eachStudent.getAge(), eachStudent.getAddress(),
						String.join(" ", eachStudent.getCoursenrolled()));
			}
			System.out.println("\n");
		} else
			System.out.println("listOfStudents list is empty");
	}


	// function to save data into disk
	public void saveStudentsDetails() {
		try {
			fileOutputStream = new FileOutputStream(FILE_NAME);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(listOfStudents);
			System.out.println("details stored to memory");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(int rollNumber) {
		for (Student student : listOfStudents) {
			if (student.getRollNumber() == rollNumber) {
				listOfStudents.remove(student);
				studentsRollNumber.remove(student.getRollNumber());
				return;
			}
		}
		System.out.println("Roll number does not exist");
	}

	@SuppressWarnings("unchecked")
	public void retriveStudentDetails() {
		try {
			fileInputStream = new FileInputStream(FILE_NAME);
			objectInputStream = new ObjectInputStream(fileInputStream);
			listOfStudents = (ArrayList<Student>) objectInputStream.readObject();

			for (Student s : listOfStudents) {
				studentsRollNumber.add(s.getRollNumber());
			}

		} catch (EOFException e) {
			System.out.println("file is empty");
		} catch (FileNotFoundException e) {
			System.out.println("file does not exist");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
