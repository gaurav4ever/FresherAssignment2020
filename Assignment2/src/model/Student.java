package model;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID =10L;
    private int rollNumber;
    private String name;
    private int age;
    private String address;
    private Course course;

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student(int rollNumber, String name, int age, String address, Course course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.address = address;
        this.course = course;
    }
}