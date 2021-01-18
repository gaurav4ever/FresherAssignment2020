package Question3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

class Node {
	private int node_id;
	private String node_name;
	LinkedHashSet<Node> parents = null;
	LinkedHashSet<Node> children = null;
    Node(int node_id,String node_name) {
    	this.node_id = node_id;
    	this.node_name = node_name;
    	parents = new LinkedHashSet<Node>();
    	children = new LinkedHashSet<Node>();
    }
    public int getNodeid() {
    	return this.node_id;
    }
    public String getNodeName() {
    	return this.node_name;
    }
    public void addParent(Node parent) {
    	if(this.parents.contains(parent)) {
    		System.out.println("Already a parent!");
    	}
    	else {
    		this.parents.add(parent);
    	}
    }
    public void addChild(Node child) {
    	if(this.children.contains(child)) {
    		System.out.println("Already a child!");
    	}
    	else {
    		this.children.add(child);
    	}
    }
    public void removeParent(Node parent) {
    	if(this.parents.contains(parent)) {
    		this.parents.remove(parent);
    	}
    	else {
    		System.out.println("Dependency not present!");
    	}
    }
    public void removeChild(Node child) {
    	if(this.children.contains(child)) {
    		this.children.remove(child);
    	}
    	else {
    		System.out.println("Dependency not present!");
    	}
    }
    //override toString() method to display node details
    @Override
    public String toString() {
    	return ("Node id-> "+this.getNodeid()+" Node name-> "+this.getNodeName());
    }
}

class DAG {
	static private ArrayList<Node> nodeList=new ArrayList<Node>();
	public static void createNode(int node_id,String node_name) {
		Node node=new Node(node_id,node_name);
		nodeList.add(node);
	}
	public static ArrayList<Node> getNodeList() {
		return nodeList;
	}
	public static void deleteNode(int node_id) {
		Node currNode=null;
		for(Node temp:nodeList) {
			if(temp.getNodeid()==node_id) {
				currNode=temp;
				break;
			}
		}
		//if no such node present
		if(currNode==null) {
			System.out.println("Invalid Node Id!");
		} else {
			nodeList.remove(currNode);
			for(Node temp:nodeList) {
				temp.parents.remove(currNode);
				temp.children.remove(currNode);
			}
			System.out.println("Node with "+node_id+" deleted!");
		}
	}
	public void displayParents(Node node) {
		System.out.println("The parents of the node are ");
		for(Node parent:node.parents) {
			System.out.println(parent);
		}
	}
	public void displayChildren(Node node) {
		System.out.println("The children of the node are ");
		for(Node child:node.children) {
			System.out.println(child);
		}
	}
	public void displayAncestors(Node node) {
		LinkedHashSet<Node> parents=node.parents;
		if(parents==null) {
			System.out.println("No ancestors for the given node!");
			return;
		} else {
			System.out.println("Ancestors for the given node are:");
			for(Node p:parents) {
				System.out.println(p);
				//recursively display all the parents of each node
				displayAncestors(p);
			}
		}
	}
	public void displayDescendants(Node node) {
		LinkedHashSet<Node> children=node.children;
		if(children==null) {
			System.out.println("No children for the given node!");
			return;
		} else {
			System.out.println("Children for the given node are :");
			for(Node child:children) {
				System.out.println(child);
				//recursively display all the children of each node
				displayDescendants(child);
			}
		}
		
	}
}
public class Solution3 {
     static Scanner sc=new Scanner(System.in);
     static HashSet<Integer> uniqueId=new HashSet<Integer>();
	public static void main(String[] args) {
		int choice=0;
		while(choice!=9) {
			System.out.println("--MENU--");
			System.out.println("1. Get Immediate Parents of a node");
			System.out.println("2. Get Immediate Chidren of a node");
			System.out.println("3. Get ancestors of a node");
			System.out.println("4. Get descendants of a node");
			System.out.println("5. Delete dependency from a tree");
			System.out.println("6. Delete a node from a tree");
			System.out.println("7. Add dependency to a tree");
			System.out.println("8. Add node to a tree");
			System.out.println("9. Exit");
			System.out.println("Select your option");
			try {
				choice = Integer.parseInt(sc.next());
		} catch(NumberFormatException e) {
			System.out.println("Invalid choice!");
		}
	    switch(choice) {
	    case 1:getParents();
	           break;
	    case 2:getChildren();
	           break;
	    case 3:getAncestors();
	           break;
	    case 4:getDescendants();
	           break;
	    case 5:delDependency();
	           break;
	    case 6:delNode();
	           break;
	    case 7:addDependency();
	           break;
	    case 8:addNode();
	           break;
	    case 9:System.exit(0);
	           break;
	    default:System.out.println("Invalid choice!");
	    }
	  }
	}
	static void getParents() {
		System.out.println("Enter node id");
		int node_id=0;
		try {
			node_id=Integer.parseInt(sc.next());
			ArrayList<Node> nodeList=DAG.getNodeList();
			Node tmpNode=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==node_id) {
					tmpNode=tmp;
				}
			}
			//if no such node present
			if(tmpNode==null) {
				System.out.println("Node id does not exist!");
			} else {
				DAG dag=new DAG();
				dag.displayParents(tmpNode);
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid input!");
			}
		}
	static void getChildren() {
		System.out.println("Enter node id");
		int node_id=0;
		try {
			node_id=Integer.parseInt(sc.next());
			ArrayList<Node> nodeList=DAG.getNodeList();
			Node tmpNode=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==node_id) {
					tmpNode=tmp;
				}
			}
			//if no such node present
			if(tmpNode==null) {
				System.out.println("Node id does not exist!");
			} else {
				DAG dag=new DAG();
				dag.displayChildren(tmpNode);
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid input!");
			}
		}
	static void getAncestors() {
		System.out.println("Enter node id");
		int node_id=0;
		try {
			node_id=Integer.parseInt(sc.next());
			ArrayList<Node> nodeList=DAG.getNodeList();
			Node tmpNode=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==node_id) {
					tmpNode=tmp;
				}
			}
			//if no such node present
			if(tmpNode==null) {
				System.out.println("Node id does not exist!");
			} else {
				DAG dag=new DAG();
				dag.displayAncestors(tmpNode);
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid input!");
			}
		}
	static void getDescendants() {
		System.out.println("Enter node id");
		int node_id=0;
		try {
			node_id=Integer.parseInt(sc.next());
			ArrayList<Node> nodeList=DAG.getNodeList();
			Node tmpNode=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==node_id) {
					tmpNode=tmp;
				}
			}
			//if no such node present
			if(tmpNode==null) {
				System.out.println("Node id does not exist!");
			} else {
				DAG dag=new DAG();
				dag.displayDescendants(tmpNode);
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid input!");
			}
		}
	static void delDependency() {
		System.out.println("Enter parent node_id");
		try {
			int parent_id=Integer.parseInt(sc.next());
			System.out.println("Enter child node_id");
			int child_id=Integer.parseInt(sc.next());
			ArrayList<Node> nodeList=DAG.getNodeList();
			Node parent_node=null;
			Node child_node=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==parent_id) {
					parent_node=tmp;
				}
				if(tmp.getNodeid()==child_id) {
					child_node=tmp;
				}
			}
			if(parent_node==null || child_node==null) {
				System.out.println("Invalid Node id!");
			}
			else {
				//removing the dependency between two nodes
				parent_node.removeChild(child_node);
				child_node.removeParent(parent_node);
				System.out.println("Dependency removed ");
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid input type!");
		}
	}
	static void delNode() {
		System.out.println("Enter node id of node to be deleted");
		try {
			int node_id=Integer.parseInt(sc.next());
			DAG dag=new DAG();
			dag.deleteNode(node_id);
		} catch(NumberFormatException e) {
			System.out.println("Invalid Input type!");
		}
	}
	static void addDependency() {
		System.out.println("Enter parent node_id");
		try {
			int parent_id=Integer.parseInt(sc.next());
			System.out.println("Enter child node_id");
			int child_id=Integer.parseInt(sc.next());
			ArrayList<Node> nodeList=DAG.getNodeList();
			Node parent_node=null;
			Node child_node=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==parent_id) {
					parent_node=tmp;
				}
				if(tmp.getNodeid()==child_id) {
					child_node=tmp;
				}
			}
			if(parent_node==null || child_node==null) {
				System.out.println("Invalid Node id!");
			}
			else {
				//adding dependency between two nodes
				parent_node.addChild(child_node);
				child_node.addParent(parent_node);
				System.out.println("Dependency added ");
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid input type!");
		}
	}
	static void addNode() {
		System.out.println("Enter node_id");
		try {
			int node_id=Integer.parseInt(sc.next());
			if(uniqueId.contains(node_id)) {
				System.out.println("Unique Id is required!");
			} else {
				uniqueId.add(node_id);
				System.out.println("Enter node name!");
				String node_name=sc.next();
				DAG dag=new DAG();
				dag.createNode(node_id, node_name);
				System.out.println("Node added!");
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid input type!");
		}
	}
}
	


