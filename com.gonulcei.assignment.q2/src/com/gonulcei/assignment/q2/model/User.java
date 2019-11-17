package com.gonulcei.assignment.q2.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private String fullname;
	private int age;
	private String address;
	private int rollNo;
	private List<String> courses;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
	public String printCourseList() {
		return "[ " + courses.get(0) + " " + courses.get(1) + " " + courses.get(2) + " " + courses.get(3)+ " ]";
	}
	
	@Override
	public String toString() {
		return String.format("%1$-15s %2$-15d %3$-15d %4$-20s %5$-10s", fullname, rollNo, age , address, printCourseList() );
	}
	
	
}
