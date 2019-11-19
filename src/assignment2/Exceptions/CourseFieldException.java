package assignment2.Exceptions;

public class CourseFieldException extends Exception {
	public CourseFieldException() {
		super("Course Field can contain 4 courses out of A, B, C, D, E, F");
	}
}
