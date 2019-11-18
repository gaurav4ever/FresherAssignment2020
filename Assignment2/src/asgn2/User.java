package asgn2;

public class User implements java.io.Serializable {
	public String name;
	public int rollno;
	public int age;
	public String address;
	public String course;
	
	public User(String name, int rollno, int age, String address, String course) {
		this.name=name;
		this.rollno=rollno;
		this.address=address;
		this.age=age;
		this.course=course;
	}
}
