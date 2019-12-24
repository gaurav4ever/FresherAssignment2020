
import java.util.*;


public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        Graph graph = new Graph<>();

//
//        graph.addEdge(1, 5, false);
//        graph.addEdge(1, 2, false);
//        graph.addEdge(1, 8, false);
//        graph.addEdge(2, 3, false);
//        graph.addEdge(2, 4, false);
//        graph.addEdge(3, 9, false);
//        graph.addEdge(5, 7, false);
//        graph.addEdge(5, 3, false);
//        graph.addEdge(8, 4, false);
//        graph.addEdge(8, 9, false);

        System.out.println("Enter the number of nodes ");
        int noOfNodes = Integer.parseInt(sc.next());
        while (true) {
            System.out.println("Enter the source and destination to add an edge in the graph");
            int source = Integer.parseInt(sc.next());
            int destination = Integer.parseInt(sc.next());
            System.out.println("The edge should be bidirectional..?");
            boolean bool = Boolean.parseBoolean(sc.next()); // true for bidirectional
            graph.addEdge(source, destination, bool);
            System.out.println("Want to add more edge? Press continue otherwise break");
            String choice = sc.next();
            if (choice.equals("continue")) {
                continue;
            } else {
                break;
            }
        }

        String error = "Incorrect choice. Type again..!!!";
        while (true) {
            //creating a menu
            System.out.println("------------------------------");
            System.out.println("Main Menu for Operations to Perform");
            System.out.println("------------------------------------------------");
            System.out.println("1. Get the immediate parents of a node : ");
            System.out.println("2. Get the immediate children of a node");
            System.out.println("3. Get the ancestors of a node");
            System.out.println("4. Get the descendants of a node");
            System.out.println("5. Delete a dependency from the tree, i.e; link between two nodes");
            System.out.println("6.. Delete a node from a tree");
            System.out.println("7. Add a new node to the tree");
            System.out.println("8. Exit");
            System.out.println("Enter a choice");
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(sc.next());
                    break;
                } catch (Exception ex) {
                    System.out.println(error);
                }
            }
            switch (choice) {

                case 1:
                    System.out.println("Enter the node : ");
                    int node;
                    while (true) {
                        try {
                            node = Integer.parseInt(sc.next());
                            break;
                        } catch (Exception ex) {
                            System.out.println(error);
                        }
                    }
                    List<Integer> parentNodeList = graph.getImmediateParents(node);// parent node list
                    System.out.println(parentNodeList.toString());
                    break;

                case 2:
                    System.out.println("Enter the node : ");
                    int node2;
                    while (true) {
                        try {
                            node2 = Integer.parseInt(sc.next());
                            break;
                        } catch (Exception ex) {
                            System.out.println(error);
                        }
                    }
                    String childrens = graph.getImmediateChildrens(node2); // children node list
                    System.out.println(childrens);
                    break;

                case 3:
                    System.out.println("Enter the node : ");
                    int node3;
                    while (true) {
                        try {
                            node3 = Integer.parseInt(sc.next());
                            break;
                        } catch (Exception ex) {
                            System.out.println(error);
                        }
                    }
                    Set<Integer> ancestorList = graph.getAncestors(node3);// parent node list
                    System.out.println(ancestorList.toString());
                    break;


                case 4:
                    System.out.println("Enter the node : ");
                    int node4;
                    while (true) {
                        try {
                            node4 = Integer.parseInt(sc.next());
                            break;
                        } catch (Exception ex) {
                            System.out.println(error);
                        }
                    }
                    String childrenList = graph.getChildrens(node4);// parent node list
                    System.out.println(childrenList);
                    break;


                case 5:
                    System.out.println("Enter the source node of the tree : ");
                    int source, destination;
                    while (true) {
                        try {
                            source = Integer.parseInt(sc.next());
                            break;
                        } catch (Exception ex) {
                            System.out.println(error);
                        }
                    }
                    System.out.println("Enter the destination node of the tree");
                    while (true) {
                        try {
                            destination = Integer.parseInt(sc.next());
                            break;
                        } catch (Exception ex) {
                            System.out.println(error);
                        }
                    }
                    graph.remove(source, destination);
                    System.out.println("Edge from source: " + source + " to destination: " + destination + " is successfully deleted..!!");
                    break;

                case 6:
                    System.out.println("Enter the node to be deleted from the tree");
                    int deletedNode;
                    while (true) {
                        try {
                            deletedNode = Integer.parseInt(sc.next());
                            break;
                        } catch (Exception ex) {
                            System.out.println(error);
                        }
                    }
                    graph.rem(deletedNode);
                    System.out.println("Node removed from the graph successfully...!!!");
                    break;

                case 7:
                    System.out.println("Enter source and destination to add an edge to the graph and check cycle");
                    int source = Integer.parseInt(sc.next());
                    int destination = Integer.parseInt(sc.next());
                    graph.addEdge(source, destination, false);
                    boolean checkCycleInGraph = graph.checkCycle(source, destination);
                    if (true == checkCycleInGraph) {
                        graph.rem(source);
                        graph.rem(destination);
                    }
                    break;

                case 8:
                    return;
            }
        }
    }
}
