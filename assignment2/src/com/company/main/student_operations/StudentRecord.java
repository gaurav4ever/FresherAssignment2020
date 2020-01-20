package com.company.main.student_operations;

import com.company.main.model.Student;

import static com.company.main.Main.scan;
import static com.company.main.student_operations.InputStudentDetails.students;

public class DeleteStudentRecord {
    public void start()
    {
        System.out.println( "Enter Roll number to be deleted" );
        int rollNo = scan.nextInt();
        int f=0;
        for( Student st: students)
        {
            if(st.getRollNo() == rollNo)
            {
                f=1;
                students.remove(st);
                System.out.println("Student detail with roll number "+rollNo+" is deleted");
            }
        }
        if(f == 0)
            System.out.println("Roll Number " + rollNo + " does not exist");
    }
}
