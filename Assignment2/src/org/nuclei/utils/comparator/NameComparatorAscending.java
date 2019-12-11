package org.nuclei.utils.comparator;

import org.nuclei.model.Student;

import java.util.Comparator;

public class NameComparatorAscending implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getFullName().compareToIgnoreCase(student2.getFullName());
    }

}
