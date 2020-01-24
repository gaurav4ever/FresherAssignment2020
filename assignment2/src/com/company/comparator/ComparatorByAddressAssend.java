package com.company.comparator;
// used to sort theStudent details on address in ascending order

import com.company.Student;

import java.util.Comparator;

public class ComparatorByAddressAssend implements Comparator<Student> {
    public int compare(final Student student1, final Student student2) {
        if (student1.getAddress().equals(student2.getAddress())) {
            return 0;
        } else {
            return student1.getAddress().compareTo(student2.getAddress());
        }
    }
}
