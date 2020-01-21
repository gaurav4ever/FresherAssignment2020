package com.company.Comparator;

import com.company.Student;

import java.util.Comparator;

public class comparatorByAddressAssend implements Comparator<Student> {
    public int compare(Student s1, Student s2  ){

        if(s1.getAddress().equals(s2.getAddress()))
            return 0;
        else
            return s1.getAddress().compareTo(s2.getAddress());

    }
}
