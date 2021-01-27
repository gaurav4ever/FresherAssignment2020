package com.nuclei.assignment2.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.nuclei.assignment2.beans.Student;

public class InfoDAO {
	public void save(ArrayList<Student> students) throws IOException{
		File studentDB = new File("StudentInfo.dat");
		FileOutputStream fos = new FileOutputStream(studentDB);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		for(Student student : students) {
			out.writeObject(student);
		}
		out.close();
		fos.close();
	}
	
	public ArrayList<Student> read() throws IOException{
		ArrayList<Student> students = new ArrayList<Student>();
		File studentDB = new File("StudentInfo.dat");
		FileInputStream fis = new FileInputStream(studentDB);
		ObjectInputStream ois = new ObjectInputStream(fis);
		while(fis.available() > 0) {
			try {
				Object obj = ois.readObject();
				if(obj instanceof Student) {
					students.add((Student) obj);
				}
			}catch(ClassNotFoundException e) {
				System.out.println("Invalid Object found!");
			}
			
		}
		ois.close();
		fis.close();
		return students;
	}

}
