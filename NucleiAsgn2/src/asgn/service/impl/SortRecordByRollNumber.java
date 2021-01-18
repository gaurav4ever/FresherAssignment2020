package asgn.service.impl;

import asgn.model.Student;
import asgn.service.ServiceSortRecordByChoice;

import java.util.Comparator;
import java.util.List;

public class SortRecordByRollNumber implements ServiceSortRecordByChoice {

  @Override
  public Comparator sortStudentRecord(List<Student> studentList) {
    Comparator<Student> comparator = Comparator.comparing(Student::getRollNumber);
    return comparator;
  }
}
