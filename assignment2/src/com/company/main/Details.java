package com.company.main;

import java.io.Serializable;
import java.util.*;
import java.io.*;

public class Details implements Serializable {
    String name, addr, courses;
    String[] coursesSplit ;
    int age, rollNo;
    static List<Student> students = new ArrayList<>();

    Student st = new Student();

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
        for( Student st: students)
        {
            if(rollNo == st.getRollNo()){
                System.out.println("Roll no. already exists, please re-enter");
                rollNo = input.nextInt();
            }
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

        Collections.sort(students, Student.stuNameComparator);
        System.out.println("Student details added");

//       --------------------------------------------------------------------------------------------------------------------------------------------------------
//        Sorting with Hashmap logic
//       --------------------------------------------------------------------------------------------------------------------------------------------------------
//        HashMap<String, Student> map = new HashMap<>();
//        List<String> sortedNames = new ArrayList<>();
//        for( Student student1 : students) {
//            map.put(student1.getName(), student1);
//            sortedNames.add(student1.getName());
//        }
//        Collections.sort(sortedNames);
//        System.out.println("Sorted based on names :");
//        System.out.println("--------------------------------------------------------------------------\n");
//        for(String key : sortedNames)
//            System.out.println(map.get(key).getName()+"\t\t"+map.get(key).getAge()+"\t\t"+map.get(key).getAddr()+"\t\t"+map.get(key).getRollNo()+"\t\t"+map.get(key).getCourses());
//        System.out.println("--------------------------------------------------------------------------\n");
//       --------------------------------------------------------------------------------------------------------------------------------------------------------
          return "Student added successfully";
    }

    public void delete()
    {
        System.out.println("Enter Roll no.");
        int rollNo = input.nextInt();
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
        int ch = input.nextInt();
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
