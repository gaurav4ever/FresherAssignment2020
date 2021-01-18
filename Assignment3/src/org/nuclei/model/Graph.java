package org.nuclei.model;

import org.nuclei.exception.NodeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    Map<Integer, GraphNode> dependencyGraph;

    public Graph(){
        this.dependencyGraph = new HashMap<>();
    }

    public void addNode(GraphNode node) {
        this.dependencyGraph.put(node.getNodeId(), node);
    }

    public Map<Integer, GraphNode> getDependencyGraph() {
        return dependencyGraph;
    }

    public void setDependencyGraph(Map<Integer, GraphNode> dependencyGraph) {
        this.dependencyGraph = dependencyGraph;
    }

    public GraphNode getNode(int nodeId) throws NodeNotFoundException {

        if(!dependencyGraph.containsKey(nodeId)) {
            throw new NodeNotFoundException("Required node does not exists");
        }
        return dependencyGraph.get(nodeId);
    }

    public boolean containsNode(int nodeId){
        return dependencyGraph.containsKey(nodeId);
    }

    public void deleteNode(int nodeId) throws NodeNotFoundException {
        GraphNode toBeDeleted = getNode(nodeId);
        dependencyGraph.remove(toBeDeleted.getNodeId(), toBeDeleted);
    }

}
