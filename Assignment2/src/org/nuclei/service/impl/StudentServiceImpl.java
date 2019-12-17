package org.nuclei.service.impl;

import org.nuclei.dao.impl.StudentDAOImpl;
import org.nuclei.exception.UserAlreadyExistsException;
import org.nuclei.model.Student;
import org.nuclei.service.StudentService;
import org.nuclei.utils.comparator.*;

import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    final String fileLocation = "src/org/nuclei/resource/students";
    StudentDAOImpl userDAO = new StudentDAOImpl(this.fileLocation);

    @Override
    public void addUser(Student student) throws UserAlreadyExistsException {

        Student tempStudent = null;
        tempStudent = userDAO.getUserByRollNo(student.getRollNo());

        if (tempStudent != null) {
            throw new UserAlreadyExistsException("User already exists with given Roll number");
        } else {
            userDAO.addUser(student);
        }
        userDAO.getAllUsers().sort(new DefaultComparator());
    }

    @Override
    public void deleteUser(int rollNo) {
        Student student = null;
        student = userDAO.getUserByRollNo(rollNo);
        if(student != null){
            userDAO.deleteUser(student);
        }else{
            //TODO: Change if/else to exception based system
            System.out.println("User not found");
        }
    }

    @Override
    public List<Student> getUsers() {
        return userDAO.getAllUsers();

    }

    @Override
    public List<Student> getSortedUsers(int choice, char order) {

        List<Student> tempStudentList = getUsers();
        switch (choice) {
            case 1:
                if (order == 'a') {
                    tempStudentList.sort(new NameComparatorAscending());
                } else
                    tempStudentList.sort(new NameComparatorDescending());
                break;
            case 2:
                if (order == 'a') {
                    tempStudentList.sort(new RollNoComparatorAscending());
                } else
                    tempStudentList.sort(new RollNoComparatorDescending());
                break;
            case 3:
                if (order == 'a') {
                    tempStudentList.sort(new AgeComparatorAscending());
                } else
                    tempStudentList.sort(new AgeComparatorDescending());
                break;
            case 4:
                if (order == 'a') {
                    tempStudentList.sort(new AddressComparatorAscending());
                } else
                    tempStudentList.sort(new AddressComparatorDescending());
                break;
            default:
                System.out.println("Invalid choice");
        }
        return tempStudentList;
    }

    @Override
    public void flushIntoDisk() throws IOException {

        userDAO.serializeUser();
    }

    @Override
    public void fetchFromDisk() throws IOException, ClassNotFoundException {
        //TODO: Fix this method
        userDAO.deserializeUser();
    }

}
