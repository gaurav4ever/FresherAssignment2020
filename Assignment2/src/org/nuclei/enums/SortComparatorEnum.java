package org.nuclei.enums;

import org.nuclei.model.Student;

import java.util.Comparator;

public enum SortComparatorEnum {

    SORT_BY_NAME {
        @Override
        public Comparator<Student> getComparator(final String choice) {

            Comparator<Student> comparator = null;
            if(this.ascendingLiteral.equalsIgnoreCase(choice)) {
                comparator = Comparator.comparing(Student::getFullName);
            }else if(this.descendingLiteral.equalsIgnoreCase(choice)){
                comparator = Comparator.comparing(Student::getFullName).reversed();
            }
            return comparator;
        }
    },
    SORT_BY_ROLL_NUMBER {
        @Override
        public Comparator<Student> getComparator(final String choice) {

            Comparator<Student> comparator = null;
            if(this.ascendingLiteral.equalsIgnoreCase(choice)) {
                comparator = Comparator.comparing(Student::getRollNo);
            }else if(this.descendingLiteral.equalsIgnoreCase(choice)){
                comparator = Comparator.comparing(Student::getRollNo).reversed();
            }
            return comparator;
        }
    },
    SORT_BY_AGE {
        @Override
        public Comparator<Student> getComparator(final String choice) {

            Comparator<Student> comparator = null;
            if(this.ascendingLiteral.equalsIgnoreCase(choice)) {
                comparator = Comparator.comparing(Student::getAge);
            }else if(this.descendingLiteral.equalsIgnoreCase(choice)){
                comparator = Comparator.comparing(Student::getAge).reversed();
            }
            return comparator;
        }
    },
    SORT_BY_ADDRESS{
        @Override
        public Comparator<Student> getComparator(String choice) {

            Comparator<Student> comparator = null;
            if(this.ascendingLiteral.equalsIgnoreCase(choice)) {
                comparator = Comparator.comparing(Student::getAddress);
            }else if(this.descendingLiteral.equalsIgnoreCase(choice)){
                comparator = Comparator.comparing(Student::getAddress).reversed();
            }
            return comparator;
        }
    },
    SORT_BY_ADDRESS_AND_ROLL_NUMBER{
        @Override
        public Comparator<Student> getComparator(String choice) {

            Comparator<Student> comparator = null;
            if(this.ascendingLiteral.equalsIgnoreCase(choice)){
                comparator = (student1, student2) -> {
                    if(student1.getFullName().equalsIgnoreCase(student2.getFullName())) {
                        return student1.getRollNo() - student2.getRollNo();
                    }
                    else {
                        return student1.getFullName().compareToIgnoreCase(student2.getFullName());
                    }
                };
            }else if(this.descendingLiteral.equalsIgnoreCase(choice)){
                comparator = (student1, student2) -> {
                    if(student1.getFullName().equalsIgnoreCase(student2.getFullName())) {
                        return student1.getRollNo() - student2.getRollNo();
                    }
                    else {
                        return student2.getFullName().compareToIgnoreCase(student1.getFullName());
                    }
                };
            }
            return comparator;
        }
    };

    public final String ascendingLiteral = "Ascending";
    public final String descendingLiteral = "Descending";

    public abstract Comparator<Student> getComparator(final String choice);
}
