package assignment2.src.com.company.Comparator;

import assignment2.src.com.company.Student;

import java.util.Comparator;

public class comparatorByAddressDecend implements Comparator<Student> {
    public int compare(Student s1, Student s2  ){

        if(s1.getAddress().equals(s2.getAddress()))
            return 0;
        else
            return s2.getAddress().compareTo(s1.getAddress());

    }
}
