package asgn.service;

import asgn.model.Student;

import java.util.Comparator;
import java.util.List;

public interface ServiceSortRecordByChoice {
    Comparator sortStudentRecord(List<Student> studentList);
}