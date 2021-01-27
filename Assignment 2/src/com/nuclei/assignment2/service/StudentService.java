package com.nuclei.assignment2.service;

import java.io.IOException;
import java.util.ArrayList;

import com.nuclei.assignment2.beans.Student;
import com.nuclei.assignment2.dao.InfoDAO;

public class StudentService {
	static InfoDAO idao = new InfoDAO();
	public static void saveService (ArrayList<Student> students) {
		try {
			idao.save(students);
			System.out.println("Records saved successfuly!");
		} catch (IOException e) {
			System.out.println("Error in saving records!");
		}
	}
	
	
	public static ArrayList<Student> readService(){
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			students = idao.read();
		} catch (IOException e) {
			System.out.println("Error reading objects from file!");
		}
		
		return students;
	}

}
