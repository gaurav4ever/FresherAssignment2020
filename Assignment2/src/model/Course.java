package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable{
   // private static final long serialVersionUID =1L;
    ArrayList<String> courses;
    public Course(ArrayList<String> courses) {
        this.courses = courses;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }
}
