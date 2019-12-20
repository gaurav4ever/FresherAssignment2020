package org.nuclei.bo;

import org.nuclei.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBO {

    private List<Student> students = new ArrayList<>();

    private String fileName;

    public StudentBO(final String fileName){
        this.fileName = fileName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
