/*
 * Created by Manu KJ 
 */
package Assignment2;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("Assignment 2")
class TestAssignment2 {

	@Test
	@Order(1)
	@DisplayName("Validating String and Empty field")
	void test_String_and_Empty_Field() {
		Input input = new Input();
		assertAll(
				() -> assertEquals("Student1",
						input.getValidString("Name", "Student1", "ValidateSting with correct Input")),
				() -> assertEquals("Student2", input.getValidString("Name", "",
						"ValidateString for empty string ||Enter Full Name as Student2||")));

	}

	@Test
	@Order(2)
	@DisplayName("Validating Integer and Empty field")
	void test_Integer_and_Empty_Field() {
		Input input = new Input();
		assertAll(() -> assertEquals(12, input.getValidInt("Age", "12", "ValidateInt with correct Input")),
				() -> assertEquals(12, input.getValidInt("Age", "", "ValidateInt with Empty field ||Enter Age  12||")),
				() -> assertEquals(12,
						input.getValidInt("Age", "122ds", "ValidateInt with String as Input ||Enter Age  12||")));

	}

	@Test
	@Order(3)
	@DisplayName("Validating Integer and Empty field")
	void test_Course_list() {
		ArrayList<String> courses_list = new ArrayList<String>();
		courses_list.add("A");
		courses_list.add("B");
		courses_list.add("C");
		courses_list.add("D");
		courses_list.add("E");
		courses_list.add("F");
		Input input = new Input();
		String expected = "A B C D";
		String fail1 = "A B C";
		String fail2 = "A B C D G";
		String fail3 = "";
		assertAll(
				() -> assertArrayEquals(expected.trim().split(" "),
						input.getValidCourseInput(courses_list, 4, expected, "ValidateCourse with correct Input")),
				() -> assertArrayEquals(expected.trim().split(" "),
						input.getValidCourseInput(courses_list, 4, fail1,
								"ValidateCourse with only 3 Courses |Enter the course A B C D|")),
				() -> assertArrayEquals(expected.trim().split(" "),
						input.getValidCourseInput(courses_list, 4, fail2,
								"ValidateCourse with unknown Course |Enter the course A B C D|")),
				() -> assertArrayEquals(expected.trim().split(" "), input.getValidCourseInput(courses_list, 4, fail3,
						"ValidateCourse with Empty field |Enter the course A B C D|")));
	}

}
