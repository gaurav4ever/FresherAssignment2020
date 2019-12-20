package com.gonuclei.assignment.q3.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;

import com.gonuclei.assignment.q3.exception.DependeciesAlreadyExistException;
import com.gonuclei.assignment.q3.exception.NodeDoesNotExistException;

final public class Graph {
	
	private HashMap<Integer, GraphNode> nodes = new HashMap<Integer, GraphNode>();
	
	
	
	
    public void addDependency(int nodeId1, int nodeId2) throws NodeDoesNotExistException, DependeciesAlreadyExistException{
        GraphNode firstNode = null;
        GraphNode afterNode = null;
        if (nodes.containsKey(nodeId1)) {
            firstNode = nodes.get(nodeId1);
        } else {
            throw new NodeDoesNotExistException("One of the Node Doesn't Exist");
        }
        if (nodes.containsKey(nodeId2)) {
            afterNode = nodes.get(nodeId2);
        } else {
            throw new NodeDoesNotExistException("One of the Node Doesn't Exist");
        }
        List<GraphNode> descendants = getDescendants(nodeId1);
        for(GraphNode d: descendants) {
        	if(d.getId()==(nodeId2) throw new DependeciesAlreadyExistException("Dependencies already exist. The Graph will become Cyclic!");
        }
        firstNode.addGoingOutNode(afterNode);
        afterNode.addComingInNode(firstNode);
    }

    public List<GraphNode> getImmediateParents(int nodeId) throws NodeDoesNotExistException{
    	GraphNode node = null;
    	node = nodes.get(nodeId);
    	if(Objects.isNull(node)) return node.getComingInNodes();
    	else throw new NodeDoesNotExistException();
    }
    
    public List<GraphNode> getImmediateChildren(int nodeId) throws NodeDoesNotExistException{
    	GraphNode node = null;
    	node = nodes.get(nodeId);
    	if(node!=null) return node.getGoingOutNodes();
    	else throw new NodeDoesNotExistException();
    }
    
    public List<GraphNode> getAncestors(int nodeId) throws NodeDoesNotExistException{
    	GraphNode node = null;
    	List<GraphNode> ancestors = new ArrayList<>();;
    	node = nodes.get(nodeId);
    	if(node==null) throw new NodeDoesNotExistException(); 
    	Queue<GraphNode> q = new LinkedList<>();
    	q.add(node);
    	while(!q.isEmpty()){
    		GraphNode tempNode = q.peek(); 
    		q.remove();
    		if(tempNode.getComingInNodes().size()!=0) {
    			ancestors.addAll(tempNode.getComingInNodes());
    			q.addAll(tempNode.getComingInNodes());
    		}
    	}
    	return ancestors;
    }
    
    public List<GraphNode> getDescendants(int nodeId) throws NodeDoesNotExistException{
    	GraphNode node = null;
    	List<GraphNode> descendants = new ArrayList<>();;
    	node = nodes.get(nodeId);
    	if(node==null) throw new NodeDoesNotExistException(); 
    	Queue<GraphNode> q = new LinkedList<>();
    	q.add(node);
    	while(!q.isEmpty()){
    		GraphNode tempNode = q.peek(); 
    		q.remove();
    		if(tempNode.getGoingOutNodes().size()!=0) {
    			descendants.addAll(tempNode.getGoingOutNodes());
    			q.addAll(tempNode.getGoingOutNodes());
    		}
    	}
    	return descendants;
    }
    
    public void deleteDependency(int nodeId1, int nodeId2) throws NodeDoesNotExistException{
    	GraphNode node1 = null;
    	node1 = nodes.get(nodeId1);
    	GraphNode node2 = null;
    	node2 =	nodes.get(nodeId2);
    	if(node1==null || node2 ==null) throw new NodeDoesNotExistException("Either of a node Doesn't Exist");
    	node1.getGoingOutNodes().remove(nodeId2);
    	node2.getComingInNodes().remove(nodeId1);
    }
    
    public GraphNode createNode(int id, String name) {
        GraphNode node = new GraphNode();
        node.name = name;
        node.id = id;
        nodes.put(id, node);
        return node;
    }
    
    public void deleteNode(int nodeId) throws NodeDoesNotExistException{
    	GraphNode node = null;
    	node = nodes.get(nodeId);
    	if(node==null) throw new NodeDoesNotExistException();
    	else {
    		for(Integer key: nodes.keySet()) {
    			GraphNode tempNode = nodes.get(key);
    			
    			List<GraphNode> comingInNodes = tempNode.getComingInNodes();
    			if(comingInNodes!=null && comingInNodes.contains(node)) comingInNodes.remove(node);
    			tempNode.setComingInNodes(comingInNodes);
    			
    			List<GraphNode> goingOutNodes = tempNode.getGoingOutNodes();
    			if(goingOutNodes!=null &&  goingOutNodes.contains(node)) goingOutNodes.remove(node);
    			tempNode.setComingInNodes(goingOutNodes);
    		}
    		nodes.remove(nodeId, node);
    	}
    }
    
    public List<String> getAllNodes(){
		 List<String> allNodes = new ArrayList<>();
	   	 nodes.entrySet().forEach(entry->{
	   		    allNodes.add(entry.getKey() + "  [" + getListString(entry.getValue().getComingInNodes()) + "]   ["
	   		    		+ getListString(entry.getValue().getGoingOutNodes()) + "]");  
	   		 });
	   	 return allNodes;
	    }
	   
	    public String getListString(List<GraphNode> list){
	    	StringJoiner joiner = new StringJoiner(",");
	    	for (GraphNode item : list) {
	    		joiner.add(item.getName().toString());
	    	}
	    	return joiner.toString();
	    }
	   
  
	/*
	 * private List<GraphNode> getOrphanNodes() { List<GraphNode> orphanNodes =
	 * null; for (Integer key : nodes.keySet()) { GraphNode node = nodes.get(key);
	 * if (node.getComingInNodes() == null) { if (orphanNodes == null) orphanNodes =
	 * new ArrayList<GraphNode>(); orphanNodes.add(node); } } return orphanNodes; }
	 */
}
