package com.company.main;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.main.Details.students;

public class FileOperations {
    ArrayList<Student> readDetails = new ArrayList<Student>();
    public void writeToFile() {
        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.ser"),true);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(students);

            o.close();
            f.close();

        }
        catch (Exception e){
            System.out.println("Student details couldn't write to file");
        }
    }
    public void readFromFile(){

        try{
            FileInputStream fi = new FileInputStream(new File("myObjects.ser"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            readDetails = (ArrayList<Student>) oi.readObject();
            fi.close();
            oi.close();
            System.out.println("\nDetails read from file : ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Name \t\t Age \t\t Address \t\t Roll No. \t\t Courses");
            System.out.println("-----------------------------------------------------------------------------");
            for( Student st: readDetails)
                System.out.println(st.getName() + "\t\t" + st.getAge() + "\t\t\t" + st.getAddr() + "\t\t" + st.getRollNo() + "\t\t\t" + st.getCourses() );
        }
        catch (Exception e){
            System.out.println("Student details couldn't read from file");
        }
    }
}
