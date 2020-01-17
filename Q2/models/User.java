package assignment2.models;

import java.util.ArrayList;
import java.io.*;

public class User implements Serializable {
    public String name;
    public Integer age;
    public String rollno;
    public String address;
    public ArrayList<Character> courses;

    public User(String name, String address, String rollno, int age, ArrayList<Character> courses) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("name should not be null or empty");
        }
        if (address == null || name.isEmpty()) {
            throw new Exception("address should not be null or empty");
        }
        if (age <= 0) {
            throw new Exception("age should not be null or < 0");
        }
        if (rollno == null || rollno.isEmpty()) {
            throw new Exception("rollno should not be null or empty");
        }
        if (courses.size() < 4) {
            throw new Exception("atleast four courses should be slected");
        }
        this.name = name;
        this.address = address;
        this.rollno = rollno;
        this.age = age;
        this.courses = courses;
    }

    public String toString() {
        return this.name + "  " + this.rollno + "  " + this.age + "  " + this.address + "  " + this.courses;
    }
}