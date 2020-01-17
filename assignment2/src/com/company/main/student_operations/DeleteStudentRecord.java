package com.company.main.StudentOperations;

import com.company.main.Model.Student;

import static com.company.main.Main.scan;
import static com.company.main.StudentOperations.InputStudentDetails.students;

public class DeleteStudentRecord {
    public void deleteStudentRecord()
    {
        System.out.println("Enter Roll no.");
        int rollNo = scan.nextInt();
        int f=0;
        for(Student st: students)
        {
            if(st.getRollNo()==rollNo)
            {
                f=1;
                students.remove(st);
                System.out.println("Student detail with roll no. "+rollNo+" deleted");
            }
        }
        if(f==0)
            System.out.println("Roll No. does not exist");
    }
}
