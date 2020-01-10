package com.company;

public class Student implements Comparable {
    public String name;
    public int age, rollno;

    public Student(String name, int age, int rollno)
    {
        this.name=name;
        this.age=age;
        this.rollno=rollno;
    }
    @Override
    public int compareTo(Student comparestu) {
        int compareage=((Student)comparestu).age;
        /* For Ascending order*/
        return this.age-compareage;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
