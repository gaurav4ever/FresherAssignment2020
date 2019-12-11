package org.nuclei.DAO.implementation;

import org.nuclei.DAO.StudentDAO;
import org.nuclei.model.Student;
import org.nuclei.utils.DeserializeData;
import org.nuclei.utils.SerializeData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private List<Student> students = new ArrayList<Student>();

    private String fileName = null;

    public StudentDAOImpl(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void addUser(Student student) {

            students.add(student);
    }

    @Override
    public void deleteUser(Student student) {
        students.remove(student);
    }

    @Override
    public Student getUserByRollNo(int rollNo) {
        for(Student student : students) {
            if(student.getRollNo()==rollNo) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllUsers() {
        return students;
    }

    @Override
    public void serializeUser() throws IOException {
        //TODO: Serialize object
        SerializeData<Student> handler = new SerializeData<Student>();
        handler.serializeData(students, fileName);
    }

    @Override
    public void deserializeUser() throws IOException, ClassNotFoundException{
        //TODO: Deserialize object
        DeserializeData<Student> handler = new DeserializeData<Student>();
        List<Student> tempList = new ArrayList<Student>();
        tempList = handler.deserializeData(fileName);
        students = tempList;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
