package com.company.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int ch=1;
        Details details = new Details();
        FileOperations file = new FileOperations();
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("1. Add User details.");
            System.out.println("2. Display user details");
            System.out.println("3. Delete user details by giving roll number");
            System.out.println("4. Save user details");
            System.out.println("5. Exit");
            System.out.println("Enter choice : ");
            ch = input.nextInt();
            switch (ch)
            {
                case 1:
                    details.input();
                    break;
                case 2:
                    details.display();
                    break;
                case 3:
                case 4:
                    file.writeToFile();
                    System.out.println("Details written to file");
                    file.readFromFile();
                    break;
                case 5:
                    return;
            }
        }

    }
}
