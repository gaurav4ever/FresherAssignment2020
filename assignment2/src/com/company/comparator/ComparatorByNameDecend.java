package com.company.comparator;

import com.company.Student;

import java.util.Comparator;

public class ComparatorByNameDecend implements Comparator<Student> {
    public int compare( final Student student1, final Student student2  ){

        if( student1.getName().equals(student2.getName()) ) {
            return 0;
        }
        else {
            return student2.getName().compareTo(student1.getName());
        }

    }
}
