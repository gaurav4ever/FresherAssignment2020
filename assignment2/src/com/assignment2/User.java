package com.assignment2;
import java.io.*;
import java.util.*;  
public class User implements Comparable<User>,Serializable{
	private static final long serialVersionUID = -7365823861318693364L;
	private String fullName;
	private int age;
	private String address;
	private int rollNo;
	ArrayList<String> courses=new ArrayList<String>();
	static int choice1;
	static int choice2;
	
	
	public int getChoice1() {
		return choice1;	
	}
	public int getChoice2() {
		return choice2;
	}
	public void setChoice1(int choice1) {
		this.choice1=choice1;
	}
	public void setChoice2(int choice2) {
		this.choice2=choice2;
	}
	public String getName() {
		return fullName;
	}
	public void setName(String fullName) {
		this.fullName = fullName;
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
	public void setAddress(String address){
		this.address = address;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public int compareTo(User user) {
		switch(choice1) {
		case 1 : 
			if(choice2 == 1)
				 return fullName.compareTo(user.getName());
			else
				return (user.getName()).compareTo(fullName);
		case 2:
			if(choice2 == 1)
				return age - user.getAge();
			else
				return user.getAge() - age;
		case 3:
			if(choice2 == 1)
				return address.compareTo(user.getAddress());
			else
				return (user.getAddress()).compareTo(address);
		case 4:
			if(choice2 ==1)
				return rollNo - user.getRollNo();
			else
				return user.getRollNo() - rollNo;
		default:
			if(fullName.compareTo(user.getName())==0)
				return rollNo - user.getRollNo();
			else 
				return fullName.compareTo(user.getName());
		}
		
	}
	@Override
    public String toString() {
        return fullName +"           "+ age+"             " + address +"          " + rollNo +"              "+ courses;
    }
}
