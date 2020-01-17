package com.company.main;

import com.company.main.FileOperations.SaveChanges;
import com.company.main.StudentOperations.DeleteStudentRecord;
import com.company.main.StudentOperations.DisplayStudentList;
import com.company.main.StudentOperations.InputStudentDetails;
import com.company.main.FileOperations.WriteToFile;
import static com.company.main.Main.scan;

//TODO change name (Driver)
public class UserInputs {
    public void readChoiceAndPerformAction(){
       while(true)
        {
            int choice = getUserChoice();
            switch (choice)
            {
                case 1:
                    new InputStudentDetails().start();
                    break;

                case 2:
                    new DisplayStudentList().displayStudentList();
                    break;

                case 3:
                    new DeleteStudentRecord().deleteStudentRecord();
                    break;

                case 4:
                    new WriteToFile().writeToFile();
                    break;

                case 5:
                    new SaveChanges().saveChanges();
                    return;

                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
    }
    public int getUserChoice(){
        System.out.println("1. Add User details.");
        System.out.println("2. Sort and Display user details");
        System.out.println("3. Delete user details by giving roll number");
        System.out.println("4. Save user details");
        System.out.println("5. Exit");
        System.out.println("Enter choice : ");
        return (scan.nextInt());
    }
}
