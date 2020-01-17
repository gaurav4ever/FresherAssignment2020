package com.company.main.driver;

import com.company.main.file_operations.SaveChanges;
import com.company.main.student_operations.DeleteStudentRecord;
import com.company.main.student_operations.DisplayStudentList;
import com.company.main.student_operations.InputStudentDetails;
import com.company.main.file_operations.WriteToFile;
import static com.company.main.Main.scan;

public class ChoiceDriver {
    public void start(){
       while(true)
        {
            int choice = getUserChoice();
            switch (choice)
            {
                case 1:
                    new InputStudentDetails().start();
                    break;

                case 2:
                    new DisplayStudentList().start();
                    break;

                case 3:
                    new DeleteStudentRecord().start();
                    break;

                case 4:
                    new WriteToFile().start();
                    break;

                case 5:
                    new SaveChanges().start();
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
