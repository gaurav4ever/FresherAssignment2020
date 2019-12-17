package com.nuclei.service;

import com.nuclei.exception.CyclicGraphException;
import com.nuclei.exception.NodeAlreadyExistException;
import com.nuclei.exception.NodeNotFoundException;
import com.nuclei.model.Graph;
import com.nuclei.model.GraphNode;
import org.w3c.dom.Node;

import java.util.List;

public interface GraphService {
    Graph dependencyGraph = new Graph();
    List<GraphNode> getParents(int nodeId) throws NodeNotFoundException;
    List<GraphNode> getChildren(int nodeId) throws NodeNotFoundException;
    List<GraphNode> getAncestors(int nodeId) throws NodeNotFoundException;
    List<GraphNode> getDescendants(int nodeId) throws NodeNotFoundException;
    void addDependency(int parentId,int childId) throws NodeNotFoundException, NodeAlreadyExistException, CyclicGraphException;
    void deleteDependency(int parentId,int childId) throws NodeNotFoundException;
    void deleteNode(int id) throws NodeNotFoundException;
    void addNode(GraphNode node) throws NodeAlreadyExistException;
    List<GraphNode> getAllNodes();
}
