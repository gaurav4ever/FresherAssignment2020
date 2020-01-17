package com.company.main.StudentOperations;

import com.company.main.Model.Student;

import java.util.Collections;

import static com.company.main.Main.scan;
import static com.company.main.StudentOperations.InputStudentDetails.students;

public class DisplayStudentList {
    public void displayStudentList()
    {
        System.out.println(" Sort based on ?   1.Name   2.Roll No.   3.Age   4.Address");
        int ch = scan.nextInt();
        switch(ch)
        {
            case 1: Collections.sort(students, Student.stuNameComparator);
                break;
            case 2: Collections.sort(students, Student.stuRollComparator);
                break;
            case 3: Collections.sort(students, Student.stuAgeComparator);
                break;
            case 4: Collections.sort(students, Student.stuAddrComparator);
                break;
            default: break;
        }
        System.out.println("Student details in sorted order :");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Name \t\t Roll No. \t\t Age \t\t Address  \t\t Courses");
        System.out.println("-----------------------------------------------------------------------------");
        for( Student st: students)
            System.out.println(st.getName() + "\t\t" + st.getRollNo() + "\t\t" + st.getAge() + "\t\t\t" + st.getAddress() + "\t\t\t" + st.getCourses() );
        System.out.println("-----------------------------------------------------------------------------");
    }

}
