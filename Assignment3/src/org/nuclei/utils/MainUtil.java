package org.nuclei.utils;

import org.nuclei.exception.CyclicGraphException;
import org.nuclei.exception.InvalidChoiceException;
import org.nuclei.exception.NodeAlreadyExistsException;
import org.nuclei.exception.NodeNotFoundException;
import org.nuclei.model.Graph;
import org.nuclei.model.GraphNode;
import org.nuclei.service.impl.DependencyGraphServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainUtil {

    static Scanner sc = new Scanner(System.in);
    static DependencyGraphServiceImpl graph = new DependencyGraphServiceImpl();

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

    static void printList(List<GraphNode> list) {
        System.out.println("[");
        for(GraphNode node: list) {
            System.out.println(" " + node.getNodeId()+ " ");
        }
        System.out.println("]");
    }

    private static void performAction(int option) throws InvalidChoiceException {
        int id;
        if(option>10 || option<1){
            throw new InvalidChoiceException("Enter a valid choice");
        }
        switch(option) {
            case 1:
                System.out.println("Enter the id:");
                List<GraphNode> immediateParents = null;
                id = sc.nextInt();
                try {
                    immediateParents = graph.getParents(id);
                } catch ( NodeNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Node doesn't Exist");
                }
                if(immediateParents!=null)
                    printList(immediateParents);
                break;
            case 2:
                System.out.println("Enter the id:");
                List<GraphNode> immediateChildren = null;
                id = sc.nextInt();
                try {
                    immediateChildren = graph.getChildren(id);
                } catch ( NodeNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Node doesn't Exist");
                }
                if(immediateChildren!=null)
                    printList(immediateChildren);
                break;
            case 3:
                System.out.println("Enter the id:");
                List<GraphNode> ancestors = null;
                id = sc.nextInt();
                try {
                    ancestors = graph.getAncestors(id);
                } catch (NodeNotFoundException e) {
                    e.printStackTrace();
                }
                if(ancestors!=null)
                    printList(ancestors);
                break;
            case 4:
                System.out.println("Enter the id:");
                List<GraphNode> descendants = null;
                id = sc.nextInt();
                try {
                    descendants = graph.getDescendants(id);
                } catch (NodeNotFoundException e) {
                    System.out.println("Node doesn't Exist");
                }
                if(descendants!=null)
                    printList(descendants);
                break;
            case 5:
                System.out.println("Enter two ids");
                int id1 = sc.nextInt();
                int id2 = sc.nextInt();
                try {
                    graph.deleteDependency(id1, id2);
                } catch (NodeNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 6:
                System.out.println("Enter the id");
                id = sc.nextInt();
                try {
                    graph.deleteNode(id);
                } catch ( NodeNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Node does not exist");
                }
                break;
            case 7:
                System.out.println("Enter the 2 ids");
                id1 = sc.nextInt();
                id2 = sc.nextInt();
                try {
                    graph.addDependency(id1, id2);
                } catch (NodeNotFoundException | NodeAlreadyExistsException | CyclicGraphException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                break;
            case 8:
                System.out.println("Enter the id [Integer]");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the name of Node [String]");
                String name = sc.nextLine();
                GraphNode tempNode = new GraphNode();
                tempNode.setNodeId(id);
                tempNode.setNodeName(name);
                //TODO: functionality to add additional information
                try {
                    graph.addNode(tempNode);
                } catch (NodeAlreadyExistsException e) {
                    e.printStackTrace();
                }
                break;
            case 9:
                List<GraphNode> allNodes= graph.getAllNodes();
                for(GraphNode node: allNodes) {
                    System.out.println(node.getNodeName());
                }
                break;
            case 10:
                break;
            default:
                System.out.println("Invalid Choice Please Try Again");
        }
    }

    public static void run() {
        while(true) {
            showMenu();
            int option = -1;
            try {
                option = sc.nextInt();
                performAction(option);
            } catch (InputMismatchException e) {
                System.out.println("Not an Integer");
            }catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
            if(option==10) break;
        }
    }

}
