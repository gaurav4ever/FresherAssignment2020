package assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assignment2.Exceptions.CourseFieldException;
import assignment2.Exceptions.InvalidAgeFieldException;
import assignment2.Exceptions.InvalidNameFieldException;
import assignment2.Exceptions.NullFieldException;

class Assignment2Test {

	@Test
	void test1() {
		Student student = new Student();
		assertAll(
				() -> assertThrows(NullFieldException.class, () -> student.setFullName("")),
				() -> assertThrows(InvalidNameFieldException.class, () -> student.setFullName("Hacker99")),
				() -> assertThrows(NullFieldException.class, () -> student.setAddress("")),
				() -> assertThrows(NullFieldException.class, () -> student.setCourses("")),
				() -> assertThrows(CourseFieldException.class, () -> student.setCourses("ABCD")),
				() -> assertThrows(CourseFieldException.class, () -> student.setCourses("A G B C")),
				() -> assertThrows(CourseFieldException.class, () -> student.setCourses("A B C")),
				() -> assertThrows(CourseFieldException.class, () -> student.setCourses("A G B C")),
				() -> assertThrows(InvalidAgeFieldException.class, () -> student.setAge(-31))
				);
	}

}
