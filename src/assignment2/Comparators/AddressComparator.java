package assignment2.Comparators;

import java.util.Comparator;

import assignment2.Student;

public class AddressComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		if(s1.getAddress().compareTo(s2.getAddress())>0) 
			return 1;
		else
			return -1;
	}
}
