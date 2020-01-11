package com.company.main;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.main.Details.students;

public class FileOperations {

    public void writeToFile() {
        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.ser"));
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

            students = (ArrayList<Student>) oi.readObject();
            fi.close();
            oi.close();
            System.out.println("\nDetails read from file : ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Name \t\t Roll No. \t\t Age \t\t Address \t\t Courses");
            System.out.println("-----------------------------------------------------------------------------");
            for( Student st: students)
                System.out.println(st.getName() + "\t\t\t"+ st.getRollNo()  +"\t\t\t" + st.getAge() + "\t\t\t" + st.getAddr() + "\t\t\t" + st.getCourses() );
        }
        catch (Exception e){
            System.out.println("Student details couldn't read from file");
        }
    }
}
