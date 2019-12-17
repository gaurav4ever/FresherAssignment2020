package Service;

import model.Graph;
import model.GraphNode;
import java.util.*;

public class GraphService {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        Map<GraphNode, List<GraphNode>> dependencyGraph = new HashMap<>();
        model.Graph g = new Graph(dependencyGraph);
        while (true) {
            menu(g);
            System.out.println("Want to run again?(y/n)");
            if (!sc.next().equals("y"))
                exitProgram();
        }

    }

    public static void menu(Graph g) {
        System.out.println("Menu:\n" +
                "1. Get the immediate parents of a node\n" +
                "2. Get the immediate children of a node\n" +
                "3. Get the ancestors of a node\n4. Get the descendants of a node\n" +
                "5. Delete dependency from a tree\n6. Delete a node from a tree\n" +
                "7. Add a new dependency to a tree\n8. Add a new node to tree.\n 9.Exit");
        Scanner sc = new Scanner(System.in);
        GraphNode node;
        List<GraphNode> nodeList;
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("enter the node to fetch immediate parent\n");
                node = getParent(g, ServiceUtil.inputNodeId());
                //assert node != null;
                System.out.println("Parent Node is " + node.getNodeId());
                break;
            }
            case 2: {
                System.out.println("enter the node to fetch immediate Children");
                getChild(g, ServiceUtil.inputNodeId());
                break;
            }
            case 3: {
                System.out.println("enter the node to fetch Ancestors");
                nodeList = getAncestor(g, ServiceUtil.inputNodeId());
                for(GraphNode graphNode:nodeList)
                    System.out.println("Parent Node is "+ graphNode.getNodeId());
                break;
            }
            case 4: {
                System.out.println("enter the node to fetch Descendent");
                nodeList = getDescendant(g, ServiceUtil.inputNodeId());
                if(nodeList.isEmpty())
                {
                    System.out.println("Descendants are");
                    ServiceUtil.printNodes(nodeList);
                }
                else
                    System.out.println("No descendents found");
                break;
            }
            case 5: {
                System.out.println("enter the source and destination to delete dependency");
                deleteEdge(g, ServiceUtil.getNode(g, ServiceUtil.inputNodeId()), ServiceUtil.getNode(g, ServiceUtil.inputNodeId()));
                System.out.println("Dependency removed");
                break;
            }
            case 6:{
                System.out.println("Enter Node Id to Delete it from a tree");
                deleteNode(g, ServiceUtil.getNode(g, ServiceUtil.inputNodeId()));
                System.out.println("Node removed");
                break;
            }
            case 7: {
                System.out.println("Enter Source Node Id and Destination Node Id to add Dependency");
                System.out.println("Enter Source Node Id");
                GraphNode temp1 = ServiceUtil.getNode(g, ServiceUtil.inputNodeId());
                System.out.println("Enter Destination Node Id");
                GraphNode temp2 = ServiceUtil.getNode(g, ServiceUtil.inputNodeId());
                if (temp1 != null && temp2 != null) {

                    addEdge(g, temp1, temp2);
                    if(ServiceUtil.checkCycle(g))
                    {
                        deleteEdge(g,temp1,temp2);
                        System.out.println("Dependency Cannot be added, creates cycle \n");
                    }
                    else
                    System.out.println("Dependency Added \n");
                } else {
                    System.out.println("Nodes not present in the dependency graph");
                }
                break;
            }
            case 8:{
              System.out.println("Enter Node details to add in the dependency graph");
                System.out.println("Enter Node Id");
                int nodeId = ServiceUtil.inputNodeId();
                System.out.println("Enter Node Name");
                String nodeName = ServiceUtil.inputNodeName();
                addNode(g, nodeId, nodeName);
                System.out.println("Node Added");
                ServiceUtil.numberOfNodes(g);
                break;
            }
            default:
                exitProgram();
        }
    }

    private static void exitProgram() {
        System.out.print("exit");
        System.exit(0);
    }

    private static void getChild(Graph g, int nodeId) {
        ListIterator<GraphNode>
                iterator = g.getGraph().get(ServiceUtil.getNode(g, nodeId)).listIterator();
        while (iterator.hasNext()) {
            System.out.println("Child is : " + iterator.next().getNodeId());
        }
    }

    private static GraphNode getParent(Graph g, int inputNodeId) {
        return ServiceUtil.parentUtil(g,inputNodeId).get(0);
    }

    public static void addEdge(Graph dependencyGraph, GraphNode source, GraphNode destination) {
        //if (!G.getGraph().containsKey(source))
        //  addNode(G,source);
        dependencyGraph.getGraph().get(source).add(destination);
        //G.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public static void addNode(Graph dependencyGraph, int nodeId, String nodeName) {
        GraphNode node = new GraphNode(nodeId, nodeName);
        dependencyGraph.getGraph().put(node, new LinkedList<GraphNode>());
    }

    public static List<GraphNode> getAncestor(Graph dependencyGraph, Integer source) {
      return ServiceUtil.parentUtil(dependencyGraph,source);
    }

    public static List<GraphNode> getDescendant(Graph dependencyGraph, Integer source) {

        return ServiceUtil.DFS(dependencyGraph,ServiceUtil.getNode(dependencyGraph, source));
    }

    public static void deleteEdge(Graph g, GraphNode source, GraphNode destination) {
        List<GraphNode> eV1 = g.getGraph().get(source);
        if (eV1 != null)
            eV1.remove(destination);
    }

    public static void deleteNode(Graph g, GraphNode source) {
        g.getGraph().values().stream().forEach(e -> e.remove(source));
        g.getGraph().remove(source);
    }

}
