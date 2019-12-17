import model.Course;
import model.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import util.utility;
import util.fileReadWriteUtil;
public class Main {
    private static Student student;

    public static void main(String[] args)
{
    //String studentRecFileName = fileReadWriteUtil.getFile(); // extract and read student file from memory
    //List<Student> studentRecordList = fileReadWriteUtil.readFile("studentData.txt");

    int choice = utility.getInputItemChoice(); // menu for selecting options
    utility.performAction(choice); // perform task according to the option chosen
}
}