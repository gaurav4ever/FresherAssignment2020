package Assignment3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;

class Node {
	private int node_id;
	private String node_name;
	HashSet<Node> parents = null;
	HashSet<Node> children = null;
    Node() {
    	parents = new HashSet<Node>();
    	children = new HashSet<Node>();
    }
    //getter and setter methods for setting and retrieving the attributes of a node
    public void setNodeId(int node_id) {
    	this.node_id=node_id;
    }
    public void setNodeName(String node_name) {
    	this.node_name=node_name;
    }
    public int getNodeid() {
    	return this.node_id;
    }
    public String getNodeName() {
    	return this.node_name;
    }
    public void addParent(Node parent) {
    	if(this.parents.contains(parent)) {
    		System.out.println("The given node is already added as a parent!");
    	}
    	else {
    		this.parents.add(parent);
    	}
    }
    public void addChild(Node child) {
    	if(this.children.contains(child)) {
    		System.out.println("The given node is already added as a child!");
    	}
    	else {
    		this.children.add(child);
    	}
    }
    public void deleteParent(Node parent) {
    	if(this.parents.contains(parent)) {
    		this.parents.remove(parent);
    	}
    	else {
    		System.out.println("No dependency found!");
    	}
    }
    public void deleteChild(Node child) {
    	if(this.children.contains(child)) {
    		this.children.remove(child);
    	}
    	else {
    		System.out.println("No dependency found!");
    	}
    }
    
    @Override
    public String toString() {
    	return ("Node id-> "+this.getNodeid()+" Node name-> "+this.getNodeName());
    }
}

class GraphNodes {
	static private ArrayList<Node> nodeList=new ArrayList<Node>();
	public static void createNode(int node_id,String node_name) {
		Node node=new Node();
		node.setNodeId(node_id);
		node.setNodeName(node_name);
		nodeList.add(node);
	}
	public static ArrayList<Node> getNodeList() {
		return nodeList;
	}
	public static void deleteNode(int node_id) {
		Node currentNode=null;
		for(Node temp:nodeList) {
			if(temp.getNodeid()==node_id) {
				currentNode=temp;
				break;
			}
		}
		if(currentNode==null) {
			System.out.println("Invalid Node Id!");
		} else {
			nodeList.remove(currentNode);
			for(Node temp:nodeList) {
				temp.parents.remove(currentNode);
				temp.children.remove(currentNode);
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
	//recursively display the ancestors of a node
	public void displayAncestors(Node node) {
		HashSet<Node> parents=node.parents;
		if(parents==null) {
			System.out.println("There are no ancestors for the given node!");
			return;
		} else {
			System.out.println("Ancestors for the given node are:");
			for(Node p:parents) {
				System.out.println(p);
				displayAncestors(p);
			}
		}
	}
	//recursively display descendanta of a node
	public void displayDescendants(Node node) {
		HashSet<Node> children=node.children;
		if(children==null) {
			System.out.println("There are no descendants for the given node!");
			return;
		} else {
			System.out.println("Descendants for the given node are :");
			for(Node child:children) {
				System.out.println(child);
				displayDescendants(child);
			}
		}
		
	}
}
public class Assignment3 {
     static Scanner sc=new Scanner(System.in);
     //hash set to store unique node_id
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
			ArrayList<Node> nodeList=GraphNodes.getNodeList();
			Node tmpNode=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==node_id) {
					tmpNode=tmp;
				}
			}
			if(tmpNode==null) {
				System.out.println("Node id does not exist!");
			} else {
				GraphNodes graph_nodes=new GraphNodes();
				graph_nodes.displayParents(tmpNode);
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
			ArrayList<Node> nodeList=GraphNodes.getNodeList();
			Node tmpNode=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==node_id) {
					tmpNode=tmp;
				}
			}
			if(tmpNode==null) {
				System.out.println("Node id does not exist!");
			} else {
				GraphNodes graph_nodes=new GraphNodes();
				graph_nodes.displayChildren(tmpNode);
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
			ArrayList<Node> nodeList=GraphNodes.getNodeList();
			Node tmpNode=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==node_id) {
					tmpNode=tmp;
				}
			}
			if(tmpNode==null) {
				System.out.println("Node id does not exist!");
			} else {
				GraphNodes graph_nodes=new GraphNodes();
				graph_nodes.displayAncestors(tmpNode);
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
			ArrayList<Node> nodeList=GraphNodes.getNodeList();
			Node tmpNode=null;
			for(Node tmp:nodeList) {
				if(tmp.getNodeid()==node_id) {
					tmpNode=tmp;
				}
			}
			if(tmpNode==null) {
				System.out.println("Node id does not exist!");
			} else {
				GraphNodes graph_nodes=new GraphNodes();
				graph_nodes.displayDescendants(tmpNode);
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
			ArrayList<Node> nodeList=GraphNodes.getNodeList();
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
				parent_node.deleteChild(child_node);
				child_node.deleteParent(parent_node);
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
			GraphNodes graph_nodes=new GraphNodes();
			graph_nodes.deleteNode(node_id);
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
			ArrayList<Node> nodeList=GraphNodes.getNodeList();
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
				GraphNodes graph_nodes=new GraphNodes();
				graph_nodes.createNode(node_id, node_name);
				System.out.println("Node added!");
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid input type!");
		}
	}
}
	


