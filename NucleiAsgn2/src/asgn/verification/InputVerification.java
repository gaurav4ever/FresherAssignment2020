package asgn.verification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import asgn.StudentRecord;
import asgn.model.Student;

//class for verifying input entered by user

public class InputVerification {

	// verify number of courses, it should be more than 4
	public static boolean verifyNoOfCourses(int nCourses) {
		if (nCourses < 4) {
			System.out.print("number of courses shoud be more than or equal to 4 : ");
			return false;
		} else
			return true;
	}

	// verify that roll number is unique
	public static boolean isRnoVerified(int rno) {
		if (verifyRNo(rno)) {
			return true;
		} else {
			System.out.print("enter unique roll number : ");
			return false;
		}
	}

	// Check if number is unique or not
	public static boolean verifyRNo(int rno) {
		List<Student> studentRecordList = new ArrayList<>();
		studentRecordList = StudentRecord.getStudentRecordList();
		for (int i = 0; i < studentRecordList.size(); i++) {
			if (studentRecordList.get(i).getRollNumber() == rno) {
				return false;
			}
		}
		return true;
	}
}
