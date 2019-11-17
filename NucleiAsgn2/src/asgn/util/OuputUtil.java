package asgn.util;

import java.util.List;

import asgn.model.Student;

public class OuputUtil {

	// print results on command prompt in proper format
	public static void displayUserDetails(List<Student> studentRecordList) {
		if (studentRecordList.isEmpty()) {
			System.out.println("No user details present\n");
		}
		System.out.println("User Details : \n");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-30s %-30s %-30s %-30s %-30s%n \n", "Name", "Age", "Address", "Roll Number", "Courses");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < studentRecordList.size(); i++) {
			String coursesString = "";
			int size = studentRecordList.get(i).getCourse().getCourses().size();
			
			//formatting the courses in form of a string
			for (int j = 0; j < size; j++) {
				coursesString += studentRecordList.get(i).getCourse().getCourses().get(j);
				if(j!=size-1) {
					coursesString += ", ";
				}
			}
			
			//print output
			System.out.printf("%-30s %-30s %-30s %-30s %-30s%n", studentRecordList.get(i).getName(),
					studentRecordList.get(i).getAge(), studentRecordList.get(i).getAddress(),
					studentRecordList.get(i).getRollNumber(), coursesString);
		}
	}
}
