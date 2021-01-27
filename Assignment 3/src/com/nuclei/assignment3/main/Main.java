package com.nuclei.assignment3.main;

import java.util.Scanner;

import com.nuclei.assignment3.beans.Node;
import com.nuclei.assignment3.exceptions.CyclicDependencyException;
import com.nuclei.assignment3.exceptions.NoNodeException;
import com.nuclei.assignment3.exceptions.NodeExistsException;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int choice;
		int nodeId;
		int pNodeId, cNodeId;
		Graph tree = new Graph(new Node(0,"root"));
		while(true) {
			System.out.println("1. Get Immediate parents of a node\n 2. Get immediate children of a node\n 3. Get ancestors of a node\n 4. Get descendants of anode\n 5. Delete dependency from the tree\n 6. Delete node from the tree\n 7. Add a new dependency to the tree\n 8. Add a new node to the tree");
			choice = sc.nextInt();
			switch(choice) {
			case 1: //Immediate parent;
					System.out.println("Enter node id");
					nodeId = sc.nextInt();
					System.out.println("Parents: ");
					try {
						for(Node n : tree.getParents(nodeId)) {
							System.out.println(n.getId()+" "+n.getName());
						}
					} catch (NoNodeException e) {
						
					}
					break;
			case 2: // Immediate children
					System.out.println("Enter node id");
					nodeId = sc.nextInt();
					System.out.println("Children");
					try {
						for(Node n : tree.getChildren(nodeId)) {
							System.out.println(n.getId()+" "+n.getName());
						}
					} catch (NoNodeException e) {
						
					}
					break;
			case 3: //Get ancestors
					System.out.println("Enter node id");
					nodeId = sc.nextInt();
					System.out.println("Ancestors: ");
					try {
						for(Node n : tree.getAncestors(nodeId)) {
							System.out.println(n.getId()+" "+n.getName());
						}
					} catch (NoNodeException e) {
						
					}
					break;
			case 4: //Get descendants
					System.out.println("Enter node id");
					nodeId = sc.nextInt();
					System.out.println("Descendants: ");
					try {
						for(Node n : tree.getDescendants(nodeId)) {
							System.out.println(n.getId()+" "+n.getName());
						}
					} catch (NoNodeException e) {
						
					}
					break;
			case 5: //Delete dependency
					System.out.println("Enter parent node id");
					pNodeId = sc.nextInt();
					System.out.println("Enter child node id");
					cNodeId = sc.nextInt();
					try {
						tree.removeDependency(pNodeId, cNodeId);
					} catch (NoNodeException e) {
						
					}
					System.out.println("Dependency removed");
					break;
			case 6:	//Delete Node
					System.out.println("Enter node id");
					nodeId = sc.nextInt();
					try {
						tree.deleteNode(nodeId);
					} catch (NoNodeException e) {
						
					}
					System.out.println("Node deleted");
					break;
			case 7: //Add dependency
					System.out.println("Enter parent node id");
					pNodeId = sc.nextInt();
					System.out.println("Enter child node id");
					cNodeId = sc.nextInt();
					try {
						tree.addDependency(pNodeId, cNodeId);
					} catch (NoNodeException | CyclicDependencyException e) {
						
					}
					System.out.println("Dependency added");
					break;
			case 8:	//Add node
					System.out.println("Enter node id");
					nodeId = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter node name");
					String nName = sc.nextLine();
					try {
						tree.addNode(nodeId, nName);
					} catch (NodeExistsException e) {
						
					}
					System.out.println("Node added");
					break;
			default: System.out.println("Enter valid option");
			}
		}
	}
}
