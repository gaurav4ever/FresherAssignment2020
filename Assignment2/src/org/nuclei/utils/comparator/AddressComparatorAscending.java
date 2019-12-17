package org.nuclei.utils.comparator;

import org.nuclei.model.Student;

import java.util.Comparator;

public class AddressComparatorAscending implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getAddress().compareToIgnoreCase(student2.getAddress());
    }

}
