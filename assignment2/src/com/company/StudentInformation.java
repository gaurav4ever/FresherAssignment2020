package com.company;

import com.company.comparator.*;

import java.io.*;
import java.util.*;

public class StudentInformation implements Serializable {
    private static String fileName = "myObjects.ser";
    private static List<Student> studentList = new ArrayList<>();
    private InputChecker inputChecker = new InputChecker();
   
    private Scanner scanner = new Scanner(System.in);
    private String order;
    private String  parameter;
    private  final int courseSize = 4;

    public void readDetails(){
        final Student stud = new Student();
        char tempcCourse[] = new char[courseSize];
        do {
            System.out.println("Name: ");
            stud.setName(scanner.nextLine());
        } while (inputChecker.checkName(stud.getName()));

        String tempInput;
        int index = 0;
        do {
            System.out.println("Age: ");
            tempInput = scanner.nextLine();
        } while (inputChecker.checkAge(tempInput));
        stud.setAge(Integer.parseInt(tempInput));

        do {
            System.out.println("Address: ");
            stud.setAddress(scanner.nextLine());
        } while (inputChecker.checkAddress(stud.getAddress()));

        do {
            System.out.println("Roll Number: ");
            tempInput = scanner.nextLine();
        } while (inputChecker.checkRollNumber(tempInput));
        stud.setRollNumber(Integer.parseInt(tempInput));
        while(index<4)
        {
            do{
                System.out.println("Enter Course" + index +": ");
                tempInput = scanner.nextLine();
            }while( inputChecker.checkCourses(tempInput) );
            tempcCourse[index] = tempInput.charAt(0);
            index++;
        }
        stud.setCourese(tempcCourse);

        studentList.add(stud);
        Collections.sort(studentList, new ComparatorByName());
    }

    public void showDetails(){
        System.out.println("The Data to be sorted in assending or decending order");
        order = scanner.next();
        order.toLowerCase();

        //Sorting by assending order method call
        if( order.compareTo("assending") == 0 ) {
            System.out.println("Parameter(Name, Roll, age, address");
            parameter = scanner.next();
            parameter.toLowerCase();
            switch (parameter) {
                case "name":
                    Collections.sort(studentList, new ComparatorByNameAssend());
                    break;
                case "roll":
                    Collections.sort(studentList, new ComparatorByRollAssend());
                    break;
                case "age":
                    Collections.sort(studentList, new ComparatorByAgeAssend());
                    break;
                case "address":
                    Collections.sort(studentList, new ComparatorByAddressAssend());
                    break;
                default: System.out.println("Wrong Input");
            }
        }

    //Sorting with decending order method call here
        else if(order.compareTo("decending") == 0){
            System.out.println("Parameter(Name, Roll, age, address");
            parameter = scanner.next();
            parameter.toLowerCase();
            switch ( parameter ){
                case "name" : Collections.sort(studentList, new ComparatorByNameDecend());
                    break;
                case "roll": Collections.sort(studentList, new ComparatorByRollDecend());
                    break;
                case "age": Collections.sort(studentList, new ComparatorByAgeDecend());
                    break;
                case "address": Collections.sort(studentList, new ComparatorByAddressDecend());
                    break;
                default: System.out.println( "Wrong Input" );
            }

        }
     // Displaying the Result
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\t\t\tNAME \t\t ADDRESS \t\t   AGE \t\t ROLL NUMBER \t\t COURSES");
        System.out.println("-----------------------------------------------------------------------------------------");
        for( final Student std: studentList ){
            System.out.format("%16s%20s%10d%10d%24s\n",std.getName(), std.getAddress(), std.getAge(), std.getRollNumber(), std.getCourese() );

        }
    }

    public void deleteStudentDetail(){
        int roll;
        Boolean flag = Boolean.FALSE;
        System.out.println("Enter Roll Number");
            try{
                do{
                    roll = Integer.parseInt(scanner.next());
                    for( final Student std: studentList ) {
                        if ( std.getRollNumber() == roll ) {
                            flag = Boolean.TRUE;
                            studentList.remove(std);
                            System.out.println("Removed Successfully");
                            break;
                        }
                    }
                    if(!flag) {
                        System.out.println("Roll Number Not there, Please Enter a Valid Roll");
                    }
                }while (!flag);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
            }
    }

    public void saveData(){
            try {
                final FileOutputStream fileOut = new FileOutputStream(new File(fileName));
                final ObjectOutputStream outStream = new ObjectOutputStream(fileOut);

                outStream.writeObject(studentList);

                outStream.close();
                fileOut.close();

                System.out.println("Details saved to file");
            } catch (IOException e) {
                System.out.println("Saving file IOE error");
            }
    }

    public void retriveData(){
        try
        {
            final FileInputStream fis = new FileInputStream("myObjects.ser");
            final ObjectInputStream ois = new ObjectInputStream(fis);

            studentList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            System.out.println("Input Output Exception");
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            return;
        }
    }

}
