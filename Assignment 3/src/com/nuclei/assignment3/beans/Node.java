package com.nuclei.assignment3.beans;

import java.util.HashMap;
import java.util.HashSet;

import com.nuclei.assignment3.exceptions.NoNodeException;

public class Node {

	private int id;
	private String name;
	private HashMap<String, Object> addInfo;
	private HashMap<Integer, Node> parents;
	private HashMap<Integer, Node> children;
	
	public Node(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		addInfo = new HashMap<String, Object>();
		parents = new HashMap<Integer, Node>();
		children = new HashMap<Integer, Node>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Object> getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(HashMap<String, Object> addInfo) {
		this.addInfo = addInfo;
	}

	public HashMap<Integer, Node> getParents() {
		return parents;
	}

	public void setParents(HashMap<Integer, Node> parent) {
		this.parents = parent;
	}

	public HashMap<Integer, Node> getChildren() {
		return children;
	}
	
	public HashSet<Node> getChildrenValues() {
		return new HashSet<Node>(children.values());	
	}
	
	public HashSet<Node> getParentsValues() {
		return new HashSet<Node>(parents.values());
	}
	
	public void deleteParent(Integer parentId) throws NoNodeException {
        if (!parents.containsKey(parentId)) {
        	throw new NoNodeException();
        }
        parents.remove(parentId);
    }

    public void deleteChild(Integer childId) throws NoNodeException {
        if (!children.containsKey(childId)) {
        	throw new NoNodeException();
        }
        children.remove(childId);
    }
	
	public void setChildren(HashMap<Integer, Node> child) {
		this.children = child;
	}
	
	public void addParent(Node parent) {
		parents.put(parent.getId(), parent);	
	}
	
	public void addChild(Node child) {
		children.put(child.getId(), child);
	}
	
	
	public HashSet<Node> getAncestors() {
		HashSet<Node> ancestors = new HashSet<Node>();
		ancestors.addAll(this.getParentsValues());
		for(Node a : ancestors) {
			ancestors.addAll(a.getParentsValues());
		}
		return ancestors;
	}
	
	
	public HashSet<Node> getDescendants() {
		HashSet<Node> descendants = new HashSet<Node>();
		descendants.addAll(this.getChildrenValues());
		for(Node d : descendants) {
			descendants.addAll(d.getChildrenValues());
		}
		return descendants;
	}
}
