//Assignment 2 working on it
package asgn2;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Assignment2 {
	public static void main(String args[]) throws Exception {
	Scanner sc=new Scanner(System.in);
//this program doesn't give the user choice of action as of now. The user details can only be added and displayed. 
	System.out.println("Enter user details: ");
	System.out.print("Name: ");
	String name=sc.next();
	System.out.print("Rollno: ");
	int rollno=sc.nextInt();
	System.out.print("Age: ");
	int age=sc.nextInt();
	System.out.print("Address: ");
	String address=sc.next();
	System.out.print("Course: ");
	String course=sc.next();
//class User id a structured class to store user details in an object
	User stu=new User(name,rollno,age,address,course);
	File filename=new File("data.txt");
	writeIn(stu);
	display(filename);
	System.out.println("Done");
}

//method to write the User object in a file.
	public static void writeIn(User stu) throws IOException{
		FileOutputStream fos=new FileOutputStream("data.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(stu);
		oos.close();
		fos.close();	
	}
//method to read the file
	public static void display(File filename) throws IOException, ClassNotFoundException{
		FileInputStream fis=new FileInputStream(filename);
		ObjectInputStream ois=new ObjectInputStream(fis);
		User p=(User) ois.readObject();
		System.out.println("Name: "+p.name.toString()+"  Rollno:"+p.rollno+"  Age:"+p.age+"  Address:"+p.address.toString()+"  Courses:"+p.course.toString());
		ois.close();
		fis.close();
	}
}
