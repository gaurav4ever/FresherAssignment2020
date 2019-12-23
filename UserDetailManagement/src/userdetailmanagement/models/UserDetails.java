package userdetailmanagement.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import userdetailmanagement.contants.Constants;

public class UserDetails implements Comparable<UserDetails>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	private String name;
	private int age;
	private int rollNo;
	private String address;
	private ArrayList<String> courses;
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
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = (ArrayList<String>) courses;
	}
	@Override
	public int compareTo(UserDetails o) {
		return Integer.compare(rollNo,o.getRollNo());
	}
	/*
	not able to understand the need of equals
	 */
	public String printCourseList() {
		return "[ " + courses.get(0) + " " + courses.get(1) + " " + courses.get(2) + " " + courses.get(3)+ " ]";
	}
	
	@Override
	public String toString() {
		return String.format(Constants.USER_DETAILS_PRINT_FORMATOR, name, rollNo, age , address, printCourseList() );
	}
}
