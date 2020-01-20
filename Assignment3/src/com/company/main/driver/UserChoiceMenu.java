package com.company.main.driver;

import static com.company.main.Main.scan;

public class UserChoiceMenu {
    public int getChoice(){
        System.out.println("\n\n Menu : ");
        System.out.println("1. Get immediate parent of : (ID)");
        System.out.println("2. Get immediate child of : (ID)");
        System.out.println("3. Get ancestors of : (ID)");
        System.out.println("4. Get descendants of (ID)");
        System.out.println("5. Delete dependency between parent node(ID) and child node(ID) : ");
        System.out.println("6. Delete a node and its related dependencies (ID) : ");
        System.out.println("7. Add new dependency between parent node(ID) and child node(ID) : ");
        System.out.println("8. Add new node : ");
        System.out.println("9. Exit");
        System.out.println("Enter choice : ");
        return (scan.nextInt());
    }
}
