package question2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class user implements Serializable{
	private String name;
	private int age, rollno;
	private String address;
	private ArrayList<String> course;
	
	public user(String name, int age, int rollno, String address, ArrayList<String> course) {
		this.name = name;
		this.age = age;
		this.rollno = rollno;
		this.address = address;
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getRollno() {
		return rollno;
	}

	public String getAddress() {
		return address;
	}

	public ArrayList<String> getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", rollno=" + rollno + ", address=" + address + ", course="
				+ course.toString();
	}
	
}
