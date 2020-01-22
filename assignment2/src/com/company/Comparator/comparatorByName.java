package assignment2.src.com.company.Comparator;

import assignment2.src.com.company.Student;

import javax.swing.*;
import java.util.Comparator;

public class comparatorByName implements Comparator<Student> {
    public int compare(Student s1, Student s2  ){

        if(s1.getName().equals(s2.getName())){
            if(s1.getRollNumber()>s2.getRollNumber())
                return 1;
            else if(s1.getRollNumber()<s2.getRollNumber()){
                return -1;
            }
            else
                return 0;
        }
        return s1.getName().compareTo(s2.getName());

    }
}
