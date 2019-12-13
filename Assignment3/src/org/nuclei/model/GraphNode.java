package org.nuclei.model;

import org.nuclei.exception.NodeAlreadyExistsException;
import org.nuclei.exception.NodeNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {

    private int nodeId;
    private String nodeName;
    private Map<String, String > additionalInformation;
    private List<GraphNode> childNodes;
    private List<GraphNode> parentNodes;

    //TODO: Functionality to update the parent nodes

    public GraphNode() {
        this.additionalInformation = new HashMap<>();
        this.childNodes = new ArrayList<>();
        this.parentNodes = new ArrayList<>();
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Map<String, String> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Map<String, String> additionalInformation) {
        this.additionalInformation = additionalInformation;
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

    public void addAdditionalInformation(String key, String value) {
        this.additionalInformation.put(key, value);
    }

    public void addChildNode(GraphNode node) throws NodeAlreadyExistsException {

        if(this.childNodes.contains(node)){
            throw new NodeAlreadyExistsException("Node already exists in list");
        }
        this.childNodes.add(node);
    }

    public void deleteChildNode(GraphNode node) throws NodeNotFoundException {

        if(!this.childNodes.contains(node)){
            throw new NodeNotFoundException("Child node does not exists");
        }
        childNodes.remove(node);
    }

    public void addParentNode(GraphNode node) throws NodeAlreadyExistsException {

        if(this.parentNodes.contains(node)){
            throw new NodeAlreadyExistsException("Node already exists in list");
        }
        this.parentNodes.add(node);
    }

}
