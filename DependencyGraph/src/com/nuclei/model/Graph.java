package com.nuclei.model;

import com.nuclei.exception.NodeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    Map<Integer,GraphNode> graph;

    public Map<Integer, GraphNode> getGraph() {
        return graph;
    }

    public void setGraph(Map<Integer, GraphNode> graph) {
        this.graph = graph;
    }

    public Graph(){
        this.graph = new HashMap<>();
    }

    public GraphNode getNode(int nodeId) throws NodeNotFoundException{
        if(!graph.containsKey(nodeId)){
            throw new NodeNotFoundException("Required node does not exist.");
        }
        return graph.get(nodeId);
    }

    public boolean containsKey(int nodeId){
        return graph.containsKey(nodeId);
    }

    public void deleteNode(int nodeId) throws NodeNotFoundException{
        GraphNode toBeDeleted = getNode(nodeId);
        graph.remove(nodeId,toBeDeleted);
    }
    public void addNode(GraphNode node){
        graph.put(node.getNodeId(),node);
    }
}
