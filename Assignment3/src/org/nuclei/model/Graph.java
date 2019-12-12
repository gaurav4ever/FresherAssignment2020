package org.nuclei.model;

import org.nuclei.exception.NodeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    Map<Integer, GraphNode> graph;

    public Graph(){
        this.graph = new HashMap<>();
    }

    public void addNode(GraphNode node) {
        this.graph.put(node.getNodeId(), node);
    }

    public Map<Integer, GraphNode> getGraph() {
        return graph;
    }

    public void setGraph(Map<Integer, GraphNode> graph) {
        this.graph = graph;
    }

    public GraphNode getNode(int nodeId) throws NodeNotFoundException {

        if(!graph.containsKey(nodeId)) {
            throw new NodeNotFoundException("Required node does not exists");
        }
        return graph.get(nodeId);
    }

    public boolean containsNode(int nodeId){
        return graph.containsKey(nodeId);
    }

    public void deleteNode(int nodeId) throws NodeNotFoundException {
        GraphNode toBeDeleted = getNode(nodeId);
        graph.remove(toBeDeleted.getNodeId(), toBeDeleted);
    }

}
