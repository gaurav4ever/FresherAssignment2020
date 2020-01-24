package assignment2.src.com.company.comparator;

import assignment2.src.com.company.*;

import java.util.Comparator;

public class ComparatorByNameAssend implements Comparator<Student> {
    public int compare( final Student student1, final Student student2  ){

        if( student1.getName().equals(student2.getName()) ) {
            return 0;
        }
        else {
            return student1.getName().compareTo(student2.getName());
        }

    }
}
