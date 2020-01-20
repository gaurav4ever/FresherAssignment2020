package com.company.main.student_operations;

import com.company.main.model.Student;

import static com.company.main.Main.scan;
import static com.company.main.student_operations.InputStudentDetails.students;

public class DisplayStudentList {
    public void start()
    {
        System.out.println(" Sort based on ?   1.Name   2.Roll No.   3.Age   4.Address");

        int sortChoice = scan.nextInt();
        switch(sortChoice)
        {
            case 1: students.sort(Student.stuNameComparator);
                break;
            case 2: students.sort(Student.stuRollComparator);
                break;
            case 3: students.sort(Student.stuAgeComparator);
                break;
            case 4: students.sort(Student.stuAddrComparator);
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
