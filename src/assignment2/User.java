package assignment2;

import java.io.Serializable;
import java.util.HashSet;

class User implements Serializable,Comparable<User> {
	private String fullName,address;
	private HashSet<String> courses;
	private int rollNumber,age;
	public User(String fullName, String address, HashSet<String> courses, int rollNumber, int age) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.courses = courses;
		this.rollNumber = rollNumber;
		this.age = age;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the courses
	 */
	public HashSet<String> getCourses() {
		return courses;
	}
	/**
	 * @return the rollNumber
	 */
	public int getRollNumber() {
		return rollNumber;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	@Override
	public int compareTo(User u2) {
		if(this.getFullName()!=u2.getFullName()) {
			String u1FullName = this.getFullName();
			String u2FullName = u2.getFullName();
			if(u1FullName.compareTo(u2FullName)>0) 
				return 1;
			else if(u1FullName.compareTo(u2FullName)==0)
				return 0;
			else
				return -1;
		}
		else {
			if(this.getRollNumber()>u2.getRollNumber())
				return 1;
			else
				return -1;
		}
	}
	
}
