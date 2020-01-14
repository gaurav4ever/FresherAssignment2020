package com.company.main;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<Integer,Node> graph;

    public static void main(String[] args) {

        int ch,id1,id2;
        graph = new HashMap<Integer, Node>();
        Scanner scan = new Scanner(System.in);
        Operations op = new Operations();
        System.out.println("1. Get immediate parent of : (ID)");
        System.out.println("2. Get immediate child of : (ID)");
        System.out.println("3. Get ancestors of : (ID)");
        System.out.println("4. Get descendants of (ID)");
        System.out.println("5. Delete dependency between parent node(ID) and child node(ID) : ");
        System.out.println("6. Delete a node and its related dependencies (ID) : ");
        System.out.println("7. Add new dependency between parent node(ID) and child node(ID) : ");
        System.out.println("8. Add new node : ");
        System.out.println("9. Exit");

        op.addData();
        while(true)
        {
            System.out.println("Enter choice : ");
            ch = scan.nextInt();
            switch (ch)
            {
                case 1:
                    op.getParent();
                    break;
                case 2:
                    op.getChildren();
                    break;
                case 3:
                    System.out.println("Enter ID of the node whose ancestors to be found : ");
                    int id = scan.nextInt();
                    System.out.println("Ancestors are : ");
                    op.getAncestors(id);
                    break;
                case 4:
                    System.out.println("Enter ID of the node whose descendants to be found : ");
                    int id3 = scan.nextInt();
                    System.out.println("Descendants are : ");
                    op.getDescendants(id3);
                    break;
                case 5:
                    op.deleteDependency();
                    break;
                case 6:
                    op.deleteNode();
                    break;
                case 7:
                    System.out.println("Enter Parent ID and Children ID :");
                    id1 = scan.nextInt();
                    id2 = scan.nextInt();
                    op.addDependency(id1,id2);
                    break;
                case 8:
                    op.addNode();
                    break;
                case 9:
                    return;
            }
        }
    }
}
