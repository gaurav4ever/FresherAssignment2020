package com.company.main.StudentOperations;

import com.company.main.Model.Student;
import com.company.main.ValidateDetails;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static com.company.main.Main.scan;

public class InputStudentDetails {
    public static List<Student> students = new ArrayList<>();

    public void start()
    {
        Student student = new Student();
        ValidateDetails validateDetails = new ValidateDetails();

        System.out.println("Enter name");
        String name = scan.next();
        student.setName(name);
        validateDetails.validateName(name);

        System.out.println("Enter age");
        int age = scan.nextInt();
        student.setAge(age);
        validateDetails.validateAge(age);

        System.out.println("Enter address");
        String address = scan.next();
        student.setAddress(address);
        validateDetails.validateAddress(address);

        System.out.println("Enter Roll number");
        int rollNo = scan.nextInt();
        student.setRollNo(rollNo);
        validateDetails.validateRollNo(rollNo);

        System.out.println("Enter atleast four courses : A,B,C,D,E,F");
        String courses = scan.next();
        student.setCourses(courses);
        validateDetails.validateCourses(courses);

        Collections.sort(students, Student.stuNameComparator);
        students.add(student);
        System.out.println("Student details added ");
    }
}
