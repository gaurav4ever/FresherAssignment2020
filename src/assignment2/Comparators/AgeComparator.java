package assignment2.Comparators;

import java.util.Comparator;

import assignment2.Student;

public class AgeComparator implements Comparator<Student> {
	public int compare(Student s1,Student s2) {
		return s1.getAge() - s2.getAge();
	}
}
