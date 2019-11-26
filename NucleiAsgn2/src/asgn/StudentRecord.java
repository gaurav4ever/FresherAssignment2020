package asgn;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import asgn.model.Student;
import asgn.util.InputUtil;
import asgn.util.OuputUtil;

public class StudentRecord {

	private static Student student;
	private static String studentRecFileName;
	private static List<Student> studentRecordList;

	public static void main(String[] args) {
		studentRecFileName = StudentFileReadWrite.getFile(); // extract and read student file from memory
		studentRecordList = StudentFileReadWrite.readFile("studentData.txt");
		int choice = InputUtil.getInputItemChoice(); // menu for selecting options
		performAction(choice); // perform task according to the option chosen
	}

	private static void performAction(int choice) {
		switch (choice) {
		case 1:
			student = InputUtil.getInputUserDetails(); // get command line input of user details
			studentRecordList.add(student); // add all the new entries to a list
			break;
		case 2:
			OuputUtil.displayUserDetails(studentRecordList);
			break;
		case 3:
			deleteUserDetails();
			break;
		case 4:
			saveUserDetails();
			break;
		case 5:
			exitProgram();
			break;
		}

		// ask user for multiple input
		int choice1 = InputUtil.askAnotherInput();
		performAction(choice1);
	}

	public static void exitProgram() {
		System.out.print("------END------");
		System.exit(0);
	}

	// save user data into memory
	private static void saveUserDetails() {
		if (studentRecordList.equals(null)) {
			System.out.println("Nothing to add!");
		} else {
			// Records are sorted on full name. If name is same for two students then
			// sorting based on the roll number.
			Comparator<Student> comparator = Comparator.comparing(Student::getName)
					.thenComparing(Student::getRollNumber);
			Collections.sort(studentRecordList, comparator);

			StudentFileReadWrite.writeFile(studentRecordList, studentRecFileName);
			System.out.println("Data successfully saved!");

		}
	}

	private static void deleteUserDetails() {
		int deleteRno = InputUtil.inputRnoToBeDeleted();
		boolean deleted = false;
		for (int i = 0; i < studentRecordList.size(); i++) {
			if (studentRecordList.get(i).getRollNumber() == deleteRno) { // check for matching roll number in the
																			// records
				studentRecordList.remove(i);
				saveUserDetails();
				deleted = true;
				System.out.print("Data successfully deleted!");
				break;
			}
		}
		if (!deleted) {
			System.out.println("There is no entry in student record with given roll number!");
		}
	}

	public static List<Student> getStudentRecordList() {
		return studentRecordList;
	}
}
