package org.nuclei.utils.comparator;

import org.nuclei.model.Student;

import java.util.Comparator;

public class AgeComparatorDescending implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student2.getAge() - student1.getAge();
    }

}
