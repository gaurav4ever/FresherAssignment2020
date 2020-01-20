package com.company.main.graph;

import com.company.main.model.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GraphOperation {
    Scanner scan = new Scanner(System.in);

    public void printParent(HashMap<Integer, Node> graph)
    {
        System.out.println("Enter ID :");
        int nodeId = scan.nextInt();
        if(!graph.containsKey(nodeId)){
            System.out.println("Node with nodeId : "+nodeId+" does not exist");
        }
        List<Integer> parents = new ArrayList<>();
        for (Node node : graph.values())
            if(node.children.containsKey(nodeId))
                parents.add(node.nodeId);

        System.out.println("Parents of node with ID : "+nodeId+ " is ");
        parents.forEach(parent -> System.out.println(parent.intValue()));
    }

    public void printChildren(HashMap<Integer, Node> graph)
    {
        System.out.println("Enter ID of parent whose children to be found :");
        int nodeId = scan.nextInt();
        System.out.println("Children are : "+ graph.get(nodeId).children.keySet());
    }

    public void addNode(HashMap<Integer, Node> graph)
    {
        System.out.println("Enter ID of new node: ");
        int nodeId = scan.nextInt();
        while(graph.containsKey(nodeId)){
            System.out.println("ID "+nodeId+" already exists!, re-enter ID :");
            nodeId =scan.nextInt();
        }
        System.out.println("Enter name : ");
        String name = scan.next();
        // TODO Need clarification when to use final
        final Node n = new Node(nodeId,name);
        graph.put(nodeId,n);
    }

    public List<Integer> getAncestors(int nodeId, HashMap<Integer, Node> graph)
    {
        List<Integer> parents = new ArrayList<>();
        for (Node node : graph.values())
            if(node.children.containsKey(nodeId))
                parents.add(node.nodeId);

        List<Integer> ancestors = new ArrayList<>(parents);

        parents.forEach(parent -> ancestors.addAll(getAncestors(parent,graph)));
        return ancestors;
    }

    public void printAncestors(HashMap<Integer, Node> graph)
    {
        System.out.println("Enter ID of the node whose ancestors to be found : ");
        int nodeId  = scan.nextInt();
        System.out.println("Ancestors are : ");

        List<Integer> ancestors = getAncestors(nodeId,graph);
        ancestors.forEach(ancestor -> System.out.println(ancestor+" , "));
    }
    public List<Integer> getDescendants(int nodeId,HashMap<Integer, Node> graph)
    {
        List<Integer> descendants = new ArrayList<>(graph.get(nodeId).children.keySet());

        graph.get(nodeId).children.keySet().forEach(child -> descendants.addAll(getDescendants(child,graph)));
        return descendants;
    }

    public void printDescendants(HashMap<Integer, Node> graph)
    {
        System.out.println("Enter ID of the node whose descendants to be found : ");
        int nodeId = scan.nextInt();
        System.out.println("Descendants are : ");

        List<Integer> descendants = getDescendants(nodeId, graph);
        System.out.println(descendants);
    }
    public void deleteDependency(HashMap<Integer, Node> graph)
    {
        System.out.println("Enter parent ID and children ID whose dependency to be deleted : ");
        int id1 = scan.nextInt();
        int id2 = scan.nextInt();
        graph.get(id1).children.remove(id2);
    }

    public void deleteNode(HashMap<Integer, Node> graph)
    {
        System.out.println("Enter ID of the node to be deleted");
        int nodeId = scan.nextInt();
        graph.remove(nodeId);
    }

    public void addDependency(int parentId,int childId, boolean isManualEntryEnabled, HashMap<Integer, Node> graph)
    {
        if(isManualEntryEnabled)
        {
            System.out.println("Enter Parent ID and Children ID :");
            parentId = scan.nextInt();
            childId = scan.nextInt();
        }
        if(checkCycle(parentId,childId,graph))
            graph.get(parentId).children.put(childId,graph.get(childId));
        else{
            System.out.println("It is a cycle, re-enter parent and child IDs :");
            addDependency(1,1,true,graph);
        }
    }
    public Boolean checkCycle(int parentId,int childId, HashMap<Integer, Node> graph){
        List<Integer> ancestors;
        ancestors = getAncestors(parentId,graph);
        return !ancestors.contains(childId) && parentId != childId;
    }
}


