package org.nuclei.service;

import org.nuclei.exception.CyclicGraphException;
import org.nuclei.exception.NodeAlreadyExistsException;
import org.nuclei.exception.NodeNotFoundException;
import org.nuclei.model.Graph;
import org.nuclei.model.GraphNode;

import java.util.List;

public interface GraphService {
    Graph dependencyGraph = new Graph();

    List<GraphNode> getParents(int nodeId) throws NodeNotFoundException;
    List<GraphNode> getChildren(int nodeId) throws NodeNotFoundException;
    List<GraphNode> getAncestors(int nodeId) throws NodeNotFoundException;
    List<GraphNode> getDescendants(int nodeId) throws NodeNotFoundException;
    void addDependency(int parentNodeId, int childNodeId) throws NodeAlreadyExistsException, NodeNotFoundException, CyclicGraphException;
    void addNode(GraphNode node) throws NodeNotFoundException, NodeAlreadyExistsException;
    void deleteDependency(int parentNodeId, int childNodeId) throws NodeNotFoundException;
    void deleteNode(int nodeId) throws NodeNotFoundException;
    List<GraphNode> getAllNodes();

}
