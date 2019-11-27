package asgn3;

import asgn3.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class DependencyGraph {
	ArrayList<String> parents =null;
	ArrayList<String> descendants =null;
	ArrayList<String> ancestors =null;
	ArrayList<String> children =null;
	public Map<Node, List<Node>> map = new HashMap<>();
	
	public boolean getParents(int id) {
		parents = new ArrayList<>();
		boolean flag=true;
		for(Node x: map.keySet()) {
			for(Node y: map.get(x)) {
				if( y.getNodeId()==id ) {
					parents.add(x.getNodeName());
					flag=false;
				}
			}
		}
		if(flag != true) 
			return true;
		else
			return false;	
	}
	
	public boolean getChildren(int id) {
		children = new ArrayList<>();
		boolean flag=true;
		for(Node x: map.keySet()) {
			for(Node y: map.get(x)) {
				if( y.getNodeId()==id ) {
					children.add(x.getNodeName());
					flag=false;
				}
			}
		}
		if(flag != true) 
			return true;
		else
			return false;	
	}
	
	public boolean deleteDependency(int pid, int cid) {
		boolean flag=true;
		for(Node x: map.keySet()) {
		  if(x.getNodeId() == pid) {
			for(Node y: map.get(x)) {
				if( y.getNodeId()==cid ) {
					map.get(x).remove(y);
					flag=false;
				}
			}
		}
		}
		if(flag != true) 
			return true;
		else
			return false;	
	}
	
	public boolean deleteNode(int id) {
		boolean flag=true;
		Node n = new Node();
		for(Node x: map.keySet()) {
			for(Node y: map.get(x)) {
				if( y.getNodeId()==id ) {
					map.get(x).remove(y);
					flag=false;
				}
			}
		}
		for (Node x: map.keySet()) {
			if(x.getNodeId() == id) {
				n=x;
				break;
			}
		}
		map.remove(n);
		if(flag != true) 
			return true;
		else
			return false;	
	}
	
	public boolean getDescendants(int id) {
		boolean flag = true;
		descendants = new ArrayList();
		ArrayList<Node> temp = new ArrayList<Node>();
		for(Node x : map.keySet()) {
			if(x.getNodeId() == id) {
				temp.addAll(map.get(x));
			}
		}
		for (int i = 0; i < temp.size(); i++) {
			descendants.add(temp.get(i).getNodeName());
			flag = false;
			for(Node y : map.get(temp.get(i))) {
				temp.add(y);
			}
		}
		if(flag==false) return true;
		else return false;
	}
	
	public int parent(int id) {
		boolean flag = true;
		int ID = -1;
		for (Node x : map.keySet()) {       
            for (Node y : map.get(x)) { 
               if(y.getNodeId() == id) {
            	   ancestors.add(x.getNodeName());
            	   ID = x.getNodeId();
            	   flag = false;
            	   break;
               }
            } 
        } 
		if(flag == false) return ID;
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
	
	public int checkId(int ID) {
		int flag = 0;
		for (Node v : map.keySet()) {  
                if(v.getNodeId() == ID )
                	flag = 1;
        }
		if(flag == 1) return 1;
		else return 0;
	}
	
	public Node checkNode(int ID) {
		Node node = new Node();
		for (Node v : map.keySet()) {  
                if(v.getNodeId() == ID)
                	node = v;
        }
		return node;
	}
	public void addVertex(Node s){
			map.put(s, new LinkedList<Node>()); 
    } 
	public void addEdge(Node source,Node destination){ 
		if (checkId(source.getNodeId()) == 0)
			addVertex(source); 

		if (checkId(destination.getNodeId()) == 0)
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


	