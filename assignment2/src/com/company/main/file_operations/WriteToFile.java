package com.company.main.file_operations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


import static com.company.main.student_operations.InputStudentDetails.students;


public class WriteToFile {
    static String fileName = "myObjects.ser";
    public void start() {

        try {
            FileOutputStream f = new FileOutputStream(new File(fileName));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(students);

            o.close();
            f.close();

            System.out.println("Details saved to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
