package userdetailmanagement.model;
import java.util.ArrayList;
public class User implements Comparable<User>{
	private String name;
	private int age;
	private int rollNo;
	private String address;
	private ArrayList courses;
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
	public ArrayList getCourses() {
		return courses;
	}
	public void setCourses(ArrayList courses) {
		this.courses = courses;
	}
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		if(rollNo < o.getRollNo())
			return -1;
		return 0;
	}
	
	@Override
	public String toString()
	{
		return name+" "+age+" "+rollNo+" "+address+" "+courses;
	}
	
}
