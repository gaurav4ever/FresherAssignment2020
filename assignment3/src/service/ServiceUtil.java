package service;

import model.Graph;
import model.GraphNode;

import java.util.*;

public class ServiceUtil {
    private static Scanner scan = new Scanner(System.in);
    public static int inputNodeId() {
        return scan.nextInt();
    }
    public static GraphNode getNode(final Graph graph,final int nodeId) {
        Set<GraphNode> nodeSet = graph.getGraph().keySet();
        GraphNode node = null;
        try {
            for (GraphNode tempNode : nodeSet) {
                if (tempNode.getNodeId() == nodeId) {
                    node=tempNode;
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return node;
    }
    public static String inputNodeName() {
        return scan.next();
    }
//    public boolean hasVertex(Graph g, GraphNode node) {
//        return g.getGraph().containsKey(node);
//    }

    // This function gives whether an edge is present or not.
/*    public boolean hasEdge(Graph graph, GraphNode source, GraphNode destination) {
        return graph.getGraph().get(source).contains(destination); }
*/
    private static void dfsUtil(Graph graph,final int vertex, boolean[] visited, List<GraphNode> descendantList) {
        visited[vertex] = true;
        descendantList.add(getNode(graph, vertex));
        List<GraphNode> nodes = graph.getGraph().get(getNode(graph, vertex));
        for (GraphNode graphNode : nodes) {
            int nodeNumber = graphNode.getNodeId();
            if (!visited[graphNode.getNodeId()]){
                dfsUtil(graph, nodeNumber, visited, descendantList);
            }
        }
    }

    public static List<GraphNode> findDescendant(final Graph graph,final GraphNode root) {
        boolean[] visited = new boolean[graph.getGraph().size() + 1];
        List<GraphNode> descendantList = new ArrayList<>();
        dfsUtil(graph, root.getNodeId(), visited, descendantList);
        descendantList.remove(0);
        return descendantList;
    }

    public static void numberOfNodes(final Graph graph) {
        final Set<GraphNode> number = graph.getGraph().keySet();
        System.out.println("Current nodes in the graph are");
        for (GraphNode graphNode : number) {
            System.out.println(graphNode.getNodeId());
        }
    }

    public static void printNodes(final List<GraphNode> nodes) {
        for (GraphNode Node : nodes) {
            System.out.println(Node.getNodeId());
        }
    }

    private static boolean isCyclicUtil(final Graph graph,final GraphNode node, boolean[] visited, boolean[] recStack) {
        final int nodeId = node.getNodeId();
        boolean isCycle=false;
        if (recStack[nodeId]) {
            isCycle=true;
        }
        if (visited[nodeId]) {
            isCycle=false;
        }
        visited[nodeId] = true;
        recStack[nodeId] = true;
        List<GraphNode> children = graph.getGraph().get(node);
        try {
            for (GraphNode c : children) {
                if (isCyclicUtil(graph, c, visited, recStack)) {
                    return true;
                }
            }
            recStack[nodeId] = false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return isCycle;
    }

    public static boolean checkCycle(final Graph graph) {
        boolean[] visited = new boolean[graph.getGraph().size() + 1];
        boolean[] recStack = new boolean[graph.getGraph().size() + 1];
        Set<GraphNode> graphNodes = graph.getGraph().keySet();
        boolean isCycle=false;
        for (GraphNode node : graphNodes) {
            if (isCyclicUtil(graph, node, visited, recStack)) {
                isCycle=true;
            }
        }
        return isCycle;
    }

    public static List<GraphNode> parentUtil(final Graph graph,final int source) {
        List<GraphNode> parentList = new ArrayList<>();
        Map<GraphNode, List<GraphNode>> dependencyGraph = graph.getGraph();
        List<GraphNode> nodeList;
        final int size = dependencyGraph.size();
        for (int i = 0; i < size; i++) {
            nodeList = dependencyGraph.get(i);
            for (GraphNode x : nodeList) {
                if (x.getNodeId() == source) {
                    parentList.add(x);
                }
            }
        }
        return parentList;
    }
}
