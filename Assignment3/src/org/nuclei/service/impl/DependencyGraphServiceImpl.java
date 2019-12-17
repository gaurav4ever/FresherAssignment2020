package org.nuclei.service.impl;

import org.nuclei.exception.CyclicGraphException;
import org.nuclei.exception.NodeAlreadyExistsException;
import org.nuclei.exception.NodeNotFoundException;
import org.nuclei.model.Graph;
import org.nuclei.model.GraphNode;
import org.nuclei.service.GraphService;
import org.nuclei.utils.DFSUtil;

import java.util.ArrayList;
import java.util.List;

public class DependencyGraphServiceImpl implements GraphService {

    Graph dependencyGraph = new Graph();

    @Override
    public List<GraphNode> getParents(int nodeId) throws NodeNotFoundException {

        return dependencyGraph
                .getNode(nodeId)
                .getParentNodes();
    }

    @Override
    public List<GraphNode> getChildren(int nodeId) throws NodeNotFoundException {

        return dependencyGraph
                .getNode(nodeId)
                .getChildNodes();
    }

    @Override
    public List<GraphNode> getAncestors(int nodeId) throws NodeNotFoundException {
        GraphNode rootNode = dependencyGraph.getNode(nodeId);
        DFSUtil utility = new DFSUtil(dependencyGraph, rootNode);
        List<GraphNode> ancestors;
        ancestors = utility.getParentSubGraph();
        ancestors.remove(rootNode);
        return ancestors;
    }

    @Override
    public List<GraphNode> getDescendants(int nodeId) throws NodeNotFoundException {

        GraphNode rootNode = dependencyGraph.getNode(nodeId);
        DFSUtil utility = new DFSUtil(dependencyGraph, rootNode);
        List<GraphNode> descendants;
        descendants = utility.getChildSubGraph();
        descendants.remove(rootNode);
        return descendants;
    }

    @Override
    public void addDependency(int parentNodeId, int childNodeId) throws NodeAlreadyExistsException, NodeNotFoundException, CyclicGraphException {
        //TODO: check if it becomes cyclic
        GraphNode parentNode = dependencyGraph.getNode(parentNodeId);
        GraphNode childNode = dependencyGraph.getNode(childNodeId);
        List<GraphNode> descendents = getDescendants(childNodeId);
        if(descendents.contains(parentNode)){
            throw new CyclicGraphException("Can't add dependency, will make the graph cyclic");
        }
            parentNode.addChildNode(childNode);
            childNode.addParentNode(parentNode);

    }

    @Override
    public void addNode(GraphNode node) throws NodeAlreadyExistsException{
        if(dependencyGraph.containsNode(node.getNodeId())){
            throw new NodeAlreadyExistsException("Node already exists in dependency graph.");
        }
        dependencyGraph.addNode(node);
    }

    @Override
    public void deleteDependency(int parentNodeId, int childNodeId) throws NodeNotFoundException {
        GraphNode parentNode = dependencyGraph.getNode(parentNodeId);
        GraphNode childNode = dependencyGraph.getNode(childNodeId);
        parentNode.deleteChildNode(childNode);
    }

    @Override
    public void deleteNode(int nodeId) throws NodeNotFoundException {
        dependencyGraph.deleteNode(nodeId);
    }

    @Override
    public List<GraphNode> getAllNodes() {
        //TODO: Add empty graph exception
        return new ArrayList<>(dependencyGraph.getDependencyGraph().values());
    }

}
