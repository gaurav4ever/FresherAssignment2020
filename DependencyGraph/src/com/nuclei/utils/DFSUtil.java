package com.nuclei.utils;

import com.nuclei.exception.NodeNotFoundException;
import com.nuclei.model.Graph;
import com.nuclei.model.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class DFSUtil {
    private List<GraphNode> finalNodeList;
    private List<GraphNode> visitedNodeList;
    private GraphNode startNode;
    private Graph graph;

    public DFSUtil(Graph graph,GraphNode startNode){
        this.graph = graph;
        this.startNode = startNode;
        this.finalNodeList = new ArrayList<>();
        this.visitedNodeList = new ArrayList<>();
    }

    public List<GraphNode> getChildSubGraph() throws NodeNotFoundException {
        finalNodeList = new ArrayList<>();
        visitedNodeList = new ArrayList<>();
        if(!graph.containsKey(startNode.getNodeId())){
            throw new NodeNotFoundException("Start node not present in the graph");
        }
        dfsChildUtil(startNode);
        return finalNodeList;
    }

    public void dfsChildUtil(GraphNode rootNode){
        if(visitedNodeList.contains(rootNode)){
            return;
        }
        finalNodeList.add(rootNode);
        visitedNodeList.add(rootNode);
        for(GraphNode node : rootNode.getChildNodes()){
            dfsChildUtil(node);
        }
    }

    public List<GraphNode> getParentSubGraph() throws NodeNotFoundException {
        finalNodeList = new ArrayList<>();
        visitedNodeList = new ArrayList<>();
        if(!graph.containsKey(startNode.getNodeId())){
            throw new NodeNotFoundException("Start node not present in the group.");
        }
        dfsParentUtil(startNode);
        return finalNodeList;
    }

    public void dfsParentUtil(GraphNode rootNode){
        if(visitedNodeList.contains(rootNode)){
            return ;
        }
        finalNodeList.add(rootNode);
        visitedNodeList.add(rootNode);
        for(GraphNode node : rootNode.getParentNodes()){
            dfsParentUtil(rootNode);
        }
    }
}
