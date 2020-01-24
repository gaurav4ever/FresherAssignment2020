package assignment2.src.com.company.comparator;

import assignment2.src.com.company.*;

import java.util.Comparator;

public class ComparatorByAgeDecend implements Comparator<Student> {
    public int compare( final Student student1, final Student student2  ){
        if( student1.getAge() < student2.getAge() ) {
            return 1;
        }
        else if( student1.getAge() > student2.getAge() ) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
