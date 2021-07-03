/*
 * Created by Manu KJ 
 */
package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	private Scanner sc = null;

	public Input() {
		sc = new Scanner(System.in);
	}

	// functions that validate input String
	public String getValidString(String input_msg, String... for_testing) {
		String regex = "[\\s\\w]+";
		String string = null;
		if (for_testing.length > 0) {
			System.out.println(for_testing[1]);
			string = for_testing[0];
		} else
			string = sc.nextLine();
		while (!string.matches(regex)) {
			System.out.println(input_msg + " is not a valid input");
			string = sc.nextLine();
		}
		return string;
	}

	// functions that validate input Integer
	public int getValidInt(String input_msg, String... for_testing) {
		String regex = "\\d+";
		String number = null;
		if (for_testing.length > 0) {
			System.out.println(for_testing[1]);
			number = for_testing[0];
		} else
			number = sc.nextLine();
		while (!number.matches(regex)) {
			System.out.println(input_msg + " is not a valid input");
			number = sc.nextLine();
		}
		return Integer.parseInt(number);
	}

	public String[] getValidCourseInput(ArrayList<String> courses_list, int more_than, String... for_testing) {
		int test_flag = 0;
		String courses;
		outter: while (true) {
			System.out.println("Courses Offered are A B C D E F");
			if (test_flag == 0) {
				courses = getValidString("courses", for_testing).trim();
				test_flag = 1;
			} else
				courses = getValidString("courses").trim();
			String course_enrolled[] = courses.split(" ");
			for (String course : course_enrolled) {
				if (courses_list.contains(course))
					continue;
				else {
					System.out.println(course + " course is not offered ");
					continue outter;
				}
			}
			if (course_enrolled.length < more_than) {
				System.out.println(" It is mandatory for each student to choose atleast 4 out of 6 courses");
				continue;
			}
			return course_enrolled;
		}
	}

}
