package com.company.main.student_operations;

import com.company.main.ValidateDetails;
import com.company.main.model.Student;

import java.util.ArrayList;
import java.util.List;

import static com.company.main.Main.scan;
import static com.company.main.ValidateDetails.*;

public class InputStudentDetails {
    public static List<Student> students = new ArrayList<>();

    public void start()
    {
        Student student = new Student();

        String name, address, courses;
        int age, rollNo;

        do{
            System.out.println("Enter name");
            name = scan.next();
            student.setName(name);
            validateName(null);
        }while(validateName(name));

        do{
            System.out.println("Enter age");
            age = scan.nextInt();
            student.setAge(age);
        }while(validateAge(age));

        do{
            System.out.println("Enter address");
            address = scan.next();
            student.setAddress(address);
        }while(validateAddress(address));

        do{
            System.out.println("Enter Roll number");
            rollNo = scan.nextInt();
            student.setRollNo(rollNo);
        }while(validateRollNo(rollNo));

        do{
            System.out.println("Enter at least four courses : A,B,C,D,E,F");
            courses = scan.next();
            student.setCourses(courses);
        }while (validateCourses(courses));

        students.sort(Student.stuNameComparator);
        students.add(student);
        System.out.println("Student details added ");
    }
}
