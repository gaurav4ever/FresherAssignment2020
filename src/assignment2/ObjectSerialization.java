package assignment2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

class ObjectSerialization {
	private static final String FILE_NAME = "assignment2.txt";
	static public void saveObject(ArrayList<Student> students, ArrayList<Integer> usedRollNumberList) {
		try {
		FileOutputStream file = new FileOutputStream(FILE_NAME); 
        ObjectOutputStream out = new ObjectOutputStream(file); 
        HashMap<ArrayList<Student>,ArrayList<Integer>> hmap = new HashMap<ArrayList<Student>,ArrayList<Integer>>();
        hmap.put(students,usedRollNumberList);
        out.writeObject(hmap); 
          
        out.close(); 
        file.close(); 
		}
		catch (FileNotFoundException e) {
			System.out.println("File: "+FILE_NAME+" not found!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	static public HashMap<ArrayList<Student>,ArrayList<Integer>> retriveObject() {
		HashMap<ArrayList<Student>,ArrayList<Integer>> hmap = new HashMap<ArrayList<Student>,ArrayList<Integer>>();
		try {
			FileInputStream fin = new FileInputStream(FILE_NAME);
			ObjectInputStream ois = new ObjectInputStream(fin);
			hmap = (HashMap<ArrayList<Student>,ArrayList<Integer>>) ois.readObject();
			ois.close();
			fin.close();
		}
		catch (EOFException e) {
			System.out.println("No previously saved data!");
		}
		catch (FileNotFoundException e) {
			System.out.println("File: "+FILE_NAME+" not found!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return hmap;
	}
}
