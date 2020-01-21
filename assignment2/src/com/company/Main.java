package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        Boolean check = Boolean.TRUE;
        StudentInformation sir = new StudentInformation();
        sir.retriveData();

        while(check)
        try {
            System.out.println(("Enter 1 for Add Student Details, 2 for Display User Details, 3 for Delete User Details, 4 for Save User Details, 5 for Exit"));
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1: sir.readDetails();
                    break;
                case 2:
                    sir.showDetails();
                    break;
                case 3:sir.deleteStudentDetail();
                    break;
                case 4: sir.saveData();
                    break;
                case 5:
                    System.out.println("Do you want to save change? y/n");
                    char changeSave = (char) br.read();
                    if(changeSave == 'y' || changeSave == 'Y')
                        sir.saveData();
                    check = Boolean.FALSE;
                    break;
                default: System.out.println("Out of Range, please Input B/w 1-5");
            }

        } catch (NumberFormatException e) {
            System.out.println("Value entered is not Integer");
        }
    }

}
