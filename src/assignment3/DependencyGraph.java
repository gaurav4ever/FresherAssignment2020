package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import assignment3.Exceptions.CyclicDependencyException;
import assignment3.Exceptions.DependencyNotFoundException;
import assignment3.Exceptions.NodeAlreadyExistsException;
import assignment3.Exceptions.NodeNotFoundException;

public class DependencyGraph {
	HashMap<Integer,Node> graph_nodes = new HashMap<Integer,Node>();
	
	
	public void addNode(int id, String name, HashMap<String,String> additional_info) throws NodeAlreadyExistsException {
		if(graph_nodes.containsKey(id)) {
			throw new NodeAlreadyExistsException(id);
		}
		Node node = new Node();
		node.setId(id);
		node.setName(name);
		node.setAdditional_info(additional_info);
		graph_nodes.put(id, node);
	}
	
	public void addDependency(int parentId, int childId) throws NodeNotFoundException,CyclicDependencyException {
		if(!graph_nodes.containsKey(parentId)||!graph_nodes.containsKey(childId)) {
			throw new NodeNotFoundException();
		}
		if(getAncestors(parentId).contains(childId) || getChildren(childId).contains(parentId) || parentId == childId) {
			throw new CyclicDependencyException();
		}
		graph_nodes.get(parentId).addChild(graph_nodes.get(childId));
		graph_nodes.get(childId).addParent(graph_nodes.get(parentId));
	}
	
	public void deleteDependency(int parentId, int childId) throws DependencyNotFoundException, NodeNotFoundException {
		if(!graph_nodes.containsKey(parentId)||!graph_nodes.containsKey(childId)) {
			throw new NodeNotFoundException();
		}
		if(!getParents(childId).contains(parentId) || parentId == childId) {
			throw new DependencyNotFoundException();
		}
		graph_nodes.get(parentId).removeChild(graph_nodes.get(childId));
		graph_nodes.get(childId).removeChild(graph_nodes.get(parentId));
	}
	
	public void deleteNode(int id) throws NodeNotFoundException {
		if(!graph_nodes.containsKey(id)) {
			throw new NodeNotFoundException();
		}
		Node node = graph_nodes.get(id);
		ArrayList<Node> parents = node.getParents();
		for(Node parent:parents) {
			parent.removeChild(node);
		}
		ArrayList<Node> children = node.getChildren();
		for(Node child:children) {
			child.removeParent(node);
		}
		graph_nodes.remove(id);
	}
	
	public ArrayList<Integer> getParents(int id) throws NodeNotFoundException {
		ArrayList<Integer> parents = new ArrayList<Integer>();
		if(!graph_nodes.containsKey(id)) {
			throw new NodeNotFoundException();
		}
		for(Node parent: graph_nodes.get(id).getParents()) {
			parents.add(parent.getId());
		}
		return parents;
	}
	
	public ArrayList<Integer> getChildren(int id) throws NodeNotFoundException {
		ArrayList<Integer> children = new ArrayList<Integer>();
		if(!graph_nodes.containsKey(id)) {
			throw new NodeNotFoundException();
		}
		for(Node child: graph_nodes.get(id).getChildren()) {
			children.add(child.getId());
		}
		return children;
	}
	
	public ArrayList<Integer> getAncestors(int id) throws NodeNotFoundException {
		Node node = graph_nodes.get(id);
		if(node == null) {
			throw new NodeNotFoundException();
		}
		ArrayList<Integer> ancestors = new ArrayList<Integer>();
		if(node.getParents().size()!=0) {
			for(Node parent: node.getParents()) {
				ancestors.add(parent.getId());
				ancestors.addAll(getAncestors(parent.getId()));
			}
		}
		Collections.sort(ancestors);
		return ancestors;
	}
	
	public ArrayList<Integer> getDescendents(int id) throws NodeNotFoundException {
		Node node = graph_nodes.get(id);
		if(node == null) {
			throw new NodeNotFoundException();
		}
		ArrayList<Integer> descendents = new ArrayList<Integer>();
		if(node.getChildren().size()!=0) {
			for(Node child: node.getChildren()) {
				descendents.add(child.getId());
				descendents.addAll(getDescendents(child.getId()));
			}
		}
		Collections.sort(descendents);
		return descendents;
	}
}
