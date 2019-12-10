package org.nuclei.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String FullName;
    private int Age;
    private String Address;
    private int RollNo;
    private List<String> Courses;

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getRollNo() {
        return RollNo;
    }

    public void setRollNo(int rollNo) {
        RollNo = rollNo;
    }

    public List<String> getCourses() {
        return Courses;
    }

    public void setCourses(List<String> courses) {
        Courses = courses;
    }

    public String printCourses() {
        String s = "[ Courses: ";
        for(String Course : Courses) {
            s = s + Course + " ";
        }
        s = s + ']';
        return s;
    }

    @Override
    public String toString() {
        return String.format("%1$-15s %2$-15d %3$-15d %4$-20s %5$-10s", FullName, RollNo, Age , Address, printCourses() );
    }

}
