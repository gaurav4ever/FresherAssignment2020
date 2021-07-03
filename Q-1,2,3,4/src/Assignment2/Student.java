/*
 * Created by Manu KJ 
 */
package Assignment2;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
	private int age;
	private String address;
	private int rollNumber;
	private String[] coursenrolled;
	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String[] getCoursenrolled() {
		return coursenrolled;
	}

	public void setCoursenrolled(String[] coursenrolled) {
		this.coursenrolled = coursenrolled;
	}

	@Override
	public int compareTo(Student arg) {
		int compareStep1 = this.getFullName().compareTo(arg.getFullName());
		if (compareStep1 != 0)
			return compareStep1;
		else
			return this.getRollNumber() - arg.getRollNumber();

	}

}
