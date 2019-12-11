package org.nuclei.DAO;

import org.nuclei.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentDAO {

    String fileName = null;
    
    void addUser(Student student);
    void deleteUser(Student student);
    Student getUserByRollNo(int rollNo);
    List<Student> getAllUsers();
    void serializeUser() throws IOException;
    void deserializeUser() throws IOException, ClassNotFoundException;

}
