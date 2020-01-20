package Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class functionality {
    static Scanner sc=new Scanner(System.in);
     List<student> students= new ArrayList<>();
    public String addDetails(){
        student s=new student();
        System.out.println("Enter your full name");
        String Name=sc.next();
        if(Name==null){
            System.out.println("Name cannot be empty. Reenter the name.");
            Name=sc.nextLine();
        }

        System.out.println("Enter your age.");
        String check_age=sc.next();
        try{
            Integer.parseInt(check_age);
        }catch (NumberFormatException e){
            System.out.println("Age must be an positive integer. Reenter age.");
            check_age=sc.next();
        }
        int age=Integer.parseInt(check_age);

        System.out.println("Enter your address");
        String address=sc.next();

        System.out.println("Enter your RollNumber.");
        String check_roll=sc.next();
        try{
            Integer.parseInt(check_roll);
        }catch (NumberFormatException e){
            System.out.println("RollNumber must be an positive integer. Reenter RoolNumber.");
            check_roll=sc.next();
        }
        int rollNumber=Integer.parseInt(check_roll);

        System.out.println("Enter the number of interested courses");
        int mandatory_courses=sc.nextInt();
        if(mandatory_courses<4){
            System.out.println("Atleast four courses are mandatory. Reenter the number of courses.");
            mandatory_courses=sc.nextInt();
        }
        System.out.println("Available courses are : A,B,C,D,E,F");
        String []courseList=new String[mandatory_courses];
        for(int i=0;i<mandatory_courses;i++){
            System.out.print("Enter course" + (i+1));
            courseList[i]=sc.next();
        }
        String courses= Arrays.toString(courseList);
        s.create(Name,address,courses,age,rollNumber);
        students.add(s);
        return "Successfully added";

    }
    public void displayDetails(){
        System.out.println("Select the type in which you want to display the details:");
        System.out.println("1. Sort based on Name");
        System.out.println("2. Sort based on RollNumber");
        System.out.println("3. Sort based on Age");
        System.out.println("4. Sort based on Address");
        int choice= sc.nextInt();
        storing s=new storing();
        switch(choice){
            case 1:
                Collections.sort(students,s.StuName);
                break;
            case 2:
                Collections.sort(students,s.StuRollno);
                break;
            case 3:
                Collections.sort(students,s.StuAge);
                break;
            case 4:
                Collections.sort(students,s.StuAddress);
                break;
            default:
                System.out.println("Invalid option");
                break;

        }
        System.out.println("Student details in sorted order :");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Name \t\t Roll No. \t\t Age \t\t Address  \t\t Courses");
        System.out.println("-----------------------------------------------------------------------------");
        for( student st: students)
            System.out.println(st.getName() + "\t\t" + st.getRollNo() + "\t\t" + st.getAge() + "\t\t\t" + st.getAddress() + "\t\t\t" + st.getCourses() );
        System.out.println("-----------------------------------------------------------------------------");
    }

    public void deleteDetails(){
        System.out.println("Enter Roll no.");
        int rollNo = sc.nextInt();
        int f=0;
        for(student st: students)
        {
            if(st.getRollNo()==rollNo)
            {
                f=1;
                students.remove(st);
                System.out.println("Student detail with roll no. "+rollNo+" deleted");
            }
        }
        if(f==0)
            System.out.println("Roll No. does not exist");
    }

    public void saveDetails() {
        try {
            FileOutputStream f = new FileOutputStream("sample.ser");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(students);
            System.out.println("Success file");
            o.close();
            f.close();
        }
        catch (Exception e){
            System.out.println("Student details couldn't write to file");
        }
    }

    public void readFromFile(){
        try{
            FileInputStream fi = new FileInputStream("sample.ser");
            ObjectInputStream oi = new ObjectInputStream(fi);
            students = (ArrayList<student>) oi.readObject();
            fi.close();
            oi.close();
        }
        catch (Exception e){
            System.out.println("Student details couldn't read from file");
        }
    }

    public boolean end(){
        System.out.println("Save changes(y/n)");
        String option=sc.next();
        if(option.equals("y"))
            saveDetails();
        return false;
    }
}
