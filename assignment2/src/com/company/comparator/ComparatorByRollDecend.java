package com.company.comparator;

import com.company.Student;

import java.util.Comparator;

public class ComparatorByRollDecend implements Comparator<Student> {
    public int compare( final Student student1, final Student student2  ){
        if( student1.getRollNumber() < student2.getRollNumber() ) {
            return 1;
        }
        else if( student1.getRollNumber() > student2.getRollNumber() ) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
