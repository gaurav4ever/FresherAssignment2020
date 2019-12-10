package asgn.service;

import asgn.model.Student;

import java.util.Comparator;
import java.util.List;

public class SortRecordByRollNumber implements ServiceSortRecordByChoice {
    @Override
    public Comparator sortStudentRecord(List<Student> studentList) {
        Comparator<Student> comparator = Comparator.comparing(Student::getRollNumber);
        return comparator;
    }
}
