package asgn2;
import java.util.*;
import java.util.Arrays;
import java.io.Serializable;
public class User implements Serializable {
	static final long serialVersionUID = 1L;
	private String name;
	private int rollno;
	private int age;
	private String address;
	private ArrayList<String> course = new ArrayList<String>();
	Scanner sc=new Scanner(System.in);
	public String getName() {
		return name;
	}
	public int getRollno() {
		return rollno;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public ArrayList<String> getCourse() {
		return course;
	}
	public void setName(String n) {
		name=n;
	}
	public void setRollno(int r) {
		rollno=r;
	}
	public void setAge(int a) {
		age=a;
	}
	public void setAddress(String ad) {
		address=ad;
	}
	public void setCourse(String c) {
		course.add(c);
	}
	public void userInput() {
		//User user=new User();
		ArrayList<String> courseList= new ArrayList<String>(6);
		courseList.add("A");
		courseList.add("B");
		courseList.add("C");
		courseList.add("D");
		courseList.add("E");
		courseList.add("F");
		System.out.println("Enter user details: ");
		System.out.print("Name: ");
		this.setName(sc.next());
		System.out.print("Rollno: ");
		this.setRollno(sc.nextInt());
		System.out.print("Age: ");
		this.setAge(sc.nextInt());
		System.out.print("Address: ");
		this.setAddress(sc.next());
		System.out.print("Course (A/B/C/D/E/F): ");
		while(true) {
			if((this.getCourse()).size()==4) {break;}
			String c=sc.next();
			if ((this.getCourse()).indexOf(c)==-1 && courseList.contains(c)) {
				this.setCourse(c);
			}
			else if(!((this.getCourse()).indexOf(c)==-1 && Arrays.asList(courseList).contains(c))) {
				System.out.println("Invalid course choice, Re-enter");
			}
		}
		
	}
}
