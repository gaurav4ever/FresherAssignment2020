package assignment2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import assignment2.Exceptions.CourseFieldException;
import assignment2.Exceptions.InvalidAgeFieldException;
import assignment2.Exceptions.InvalidNameFieldException;
import assignment2.Exceptions.NullFieldException;
import assignment2.Exceptions.RollNumberAlreadyExistsException;

import java.util.regex.Pattern;
public class Student implements Serializable,Comparable<Student> {
	private static final long serialVersionUID = 1L;
	private String fullName,address;
	private HashSet<String> courses;
	private int rollNumber,age;
	public static ArrayList<Integer> usedRollNumberList = new ArrayList<Integer>();
	private static final String[] AVAILABLE_COURSES = {"A","B","C","D","E","F"};
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
	public String getCourses() {
		return courses.toString();
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
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) throws NullFieldException,InvalidNameFieldException {
		if(fullName.equals("")) {
			throw new NullFieldException();
		}
		if(Pattern.matches("[a-z A-Z]+", fullName)) {
			this.fullName = fullName;
		}
		else
			throw new InvalidNameFieldException();
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) throws NullFieldException {
		if(address.equals("")) {
			throw new NullFieldException();
		}
		this.address = address;
	}
	/**
	 * @param courses the courses to set
	 * @throws CourseFieldException 
	 * @throws NullFieldException 
	 */
	public void setCourses(String courses) throws CourseFieldException, NullFieldException {
		if(courses.equals("")) {
			throw new NullFieldException();
		}
		HashSet<String> availableCourses = new HashSet<String>();
		for(String c : AVAILABLE_COURSES) {
			availableCourses.add(c);
		}
		HashSet<String> chosenCourses = new HashSet<String>();
		for(String c : courses.split(" ")) {
			chosenCourses.add(c);
		}
		if(chosenCourses.size()!= 4 || !availableCourses.containsAll(chosenCourses)) {
			throw new CourseFieldException();
		}
		this.courses=chosenCourses;
	}
	/**
	 * @param rollNumber the rollNumber to set
	 * @throws RollNumberAlreadyExistsException 
	 */
	public void setRollNumber(int rollNumber) throws RollNumberAlreadyExistsException {
		if(Student.usedRollNumberList.contains(rollNumber)) {
			throw new RollNumberAlreadyExistsException();
		}
		this.rollNumber = rollNumber;
		usedRollNumberList.add(rollNumber);
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) throws InvalidAgeFieldException {
		if(age<=0)
			throw new InvalidAgeFieldException();
		this.age = age;
	}
	@Override
	public int compareTo(Student u2) {
		if(this.getFullName()!=u2.getFullName()) {
			String u1FullName = this.getFullName();
			String u2FullName = u2.getFullName();
			if(u1FullName.compareTo(u2FullName)>0) 
				return 1;
			else
				return -1;
		}
		else {
			return this.getRollNumber()-u2.getRollNumber();
		}
	}
	
}
