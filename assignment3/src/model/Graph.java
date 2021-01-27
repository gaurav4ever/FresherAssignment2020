package model;
import java.util.*;

public class Graph {

    private Map<GraphNode, List<GraphNode> > dependencyGraph = new HashMap<>();

    public Graph(Map<GraphNode, List<GraphNode>> map) {
        this.dependencyGraph = map;
    }

    public Map<GraphNode, List<GraphNode>> getGraph() {
        return dependencyGraph;
    }

    public void setGraph(Map<GraphNode, List<GraphNode>> map) {
        this.dependencyGraph = map;
    }
}
