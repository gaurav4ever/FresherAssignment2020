package com.nuclei.utils;

import com.nuclei.exception.CyclicGraphException;
import com.nuclei.exception.InvalidChoiceException;
import com.nuclei.exception.NodeAlreadyExistException;
import com.nuclei.exception.NodeNotFoundException;
import com.nuclei.model.GraphNode;
import com.nuclei.service.impl.DependencyGraphImplementation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.w3c.dom.Node;

public class MainUtil {
    static Scanner sc = new Scanner(System.in);
    static DependencyGraphImplementation graph = new DependencyGraphImplementation();
    public static void showMenu() {
        System.out.println("------------------------Menu--------------------------");
        System.out.println("1. Get Immediate Parents of a Node");
        System.out.println("2. Get Immediate Children of a Node");
        System.out.println("3. Ancestors of a Node");
        System.out.println("4. Descendants of a Node");
        System.out.println("5. Delete a Dependency");
        System.out.println("6. Delete a Node");
        System.out.println("7. Add a New Dependency");
        System.out.println("8. Add a new Node");
        System.out.println("9. See All Nodes with Incoming and Outgoing Nodes");
        System.out.println("10. Exit");
    }

    public void selectAction(int choice) throws InvalidChoiceException {
        if(choice > 10 || choice < 1){
            throw new InvalidChoiceException("Enter a valid choice");
        }
        int id,parentId,childId;
        switch(choice){
            case 1:
                System.out.println("Enter id : ");
                List<GraphNode> immediateParents = null;
                id=sc.nextInt();
                try{
                    immediateParents = graph.getParents(id);
                } catch (NodeNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Node does not exist.");
                }
                if(immediateParents!=null){
                    printGraph(immediateParents);
                }
                break;
            case 2:
                System.out.println("Enter id : ");
                List<GraphNode> immediateChildren = null;
                id=sc.nextInt();
                try {
                    immediateChildren = graph.getChildren(id);
                } catch (NodeNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Node does not exist.");
                }
                if(immediateChildren!=null){
                    printGraph(immediateChildren);
                }
                break;
            case 3:
                System.out.println("Enter id : ");
                List<GraphNode> ancestors = null;
                id=sc.nextInt();
                try{
                    ancestors = graph.getAncestors(id);
                }
                catch (NodeNotFoundException e){
                    System.out.println("Node does not exist.");
                }
                if(ancestors!=null){
                    printGraph(ancestors);
                }
                break;
            case 4:
                System.out.println("Enter id : ");
                List<GraphNode> descendants = null;
                id=sc.nextInt();
                try{
                    descendants = graph.getDescendants(id);
                }
                catch (NodeNotFoundException e){
                    System.out.println("Node does not exist.");
                }
                if(descendants!=null){
                    printGraph(descendants);
                }
                break;
            case 5:
                System.out.println("Enter parent id : ");
                parentId = sc.nextInt();
                System.out.println("Enter child id : ");
                childId = sc.nextInt();
                try {
                    graph.deleteDependency(parentId,childId);
                } catch (NodeNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                System.out.println("Enter id : ");
                id = sc.nextInt();
                try {
                    graph.deleteNode(id);
                } catch (NodeNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                System.out.println("Enter parent id : ");
                parentId = sc.nextInt();
                System.out.println("Enter child id : ");
                childId = sc.nextInt();
                try{
                    graph.addDependency(parentId,childId);
                }
                catch (CyclicGraphException | NodeAlreadyExistException | NodeNotFoundException e){
                    e.printStackTrace();
                }
                break;
            case 8:
                System.out.println("Enter id (Integer) : ");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter name of the node (String)");
                String name = sc.nextLine();
                GraphNode node = new GraphNode();
                node.setNodeId(id);
                node.setNodeName(name);
                break;
            case 9:
                List<GraphNode> allNodes = graph.getAllNodes();
                for(GraphNode temp : allNodes){
                    System.out.println(temp.getNodeName());
                }
                break;
            case 10:
                break;
            default :
                System.out.println("Invalid choice please try again.");
        }
    }

    private void printGraph(List<GraphNode> immediateParents) {
        for(GraphNode node : immediateParents){
            System.out.println(" "+ node.getNodeId()+" ");
        }
    }

    public void start(){
        while(true){
            showMenu();
            int choice = -1;
            try{
                choice = sc.nextInt();
                selectAction(choice);
            }
            catch(InputMismatchException e){
                System.out.println("Please enter integer.");
            }
            catch(InvalidChoiceException e){
                System.out.println("Enter valid choice.");
            }
        }

    }


}
