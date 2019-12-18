package service;

import model.Graph;
import model.GraphNode;
import java.util.*;

public class GraphService {
    private static Scanner scan = new Scanner(System.in);
    public static void run() {
        Map<GraphNode, List<GraphNode>> dependencyGraph = new HashMap<>();
        model.Graph graph = new Graph(dependencyGraph);
        while (true) {
            menu(graph);
            System.out.println("Want to run again?(y/n)");
            if (!scan.next().equals("y")) {
                exitProgram();
            }
        }

    }
    public static void menu(Graph graph) {
        System.out.println("Menu:\n" +
                "1. Get the immediate parents of a node\n" +
                "2. Get the immediate children of a node\n" +
                "3. Get the ancestors of a node\n4. Get the descendants of a node\n" +
                "5. Delete dependency from a tree\n6. Delete a node from a tree\n" +
                "7. Add a new dependency to a tree\n8. Add a new node to tree.\n 9.Exit");
        final int choice = scan.nextInt();
        switch (choice) {
            case 1:
                getParent(graph);
                break;
            case 2:
                getChild(graph);
                break;
            case 3:
                getAncestor(graph);
                break;
            case 4:
                getDescendant(graph);
                break;
            case 5:
                deleteEdge(graph);
                break;
            case 6:
                deleteNode(graph);
                break;
            case 7:
                addEdge(graph);
                break;
            case 8:
                addNode(graph);
                break;
            default:
                ServiceUtil.numberOfNodes(graph);
                exitProgram();
        }
    }

    private static void exitProgram() {
        System.out.print("exit");
        System.exit(0);
    }

    private static void getChild(final Graph graph) {
        System.out.println("enter the node to fetch immediate Children");
        final int nodeId=ServiceUtil.inputNodeId();
        ListIterator<GraphNode>
                iterator = graph.getGraph().get(ServiceUtil.getNode(graph, nodeId)).listIterator();
        while (iterator.hasNext()) {
            System.out.println("Child is : " + iterator.next().getNodeId());
        }
    }

    private static void getParent(final Graph graph) {
        System.out.println("enter the node to fetch immediate parent\n");
        final GraphNode node= ServiceUtil.parentUtil(graph,ServiceUtil.inputNodeId()).get(0);
        System.out.println("Parent Node is " + node.getNodeId());
    }

    public static void addEdge(final Graph dependencyGraph) {
        //if (!G.getGraph().containsKey(source))
        //  addNode(G,source);
        System.out.println("Enter Source Node Id and Destination Node Id to add Dependency");
        System.out.println("Enter Source Node Id");
        final GraphNode source = ServiceUtil.getNode(dependencyGraph, ServiceUtil.inputNodeId());
        System.out.println("Enter Destination Node Id");
        final GraphNode destination = ServiceUtil.getNode(dependencyGraph, ServiceUtil.inputNodeId());
        dependencyGraph.getGraph().get(source).add(destination);
        if (source != null && destination != null) {
            if(ServiceUtil.checkCycle(dependencyGraph))
            {
                deleteEdge(dependencyGraph);
                System.out.println("Dependency Cannot be added, creates cycle \n");
            } else {
                System.out.println("Dependency Added \n");
            }
        } else {
            System.out.println("Nodes not present in the dependency graph");
        }
        //G.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public static void addNode(final Graph dependencyGraph) {
        System.out.println("Enter Node details to add in the dependency graph");
        System.out.println("Enter Node Id");
        final int nodeId = ServiceUtil.inputNodeId();
        System.out.println("Enter Node Name");
        final String nodeName = ServiceUtil.inputNodeName();
        GraphNode node = new GraphNode(nodeId, nodeName);
        dependencyGraph.getGraph().put(node, new LinkedList<GraphNode>());
        System.out.println("Node Added");
    }

    public static void getAncestor(final Graph dependencyGraph) {
        System.out.println("enter the node to fetch Ancestors");
        final int source=ServiceUtil.inputNodeId();
        final List<GraphNode> ancestorList= ServiceUtil.parentUtil(dependencyGraph,source);
        for(GraphNode graphNode:ancestorList) {
            System.out.println("Parent Node is " + graphNode.getNodeId());
        }
    }

    public static void getDescendant(final Graph dependencyGraph) {
        System.out.println("enter the node to fetch Descendent");
        final int source=ServiceUtil.inputNodeId();
        final List<GraphNode> nodeList = ServiceUtil.findDescendant(dependencyGraph, Objects.requireNonNull(ServiceUtil.getNode(dependencyGraph, source)));
        if(nodeList.isEmpty())
        {
            System.out.println("Descendants are:");
            ServiceUtil.printNodes(nodeList);
        }
        else {
            System.out.println("No descendents found");
        }
    }

    public static void deleteEdge(final Graph graph) {
        System.out.println("enter the source and destination to delete dependency");
        final int source=ServiceUtil.inputNodeId();
        final int destination=ServiceUtil.inputNodeId();
        final List<GraphNode> edgeList = graph.getGraph().get(ServiceUtil.getNode(graph,source));
        if (edgeList != null) {
            edgeList.remove(ServiceUtil.getNode(graph, destination));
        }
        System.out.println("Dependency removed");
    }

    public static void deleteNode(final Graph graph) {
        System.out.println("Enter Node Id to Delete it from a tree");
        final GraphNode source= ServiceUtil.getNode(graph, ServiceUtil.inputNodeId());
        graph.getGraph().values().stream().forEach(e -> e.remove(source));
        graph.getGraph().remove(source);
        System.out.println("Node removed");
    }

}
