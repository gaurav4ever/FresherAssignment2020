package com.nuclei.service.impl;

import com.nuclei.exception.CyclicGraphException;
import com.nuclei.exception.NodeAlreadyExistException;
import com.nuclei.exception.NodeNotFoundException;
import com.nuclei.model.GraphNode;
import com.nuclei.service.GraphService;

import com.nuclei.utils.DFSUtil;
import java.util.ArrayList;
import java.util.List;

public class DependencyGraphImplementation implements GraphService {

    @Override
    public List<GraphNode> getParents(int nodeId) throws NodeNotFoundException {
        return dependencyGraph.getNode(nodeId).getParentNodes();
    }

    @Override
    public List<GraphNode> getChildren(int nodeId) throws NodeNotFoundException {
        return dependencyGraph.getNode(nodeId).getChildNodes();
    }

    @Override
    public List<GraphNode> getAncestors(int nodeId) throws NodeNotFoundException {
        GraphNode rootNode = dependencyGraph.getNode(nodeId);
        DFSUtil dfsUtil = new DFSUtil(dependencyGraph,rootNode);
        List<GraphNode> ancestors;
        ancestors = dfsUtil.getParentSubGraph();
        //we only need ancestors so we need to remove the root node
        ancestors.remove(rootNode);
        return ancestors;
    }

    @Override
    public List<GraphNode> getDescendants(int nodeId) throws NodeNotFoundException {
        GraphNode rootNode = dependencyGraph.getNode(nodeId);
        DFSUtil dfsUtil = new DFSUtil(dependencyGraph,rootNode);
        List<GraphNode> descendants;
        descendants = dfsUtil.getChildSubGraph();
        //we only wants descendants so we need to remove the root node
        descendants.remove(rootNode);
        return descendants;
    }

    @Override
    public void addDependency(int parentId, int childId)
        throws NodeNotFoundException, NodeAlreadyExistException, CyclicGraphException {
        GraphNode parentNode = dependencyGraph.getNode(parentId);
        GraphNode childNode = dependencyGraph.getNode(childId);
        List<GraphNode> descendants = getDescendants(childId);
        if(descendants.contains(parentNode)){
            throw new CyclicGraphException("Can't add dependency, it will make the graph cyclic");
        }
        parentNode.addChildNode(childNode);
        childNode.addParentNode(parentNode);
    }

    @Override
    public void deleteDependency(int parentId, int childId) throws NodeNotFoundException {
        GraphNode parentNode = dependencyGraph.getNode(parentId);
        GraphNode childNode = dependencyGraph.getNode(childId);
        parentNode.deleteChildNode(childNode);
    }

    @Override
    public void deleteNode(int id) throws NodeNotFoundException {
        dependencyGraph.deleteNode(id);
    }

    @Override
    public void addNode(GraphNode node) throws NodeAlreadyExistException {
        if(dependencyGraph.containsKey(node.getNodeId())){
            throw new NodeAlreadyExistException("Node already exist.");
        }
        dependencyGraph.addNode(node);
    }

    @Override
    public List<GraphNode> getAllNodes() {
        List<GraphNode> allNodes = new ArrayList<GraphNode>(dependencyGraph.getGraph().values());
        return allNodes;
    }


}
