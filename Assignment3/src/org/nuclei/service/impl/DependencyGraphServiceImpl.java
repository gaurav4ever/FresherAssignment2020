package org.nuclei.service.impl;

import org.nuclei.exception.NodeAlreadyExistsException;
import org.nuclei.exception.NodeNotFoundException;
import org.nuclei.model.GraphNode;
import org.nuclei.service.GraphService;

import java.util.List;

public class DependencyGraphServiceImpl implements GraphService {

    public DependencyGraphServiceImpl(){

    }

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
    public void getAncestors(int nodeId) {
        //TODO: Implement functionality
    }

    @Override
    public void getDescendants(int nodeId) {
        //TODO: Implement functionality
    }

    @Override
    public void addDependency(int parentNodeId, int childNodeId) throws NodeAlreadyExistsException, NodeNotFoundException {
        //TODO: check if it becomes cyclic
        GraphNode parentNode = dependencyGraph.getNode(parentNodeId);
        GraphNode childNode = dependencyGraph.getNode(childNodeId);
        parentNode.addChildNode(childNode);
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

}
