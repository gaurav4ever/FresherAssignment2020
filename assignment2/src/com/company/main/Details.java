package com.company.main;

import java.util.*;

public class Details {
    String name, addr, courses;
    String[] coursesSplit ;
    int age, rollNo;
    static List<Student> students = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    public void input()
    {
        Student student = new Student();

        System.out.println("Enter name");
        name = input.next();
        if(name.equals(""))
        {
            System.out.println("Enter valid name");
            name = input.nextLine();
        }

        System.out.println("Enter age");
        age = input.nextInt();
        System.out.println(age);
        if(age<0)
        {
            System.out.println("Enter valid age");
            age = input.nextInt();
        }

        System.out.println("Enter address");
        addr = input.next();
        if(addr.equals(""))
        {
            System.out.println("Enter valid address");
            addr = input.nextLine();
        }

        System.out.println("Enter Roll number");
        rollNo = input.nextInt();
        System.out.println("\n");
        if(rollNo<0)
        {
            System.out.println("Enter valid roll number");
            rollNo = input.nextInt();
        }

        System.out.println("Enter atleast four courses : A,B,C,D,E,F");
        courses = input.next();
        coursesSplit = courses.split(",");
        if(coursesSplit.length < 4)
        {
            System.out.println("Enter more than four courses : ");
            courses = input.next();
        }
        student.Assign(name,addr,courses,age,rollNo);
        //students.add(student);
        addStudent(student);
    }

    public String addStudent(Student student)
    {
        if(student.getName().equals(""))
            return "Please enter valid name";
        if(student.getRollNo()<0)
            return "Please enter valid roll no.";
        if(student.getAge()<0)
            return "Please enter valid age";
        if(student.getAddr().equals(""))
            return "Please enter valid address";
        students.add(student);

        //Collections.sort(students.);

        return "Student added successfully";
    }
    public void display()
    {
        System.out.println("Name \t\t Age \t\t Address \t\t Roll No. \t\t Courses");
        System.out.println("-----------------------------------------------------------------------------");
        for( Student st: students)
            System.out.println(st.getName() + "\t\t" + st.getAge() + "\t\t\t" + st.getAddr() + "\t\t" + st.getRollNo() + "\t\t\t" + st.getCourses() );

    }

}
