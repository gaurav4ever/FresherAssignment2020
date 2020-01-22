package assignment2.src.com.company;

import assignment2.src.com.company.Comparator.*;

import java.io.*;
import java.util.*;

public class StudentInformation implements Serializable {
    static String fileName = "myObjects.ser";
    private static List<Student> studentList = new ArrayList<>();
    InputChecker ic = new InputChecker();
   
    Scanner br = new Scanner(System.in);
    private String order, parameter;

    public void readDetails() throws IOException {
        Student stud = new Student();
        do {
            System.out.println("Name: ");
            stud.setName(br.nextLine());
        } while (ic.checkName(stud.getName()));

        String x;
        int index = 0;
        do {
            System.out.println("Age: ");
            x = br.nextLine();
        } while (ic.checkAge(x));
        stud.setAge(Integer.parseInt(x));

        do {
            System.out.println("Address: ");
            stud.setAddress(br.nextLine());
        } while (ic.checkAddress(stud.getAddress()));

        do {
            System.out.println("Roll Number: ");
            x = br.nextLine();
        } while (ic.checkRollNumber(x));
        stud.setRollNumber(Integer.parseInt(x));
        while(index<4)
        {
            do{
                System.out.println("Enter Course" + index +": ");
                x = br.nextLine();
            }while(ic.checkCourses(x));
            //System.out.println(x);
            stud.setCourese(index++,x.charAt(0));
        }

        studentList.add(stud);
        Collections.sort(studentList, new comparatorByName());
    }

    public void showDetails() throws IOException {
        System.out.println("The Data to be sorted in assending or decending order");
        order = br.next().toLowerCase();
    //Sorting for Assending order
        if(order.compareTo("assending") == 0) {
            System.out.println("Parameter(Name, Roll, age, address");
            parameter = br.next().toLowerCase();
            switch (parameter) {
                case "name":
                    Collections.sort(studentList, new comparatorByNameAssend());
                    break;
                case "roll":
                    Collections.sort(studentList, new comparatorByRollAssend());
                    break;
                case "age":
                    Collections.sort(studentList, new comparatorByAgeAssend());
                    break;
                case "address":
                    Collections.sort(studentList, new comparatorByAddressAssend());
                    break;
            }
        }
    //Sorting for Decending Order
        else if(order.compareTo("decending") == 0){
            System.out.println("Parameter(Name, Roll, age, address");
            parameter = br.next().toLowerCase();
            switch (parameter){
                case "name" : Collections.sort(studentList, new comparatorByNameDecend());
                    break;
                case "roll": Collections.sort(studentList, new comparatorByRollDecend());
                    break;
                case "age": Collections.sort(studentList, new comparatorByAgeDecend());
                    break;
                case "address": Collections.sort(studentList, new comparatorByAddressDecend());
                    break;
            }

        }
     // Displaying the Result
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\t\t\tNAME \t\t ADDRESS \t\t   AGE \t\t ROLL NUMBER \t\t COURSES");
        System.out.println("-----------------------------------------------------------------------------------------");
        for(Student std: studentList){
            //System.out.println(std.getName() + "\t  " + std.getAddress() + "\t      " + std.getAge() + "\t\t" + std.getRollNumber() + "\t\t" +std.getCourese());
            System.out.format("%16s%20s%10d%10d%24s\n",std.getName(), std.getAddress(), std.getAge(), std.getRollNumber(), std.getCourese() );

        }
    }

    public void deleteStudentDetail(){
        int roll;
        Boolean flag = Boolean.FALSE;
        System.out.println("Enter Roll Number");
            try{
                do{
                    roll = Integer.parseInt(br.next());
                    for(Student std: studentList) {
                        if (std.getRollNumber() == roll) {
                            flag = Boolean.TRUE;
                            studentList.remove(std);
                            System.out.println("Removed Successfully");
                            break;
                        }
                    }
                    if(!flag)
                        System.out.println("Roll Number Not there, Please Enter a Valid Roll");
                }while (!flag);

            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
            }
    }

    public void saveData(){
            try {
                FileOutputStream f = new FileOutputStream(new File(fileName));
                ObjectOutputStream o = new ObjectOutputStream(f);

                o.writeObject(studentList);

                o.close();
                f.close();

                System.out.println("Details saved to file");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void retriveData(){
        try
        {
            FileInputStream fis = new FileInputStream("myObjects.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            studentList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

}
