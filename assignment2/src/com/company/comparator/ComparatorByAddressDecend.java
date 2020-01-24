package com.company.comparator;

import com.company.Student;

import java.util.Comparator;

public class ComparatorByAddressDecend implements Comparator<Student> {
    public int compare( final Student student1, final Student student2  ){

        if( student1.getAddress().equals(student2.getAddress()) ) {
            return 0;
        }
        else {
            return student2.getAddress().compareTo(student1.getAddress());
        }

    }
}
