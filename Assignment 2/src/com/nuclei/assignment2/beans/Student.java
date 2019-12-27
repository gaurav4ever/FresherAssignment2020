package com.nuclei.assignment2.beans;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	String address;
	String rollNo;
	String course[] = new String[4];
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	public Student(String name, int age, String address, String rollNo, String[] course) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.rollNo = rollNo;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + ", rollNo=" + rollNo + ", course="
				+ Arrays.toString(course) + "]";
	}
	
	
}
