package model;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
   private static final long serialVersionUID =1L;
    private List<String> courses;
    public Course(List<String> courses) {
        this.courses = courses;
    }
    public List<String> getCourses() {
        return courses;
    }
}
