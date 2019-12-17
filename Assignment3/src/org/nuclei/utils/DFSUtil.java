package org.nuclei.utils;

import org.nuclei.exception.NodeNotFoundException;
import org.nuclei.model.Graph;
import org.nuclei.model.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class DFSUtil {

    private List<GraphNode> finalNodeList;
    private List<GraphNode> visitedList;
    private GraphNode startNode;
    private Graph graph;

    public DFSUtil(Graph graph, GraphNode startNode) {
        this.graph = graph;
        this.startNode = startNode;
        finalNodeList = new ArrayList<>();
        visitedList = new ArrayList<>();
    }

    public List<GraphNode> getChildSubGraph() throws NodeNotFoundException {

        finalNodeList = new ArrayList<>();
        visitedList = new ArrayList<>();
        if(!graph.containsNode(startNode.getNodeId())){
            throw new NodeNotFoundException("Start node not in the graph");
        }
        dfsChild(startNode);
        return finalNodeList;
    }

    public List<GraphNode> getParentSubGraph() throws NodeNotFoundException {

        finalNodeList = new ArrayList<>();
        visitedList = new ArrayList<>();
        if(!graph.containsNode(startNode.getNodeId())){
            throw new NodeNotFoundException("Start node not in the graph");
        }
        dfsParent(startNode);
        return finalNodeList;
    }

    public GraphNode getStartNode() {
        return startNode;
    }

    public void setStartNode(GraphNode startNode) {
        this.startNode = startNode;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void dfsChild(GraphNode rootNode) {
        if(visitedList.contains(rootNode)){
            return;
        }
        finalNodeList.add(rootNode);
        visitedList.add(rootNode);
        for(GraphNode node : rootNode.getChildNodes()) {
            dfsChild(node);
        }
    }

    public void dfsParent(GraphNode rootNode) {
        if(visitedList.contains(rootNode)){
            return;
        }
        finalNodeList.add(rootNode);
        visitedList.add(rootNode);
        for(GraphNode node : rootNode.getParentNodes()) {
            dfsParent(node);
        }
    }

}
