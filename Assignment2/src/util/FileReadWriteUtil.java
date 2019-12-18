package util;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadWriteUtil {
    public static List<Student> readFile(String file) {
        List<Student> list = new ArrayList<>();
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            while (inputStream.available() > 0) {
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
            System.err.println("Error while writing to disk!");
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
   /* public static String getFile() {
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
    }*/
}
