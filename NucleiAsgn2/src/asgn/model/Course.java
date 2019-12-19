package asgn.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {

  ArrayList<String> courses = new ArrayList<>();

  public Course(ArrayList<String> courses) {
    this.courses = courses;
  }

  public ArrayList<String> getCourses() {
    return courses;
  }
}
