package assignment2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

class ObjectSerialization {
	private static final String FILE_NAME = "assignment2.txt";
	static public void saveObject(ArrayList<Student> students) {
		
	}
	@SuppressWarnings("unchecked")
	static public ArrayList<Student> retriveObject() {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			FileInputStream fin = new FileInputStream(FILE_NAME);
			ObjectInputStream ois = new ObjectInputStream(fin);
			students = (ArrayList<Student>) ois.readObject();
			ois.close();
			fin.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File: "+FILE_NAME+" not found!");
		}
		catch (EOFException e) {
			System.out.println("No previously saved data!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return students;
	}
}
