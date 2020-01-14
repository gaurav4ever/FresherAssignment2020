package com.company.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.main.Main.graph;

public class Operations {
    Scanner scan = new Scanner(System.in);

    public void getParent()
    {
        System.out.println("Enter ID :");
        int id = scan.nextInt();
        if(!graph.containsKey(id)){
            System.out.println("Node with id : "+id+" does not exist");
        }
        List<Integer> parents = new ArrayList<>();
        for (Node node : graph.values())
            if(node.children.containsKey(id))
                parents.add(node.id);

        System.out.println("Parents of node with ID : "+id+ " is ");
        for(Integer i : parents)
            System.out.println(i.intValue());

    }

    public void getChildren()
    {
        System.out.println("Enter ID of parent whose children to be found :");
        int id = scan.nextInt();
        System.out.println("Children are : "+ graph.get(id).children.keySet());
    }

    public void addNode()
    {
        System.out.println("Enter ID : ");
        int id = scan.nextInt();
        for(Integer i : graph.keySet()){
            if(graph.containsKey(id)){
               System.out.println("ID "+id+" already exists!, re-enter ID :");
               id =scan.nextInt();
            }
        }
        System.out.println("Enter name : ");
        String name = scan.next();
        Node n = new Node(id,name);
        graph.put(id,n);
    }

    public void getAncestors(int id)
    {
        List<Integer> parents = new ArrayList<>();
        for (Node node : graph.values())
            if(node.children.containsKey(id))
                parents.add(node.id);

        System.out.println("  ");
        for(Integer i : parents)
            System.out.println(i.intValue());
        for(Integer i : parents)
            getAncestors(i);
    }

    public void getDescendants(int id)
    {
        for(Integer i : graph.get(id).children.keySet()){
            System.out.println(i);
            getDescendants(i);
        }
    }

    public void deleteDependency()
    {
        System.out.println("Enter parent ID and children ID whose dependency to be deleted : ");
        int id1 = scan.nextInt();
        int id2 = scan.nextInt();
        graph.get(id1).children.remove(id2);
    }

    public void deleteNode()
    {
        System.out.println("Enter ID of the node to be deleted");
        int id = scan.nextInt();
        graph.remove(id);
    }
    public void addData()
    {
        Node n1 = new Node(123,"GrandGrandfFather" );
        Node n2 = new Node(124,"GrandFather");
        Node n3 = new Node(125,"Father");
        Node n4 = new Node(126,"Mother");
        Node n5 = new Node(127,"GrandMother");
        Node n6 = new Node(128,"GrandGrandMother");
        Node n7 = new Node(129,"child");
        Node n8 = new Node(130,"GrandChild");
        Node n9 = new Node(131,"GrandGrandChild");

        graph.put(123,n1);
        graph.put(124,n2);
        graph.put(125,n3);
        graph.put(126,n4);
        graph.put(127,n5);
        graph.put(128,n6);
        graph.put(129,n7);
        graph.put(130,n8);
        graph.put(131,n9);

        addDependency(123,124);
        addDependency(124,125);
        addDependency(125,129);
        addDependency(126,129);
        addDependency(127,126);
        addDependency(128,127);
        addDependency(129,130);
        addDependency(130,131);
    }

    public void addDependency(int id1,int id2)
    {
        graph.get(id1).children.put(id2,graph.get(id2));
    }
}
