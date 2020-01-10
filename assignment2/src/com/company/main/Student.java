package com.company.main;
import java.util.List;
import java.io.Serializable;

public class Student implements Serializable{
    String name, addr, courses;
    int age, rollNo;

    public void Assign(String name, String addr,String courses, int age, int rollNo){
        this.name = name;
        this.addr = addr;
        this.courses = courses;
        this.age = age;
        this.rollNo = rollNo;
    }
    public String getName()
    {
        return name;
    }

    public String getAddr()
    {
        return addr;
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
}
