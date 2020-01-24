package com.company.comparator;

import com.company.Student;
import java.util.Comparator;

public class ComparatorByName implements Comparator<Student> {
    public int compare( final Student student1, final Student student2  ){

        if(student1.getName().equals(student2.getName())){
            if( student1.getRollNumber()>student2.getRollNumber() ) {
                return 1;
            }
            else if( student1.getRollNumber()<student2.getRollNumber() ) {
                return -1;
            }
            else {
                return 0;
            }
        }
        return student1.getName().compareTo(student2.getName());

    }
}
