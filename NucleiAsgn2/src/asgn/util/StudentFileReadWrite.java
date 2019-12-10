package asgn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import asgn.model.Student;

public class StudentFileReadWrite {

    // loads record in memory from disk and returns the it as Student list
    public static List<Student> readFile(String file) {
        List<Student> list = new ArrayList<>();
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                Student p = (Student) inputStream.readObject();
                list.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error opening file."+e);
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
        return list;
    }

    // saves data in disk by writing each item of the list to disk
    public static void writeFile(List<Student> list, String file) {
        ObjectOutputStream outStream = null;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(file));
            for (Student p : list) {
                outStream.writeObject(p);
            }
        } catch (Exception e) {
            System.err.println("Error in wirtting items!");
        } finally {
            try {
                if (outStream != null)
                    outStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
    }

    // extract student file from memory if exists
    public static String getFile() {
        String fileName = "studentData.txt";
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                // File created in root directory
            } else {
                // File already exists in root directory
            }
        } catch (IOException e) {
            System.out.print("Student Record not found!");
            e.printStackTrace();
        }
        return fileName;
    }
}
