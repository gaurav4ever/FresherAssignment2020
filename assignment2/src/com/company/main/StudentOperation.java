package com.company.main;

import java.io.Serializable;
import java.util.*;

public class StudentDetailOperation implements Serializable {
    private String name, address, courses;
    private String[] coursesSplit ;
    private int age, rollNo;
    static List<Student> students = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    
    public void inputStudentDetails()
    {
        Student student = new Student();

        System.out.println("Enter name");
        name = scan.next();

        System.out.println("Enter age");
        age = scan.nextInt();

        System.out.println("Enter address");
        address = scan.next();

        System.out.println("Enter Roll number");
        rollNo = scan.nextInt();

        System.out.println("Enter atleast four courses : A,B,C,D,E,F");
        courses = scan.next();

        validateDetails();

        student.Assign(name, address,courses,age,rollNo);
        Collections.sort(students, Student.stuNameComparator);
        students.add(student);
        System.out.println("Student details added ");
    }

    public void validateDetails(){

        if(name.equals(""))
        {
            System.out.println("Enter valid name");
            name = scan.nextLine();
        }

        if(age<0)
        {
            System.out.println("Enter valid age");
            age = scan.nextInt();
        }

        if(address.equals(""))
        {
            System.out.println("Enter valid address");
            address = scan.nextLine();
        }

        if(rollNo<0)
        {
            System.out.println("Enter valid roll number");
            rollNo = scan.nextInt();
            for( Student st: students)
            {
                if(rollNo == st.getRollNo()){
                    System.out.println("Roll no. already exists, please re-enter");
                    rollNo = scan.nextInt();
                }
            }
        }

        coursesSplit = courses.split(",");
        if(coursesSplit.length < 4)
        {
            System.out.println("Enter more than four courses : ");
            courses = scan.next();
        }
    }
    public void delete()
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

    public void display()
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
        }
        System.out.println("Student details in sorted order :");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Name \t\t Roll No. \t\t Age \t\t Address  \t\t Courses");
        System.out.println("-----------------------------------------------------------------------------");
        for( Student st: students)
            System.out.println(st.getName() + "\t\t" + st.getRollNo() + "\t\t" + st.getAge() + "\t\t\t" + st.getAddr() + "\t\t\t" + st.getCourses() );
        System.out.println("-----------------------------------------------------------------------------");
    }
}
