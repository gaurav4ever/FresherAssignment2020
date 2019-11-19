package asgn.model;

import java.util.ArrayList;

public class Node {
	private int nodeId;
	private String nodeName;
	private ArrayList<Node> parentNodes;
	private ArrayList<Node> childNodes;

	public Node(int nodeId, String nodeName, ArrayList<Node> parentNodes, ArrayList<Node> childNodes) {
		this.nodeId = nodeId;
		this.nodeName = nodeName;
		this.parentNodes = parentNodes;
		this.childNodes = childNodes;
	}

	public Node() {
	}

	public Node(int id, String name) {
		this.nodeId = id;
		this.nodeName = name;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeID(int nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public ArrayList<Node> getParentNodes() {
		return parentNodes;
	}

	public void setParentNodes(ArrayList<Node> parentNodes) {
		this.parentNodes = parentNodes;
	}

	public ArrayList<Node> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(ArrayList<Node> childNodes) {
		this.childNodes = childNodes;
	}
}
