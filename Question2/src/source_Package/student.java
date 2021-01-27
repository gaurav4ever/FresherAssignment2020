package source_Package;

import java.io.Serializable;

//Base class student 
public class student implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private String name;
	private int roll;
	private String addr;
	private int age;
	private course c;
	
	student(String name,int roll,String addr,int age,int num)
	{
		this.name = name;
		this.roll = roll;
		this.addr = addr;
		this.age = age;
		c = new course(num);
	}
	
	//This constructor is only used for JUnit Testing
	student(String name,int roll,String addr,int age)
	{
		this.name = name;
		this.roll = roll;
		this.addr = addr;
		this.age = age;		
	}
	
	public String get_name()
	{
		return name;
	}
	
	public String get_addr()
	{
		return addr;
	}
	
	public int get_roll()
	{
		return roll;
	}
	
	public int get_age()
	{
		return age;
	}
	
	public void print_courses()
	{
		c.print_courses();
	}

}
