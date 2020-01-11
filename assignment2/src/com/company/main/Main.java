package com.company.main;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int ch=1;
        Details details = new Details();
        FileOperations file = new FileOperations();
        Scanner input = new Scanner(System.in);
        file.readFromFile();
        while(true)
        {
            System.out.println("1. Add User details.");
            System.out.println("2. Sort and Display user details");
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
                    details.delete();
                    break;
                case 4:
                    file.writeToFile();
                    System.out.println("Details saved to file");
                    break;
                case 5:
                    return;
            }
        }
    }


    /*public void sortBasedOnName(List<Student> students) {
        HashMap<String, Student> map = new HashMap<>();
        List<String> sortedNames = new ArrayList<>();
        for( Student student : students) {
            map.put(student.getName(), student);
            sortedNames.add(student.getName());
        }
        Collections.sort(sortedNames);
        for(String key : sortedNames)
            System.out.println(map.get(key).getName()+" : "+map.get(key).getAddr());
    }*/


}
