package com.company.Comparator;

import com.company.Student;

import java.util.Comparator;

public class comparatorByAgeAssend implements Comparator<Student> {
    public int compare(Student s1, Student s2  ){
        if(s1.getAge() > s2.getAge())
            return 1;
        else if(s1.getAge() < s2.getAge())
            return -1;
        else
            return 0;
    }
}
