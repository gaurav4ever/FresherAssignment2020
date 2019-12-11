package org.nuclei.utils.comparator;

import org.nuclei.model.Student;

import java.util.Comparator;

public class DefaultComparator implements Comparator<Student> {

     @Override
    public int compare(Student student1, Student student2) {
        if(student1.getFullName().equalsIgnoreCase(student2.getFullName())) {
            return student1.getRollNo() - student2.getRollNo();
        }
        else return student1.getFullName().compareToIgnoreCase(student2.getFullName());
    }

}
