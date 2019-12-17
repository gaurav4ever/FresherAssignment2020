package com.nuclei.model;

import com.nuclei.exception.NodeAlreadyExistException;
import com.nuclei.exception.NodeNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {
    private int nodeId;
    private String nodeName;
    private Map<String,String> additionalInfo;
    private List<GraphNode> childNodes;
    private List<GraphNode> parentNodes;

    public GraphNode(){
        this.additionalInfo = new HashMap<>();
        this.childNodes = new ArrayList<>();
        this.parentNodes = new ArrayList<>();
    }

    public String getNodeName() {
        return nodeName;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public Map<String, String> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, String> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public List<GraphNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<GraphNode> childNodes) {
        this.childNodes = childNodes;
    }

    public List<GraphNode> getParentNodes() {
        return parentNodes;
    }

    public void setParentNodes(List<GraphNode> parentNodes) {
        this.parentNodes = parentNodes;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void addChildNode(GraphNode node) throws NodeAlreadyExistException {
        if(this.childNodes.contains(node)){
            throw new NodeAlreadyExistException("Node already exist.");
        }
        this.childNodes.add(node);
    }

    public void addParentNode(GraphNode node) throws NodeAlreadyExistException {
        if(this.parentNodes.contains(node)){
            throw new NodeAlreadyExistException("Node Already exist.");
        }
        this.parentNodes.add(node);
    }

    public void deleteChildNode(GraphNode node) throws NodeNotFoundException{
        if(!this.childNodes.contains(node)){
            throw new NodeNotFoundException("Child node does not exists");
        }
        childNodes.remove(node);
    }

}
