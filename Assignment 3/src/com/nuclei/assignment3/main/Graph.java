package com.nuclei.assignment3.main;

import java.util.HashMap;
import java.util.HashSet;

import com.nuclei.assignment3.beans.Node;
import com.nuclei.assignment3.exceptions.CyclicDependencyException;
import com.nuclei.assignment3.exceptions.NoNodeException;
import com.nuclei.assignment3.exceptions.NodeExistsException;

public class Graph {
	
	private HashMap<Integer, Node> rootId;
	private Node root;
	
	public Graph(Node root) {
		super();
		this.root = root;
		rootId = new HashMap<Integer, Node>();
		rootId.put(root.getId(), root);
	}

	public HashMap<Integer, Node> getNodeMapId() {
		return rootId;
	}

	public void setNodeMapId(HashMap<Integer, Node> nodeMapId) {
		this.rootId = nodeMapId;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public HashSet<Node> getParents(int nodeId) throws NoNodeException {
        if (!rootId.containsKey(nodeId)) {
        	throw new NoNodeException();
        }
        return rootId.get(nodeId).getParentsValues();
    }

    public HashSet<Node> getChildren(int nodeId) throws NoNodeException {
        if (!rootId.containsKey(nodeId)) {
        	throw new NoNodeException();
        }
        return rootId.get(nodeId).getChildrenValues();
    }

    public HashSet<Node> getAncestors(Integer nodeId) throws NoNodeException {
        if (!rootId.containsKey(nodeId)) {
        	throw new NoNodeException();
        }
        return rootId.get(nodeId).getAncestors();
    }

    public HashSet<Node> getDescendants(Integer nodeId) throws NoNodeException {
        if (!rootId.containsKey(nodeId)) {
        	throw new NoNodeException();
        }
        return rootId.get(nodeId).getDescendants();
    }
	
	public void addDependency(int pNodeId, int cNodeId) throws NoNodeException, CyclicDependencyException {
        if (!rootId.containsKey(pNodeId)) {
        	throw new NoNodeException();
        }
        if (!rootId.containsKey(cNodeId)) {
        	throw new NoNodeException();
        }

        Node child = rootId.get(cNodeId);
        Node parent = rootId.get(pNodeId);
        if (child.getDescendants().contains(parent)) {
        	throw new CyclicDependencyException();
        }
        if (parent.getAncestors().contains(child)) {
        	throw new CyclicDependencyException();
        }
        rootId.get(pNodeId).addChild(rootId.get(cNodeId));
        rootId.get(cNodeId).addParent(rootId.get(pNodeId));
	}
	
	public void removeDependency(int pNodeId, int cNodeId) throws NoNodeException {
		if (!rootId.containsKey(pNodeId)) {
        	throw new NoNodeException();
        }
        if (!rootId.containsKey(cNodeId)) {
        	throw new NoNodeException();
        }
        
        rootId.get(pNodeId).deleteChild(cNodeId);
        rootId.get(cNodeId).deleteParent(pNodeId);
	}
	
	public void addNode(int nodeId, String name) throws NodeExistsException {
        if (rootId.containsKey(nodeId)) {
            throw new NodeExistsException();
        }
        rootId.put(nodeId, new Node(nodeId, name));
    }
	
	public void deleteNode(int nodeId) throws NoNodeException {
		if (!rootId.containsKey(nodeId)) {
        	throw new NoNodeException();
        }
		
		HashSet<Node> children = rootId.get(nodeId).getChildrenValues();
		HashSet<Node> parents = rootId.get(nodeId).getParentsValues();
		
		for(Node p : parents) {
			p.deleteChild(nodeId);
		}
		
		for(Node c : children) {
			c.deleteParent(nodeId);
		}
		
		rootId.remove(nodeId);
	}
}
