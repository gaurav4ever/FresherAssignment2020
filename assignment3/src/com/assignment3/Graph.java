package com.assignment3;
import java.util.*;

public class Graph{
	public Map<Node, List<Node> > map = new HashMap<>(); 
	ArrayList<String> parents = null;
	ArrayList<String> children = null;
	ArrayList<String> descendants = null;
	ArrayList<String> ancestors = null;
	// To get Immediate Parents of a node
	public boolean immediateParents(int ID) {
		parents = new ArrayList<>();
		int flag = 1;
		for (Node v : map.keySet()) {       
            for (Node w : map.get(v)) { 
               if(w.getNodeID() == ID) {
            	   parents.add(v.getNodeName());
            	   flag = 0;
               }
            } 
        } 
		if(flag == 0) return true;
		else return false;
	}
	public boolean immediatechildren(int ID) {
		
		children = new ArrayList<>();
		int flag = 1;
		for (Node v : map.keySet()) {    
			 if(v.getNodeID() == ID) {
				 for (Node w : map.get(v)) { 
	            	   children.add(w.getNodeName());
				 }
				 flag = 0;
            } 
        } 
		if(flag == 0) return true;
		else return false;
	}
	public boolean deleteDependency(int pID, int cID) {
		int flag = 1;
		for (Node v : map.keySet()) {    
			 if(v.getNodeID() == pID) {
				 for (Node w : map.get(v)) { 
	            	   if(w.getNodeID() == cID) {
	            		   map.get(v).remove(w); 
	            		   flag = 0;
	            	   }
				 }
           } 
       } 
		if(flag == 0) return true;
		else return false;
	}
	public boolean deleteNode(int ID) {
		int flag = 1;
		Node dNode = new Node();
		for (Node v : map.keySet()) {    
			 for (Node w : map.get(v)) { 
        	   if(w.getNodeID() == ID) {
        		   map.get(v).remove(w); 
        		   flag = 0;
        	   }
           } 
       } 
		for (Node v : map.keySet()) {    
       	   if(v.getNodeID() == ID) { 
       		   dNode = v;
       		   break;
       	   } 
      } 
		map.remove(dNode);
		if(flag == 0) return true;
		else return false;
	}
	public boolean getDescendants(int ID) {
		int flag = 1;
		descendants = new ArrayList();
		List<Node> temp = new ArrayList<Node>();
		for(Node v : map.keySet()) {
			if(v.getNodeID() == ID) {
				temp.addAll(map.get(v));
			}
		}
		for (int i = 0; i < temp.size(); i++) {
			descendants.add(temp.get(i).getNodeName());
			flag = 0;
			for(Node w : map.get(temp.get(i))) {
				temp.add(w);
			}
		}
		if(flag==0) return true;
		else return false;
	}
	public int parent(int ID) {
		int flag = 1;
		int id = -1;
		for (Node v : map.keySet()) {       
            for (Node w : map.get(v)) { 
               if(w.getNodeID() == ID) {
            	   ancestors.add(v.getNodeName());
            	   id = v.getNodeID();
            	   flag = 0;
            	   break;
               }
            } 
        } 
		if(flag == 0) return id;
		else return -1;
	}
	public boolean getAncestors(int ID) {
		ancestors = new ArrayList<String>();
		int flag = 1;
		int id = ID;
		while(true) {
			if(id == -1) {
				break;
			}
			else {
				id = parent(id);
				flag = 0;
			}
		}
		if(flag==0) return true;
		else return false;
		
	}
	public int checkID(int ID) {
		int flag = 0;
		for (Node v : map.keySet()) {  
                if(v.getNodeID() == ID )
                	flag = 1;
        }
		if(flag == 1) return 1;
		else return 0;
	}
	public Node checkNode(int ID) {
		Node node = new Node();
		for (Node v : map.keySet()) {  
                if(v.getNodeID() == ID)
                	node = v;
        }
		return node;
	}
	public void addVertex(Node s){
			map.put(s, new LinkedList<Node>()); 
    } 
	public void addEdge(Node source,Node destination){ 
		if (checkID(source.getNodeID()) == 0)
			addVertex(source); 
		
		if (checkID(destination.getNodeID()) == 0)
			addVertex(destination); 
		
		map.get(source).add(destination); 
	}
	@Override
	public String toString(){ 
        StringBuilder builder = new StringBuilder(); 
        for (Node v : map.keySet()) { 
            builder.append(v.getNodeName() + ": "); 
            for (Node w : map.get(v)) { 
                builder.append(w.getNodeName() + " "); 
            } 
            builder.append("\n"); 
        } 
  
        return (builder.toString()); 
    } 
}
