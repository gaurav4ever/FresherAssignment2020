package com.company.main;

import java.util.Comparator;
import java.io.Serializable;

public class Student implements Serializable {
    public String name, address, courses;
    public int age, rollNo;

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setCourses(String courses){
        this.courses = courses;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCourses()
    {
        return courses;
    }

    public int getAge()
    {
        return age;
    }

    public int getRollNo()
    {
        return rollNo;
    }

    @Override
    public String toString(){
        return (name +"\t\t"+ age +"\t\t"+ address + "\t\t" + rollNo + "\t\t" + courses +" ");
    }

    public static Comparator<Student> stuNameComparator = (s1, s2) -> {
        String studentName1 = s1.getName().toUpperCase();
        String studentName2 = s2.getName().toUpperCase();

        if(studentName1.equals(studentName2))
        {
            int StudentRoll1 = s1.getRollNo();
            int StudentRoll2 = s2.getRollNo();

            return (StudentRoll1 -StudentRoll2);
        }
        return studentName1.compareTo(studentName2);
    };

    public static Comparator<Student> stuRollComparator = (s1, s2) -> {
        int StudentRoll1 = s1.getRollNo();
        int StudentRoll2 = s2.getRollNo();

        return StudentRoll1-StudentRoll2;
    };

    public static Comparator<Student> stuAgeComparator = (s1, s2) -> {
        int StudentAge1 = s1.getAge();
        int StudentAge2 = s2.getAge();

        return StudentAge1-StudentAge2;
    };

    public static Comparator<Student> stuAddrComparator = (s1, s2) -> {
        String StudentAddr1 = s1.getAddress().toUpperCase();
        String StudentAddr2 = s2.getAddress().toUpperCase();

        return StudentAddr1.compareTo(StudentAddr2);
    };
}
