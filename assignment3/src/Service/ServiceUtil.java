package Service;

import model.Graph;
import model.GraphNode;

import java.util.*;

public class ServiceUtil {
    public static int inputNodeId() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static GraphNode getNode(Graph g, int nodeId) {
        Set<GraphNode> number = g.getGraph().keySet();
        try {
            for (GraphNode v : number)
                if (v.getNodeId() == nodeId) {
                    return v;
                }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    public static String inputNodeName() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public boolean hasVertex(Graph g, GraphNode node) {
        return g.getGraph().containsKey(node);
    }

    // This function gives whether an edge is present or not.
/*    public boolean hasEdge(Graph g, GraphNode source, GraphNode destination) {
        return g.getGraph().get(source).contains(destination); }
*/
    private static void DFSUtil(Graph g, int v, boolean[] visited, List<GraphNode> descendantList) {
        visited[v] = true;
        descendantList.add(getNode(g, v));
        List<GraphNode> Nodes = g.getGraph().get(getNode(g, v));
        for (GraphNode Node : Nodes) {
            int n = Node.getNodeId();
            if (!visited[Node.getNodeId()])
                DFSUtil(g, n, visited, descendantList);
        }
    }

    public static List<GraphNode> DFS(Graph g, GraphNode root) {
        boolean[] visited = new boolean[g.getGraph().size() + 1];
        List<GraphNode> descendantList = new ArrayList<>();
        DFSUtil(g, root.getNodeId(), visited, descendantList);
        descendantList.remove(0);
        return descendantList;
    }

    public static void numberOfNodes(Graph g) {
        Set<GraphNode> number = g.getGraph().keySet();
        System.out.println("Current nodes in the graph are");
        for (GraphNode Node : number) {
            System.out.println(Node.getNodeId());
        }
    }

    public static void printNodes(List<GraphNode> Nodes) {
        for (GraphNode Node : Nodes) {
            System.out.println(Node.getNodeId());
        }
    }

    private static boolean isCyclicUtil(Graph g, GraphNode node, boolean[] visited, boolean[] recStack) {
        int nodeId = node.getNodeId();
        if (recStack[nodeId])
            return true;
        if (visited[nodeId])
            return false;
        visited[nodeId] = true;
        recStack[nodeId] = true;
        List<GraphNode> children = g.getGraph().get(node);
        try {
            for (GraphNode c : children)
                if (isCyclicUtil(g, c, visited, recStack))
                    return true;
            recStack[nodeId] = false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public static boolean checkCycle(Graph g) {
        boolean[] visited = new boolean[g.getGraph().size() + 1];
        boolean[] recStack = new boolean[g.getGraph().size() + 1];
        Set<GraphNode> graphNodes = g.getGraph().keySet();
        for (GraphNode node : graphNodes)
            if (isCyclicUtil(g, node, visited, recStack))
                return true;
        return false;
    }

    public static List<GraphNode> parentUtil(Graph g, int source) {
        List<GraphNode> parentList = new ArrayList<>();
        Map<GraphNode, List<GraphNode>> dependencyGraph = g.getGraph();
        List<GraphNode> nodeList;
        int size = dependencyGraph.size();
        for (int i = 0; i < size; i++) {
            nodeList = dependencyGraph.get(i);
            for (GraphNode x : nodeList) {
                if (x.getNodeId() == source)
                    parentList.add(x);
            }
        }
        return parentList;
    }
}
