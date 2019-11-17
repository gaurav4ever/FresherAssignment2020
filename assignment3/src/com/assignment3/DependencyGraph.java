package com.assignment3;
import java.util.Scanner;


public class DependencyGraph {
	
	public void run(){
		Scanner s = new Scanner(System.in);
		Graph g = new Graph();
		int choice ;
		while(true) {
			System.out.println("------------------Menu---------------------");
			System.out.println("Please Select an option :");
			System.out.println("1. Get Immediate Parent of a node : ");
			System.out.println("2. Get Immediate Children of a node : ");
			System.out.println("3. Get Ancestors of a node : ");
			System.out.println("4. Get Descendants of a node : ");
			System.out.println("5. Delete a dependency :");
			System.out.println("6. Delete a node :");
			System.out.println("7. Add a dependency :");
			System.out.println("8. Add a Node :");
			System.out.println("9. Print the Graph : ");
			System.out.println("10. Exit");
			choice = s.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the node ID(an integer) :");
				if(g.immediateParents(s.nextInt())) {
					System.out.print("Immediate Parents are : ");
					System.out.println(g.parents);
				}
				else
					System.out.println("No Parent exists for this node!!");
				break;
			case 2:
				System.out.println("Enter the node ID(an integer) :");
				if(g.immediatechildren(s.nextInt())) {
					System.out.print("Immediate children are : ");
					System.out.println(g.children);
				}
				else
					System.out.println("No children exists for this node!!");
				break;
			case 3:
				System.out.println("Enter the node id :");
				if(g.getAncestors(s.nextInt())) {
					System.out.print("Ancestors are : ");
					System.out.println(g.ancestors);
				}
				else
					System.out.println("No Ancestors Available !");
				break;
			case 4:
				System.out.println("Enter the node id :");
				if(g.getDescendants(s.nextInt())) {
					System.out.print("Decendants are : ");
					System.out.println(g.descendants);
				}
				else
					System.out.println("No Descendants Available !");
				break;
			case 5:
				System.out.println("Enter the parent ID:");
				int pID = s.nextInt();
				System.out.println("Enter the child ID");
				int cID = s.nextInt();
				if(g.deleteDependency(pID, cID)) 
					System.out.println("Successfully Deleted!!");
				else
					System.out.println("No such dependency exists!!");
				break;
			case 6:
				System.out.println("Enter the Node ID : ");
				if(g.deleteNode(s.nextInt())) System.out.println("Successfully Deleted!!");
				else System.out.println("No such node exists");
				break;
			case 7:
				Node node1 = new Node();
				Node node2 = new Node();
				System.out.println("Enter the Parent Node ID : ");
				int parentID = s.nextInt();
				if(g.checkID(parentID) == 0) {
					System.out.println("Enter Node name as well , this Node doesn't exists:");
					node1.setNodeName(s.next());
					node1.setNodeID(parentID);
					g.addVertex(node1);
				}
				else {
					node1 = g.checkNode(parentID);
				}
				System.out.println("Enter the Child Node ID : ");
				int childID = s.nextInt();
				if(g.checkID(childID) == 0) {
					System.out.println("Enter Node name as well , this Node doesn't exists:");
					node2.setNodeName(s.next());
					node2.setNodeID(childID);
					g.addVertex(node2);
				}
				else {
					node2 = g.checkNode(childID);
				}
				g.addEdge(node1,node2);
				break;	
			case 8:
				Node node = new Node();
				while(true) {
					System.out.println("Enter the node id(an integer): ");
					int ID = s.nextInt();
					if(g.checkID(ID) == 0) {
						node.setNodeID(ID);
						break;
					}
					else System.out.println("This ID already Exists!! Please try again.");
				}
				System.out.println("Enter the node name : ");
				node.setNodeName(s.next());
				g.addVertex(node);
				break;
			case 9:
				System.out.println(g.toString()); 
				break;
			case 10:
				break;
			default:
				System.out.println("Please enter the correct option!");
			}
		}
		
	}
}