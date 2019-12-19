package asgn.model;

import java.io.Serializable;

public class Student implements Serializable {

  int rollNumber;
  String name;
  int age;
  String address;
  Course course;

  public Student(int rollNumber, String name, int age, String address, Course course) {
    this.rollNumber = rollNumber;
    this.name = name;
    this.age = age;
    this.address = address;
    this.course = course;
  }

  public int getRollNumber() {
    return rollNumber;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  public Course getCourse() {
    return course;
  }
}