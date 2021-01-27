package sortenum;

import model.Student;

import java.util.Comparator;

public enum sortChoice {
    SORT_BY_ROLL_NUMBER {
        @Override
        public Comparator<Student> getComparator() {
            return Comparator.comparing(Student::getRollNumber);
        }
    },
    SORT_BY_NAME {
        @Override
        public Comparator<Student> getComparator() {
            return Comparator.comparing(Student::getName);
        }
    },
    SORT_BY_AGE{
            @Override
            public Comparator<Student> getComparator() {
                return  Comparator.comparing(Student::getAge);
            }
    },
    SORT_BY_ADDRESS{
    @Override
    public Comparator<Student> getComparator() {
            return  Comparator.comparing(Student::getAddress);
        }
    };

    public abstract Comparator<Student> getComparator();

}
