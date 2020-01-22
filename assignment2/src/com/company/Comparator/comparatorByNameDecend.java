package assignment2.src.com.company.Comparator;

import assignment2.src.com.company.Student;

import java.util.Comparator;

public class comparatorByNameDecend implements Comparator<Student> {
    public int compare(Student s1, Student s2  ){

        if(s1.getName().equals(s2.getName()))
            return 0;
        else
            return s2.getName().compareTo(s1.getName());

    }
}
