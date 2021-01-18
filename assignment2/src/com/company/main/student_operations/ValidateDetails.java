package com.company.main;

import com.company.main.model.Student;

import static com.company.main.Main.scan;
import static com.company.main.student_operations.StudentDetails.students;

public class ValidateDetails {

    public static Boolean validateName(String name){
        if(name.equals(""))
        {
            System.out.println("Enter valid name");
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Boolean validateAge(int age){
        if(age < 0)
        {
            System.out.println("Enter valid age");
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean validateAddress(String address){
        if(address.equals(""))
        {
            System.out.println("Enter valid address");
            return true;
        }
        else
            {
            return false;
        }
    }

    public static Boolean validateRollNo(int rollNo){
        if(rollNo<0)
        {
            System.out.println("Enter valid roll number");
            rollNo = scan.nextInt();
            for( Student st: students)
            {
                if(rollNo == st.getRollNo()){
                    System.out.println("Roll no. already exists, please re-enter");
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean validateCourses(String courses){
        String[] coursesSplit = courses.split(",");
        if(coursesSplit.length < 4)
        {
            System.out.println("Enter more than four courses : ");
            return true;
        }
        return false;
    }
}
