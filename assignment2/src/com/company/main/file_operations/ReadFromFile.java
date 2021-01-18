package com.company.main.FileOperations;

import com.company.main.Model.Student;

import java.io.*;
import java.util.ArrayList;

import static com.company.main.StudentOperations.InputStudentDetails.students;
import static com.company.main.FileOperations.WriteToFile.fileName;

public class ReadFromFile {
    public void readFromFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            students = (ArrayList<Student>) objectInputStream.readObject();

            fileInputStream.close();
            objectInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
