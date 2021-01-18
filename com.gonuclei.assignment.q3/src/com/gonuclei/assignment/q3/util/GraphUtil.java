package com.gonuclei.assignment.q3.util;

import java.util.List;
import java.util.Scanner;

import com.gonuclei.assignment.q3.exception.NodeDoesNotExistException;
import com.gonuclei.assignment.q3.graph.Graph;
import com.gonuclei.assignment.q3.graph.GraphNode;


public class GraphUtil {
	
	static Scanner sc = new Scanner(System.in);
	static Graph graph = new Graph();
	
	public static void showMenu() {
		System.out.println("------------------------Menu--------------------------");
		System.out.println("1. Get Immediate Parents of a Node");
		System.out.println("2. Get Immediate Children of a Node");
		System.out.println("3. Ancestors of a Node");
		System.out.println("4. Descendants of a Node");
		System.out.println("5. Delete a Dependency");
		System.out.println("6. Delete a Node");
		System.out.println("7. Add a New Dependency");
		System.out.println("8. Add a new Node");
		System.out.println("9. See All Nodes with Incoming and Outgoing Nodes");
		System.out.println("10. Exit");
	}
	
	static void printList(List<GraphNode> list) {
		System.out.println("[");
		for(GraphNode node: list) {
			System.out.println(" " + node.getId()+ " ");
		}
		System.out.println("]");
	}
	
	private static void performAction(int option) {
		int id;
		switch(option) {
		case 1:
			System.out.println("Enter the id:");
			List<GraphNode> immediateParents = null;
			id = sc.nextInt();
			try {
				immediateParents = graph.getImmediateParents(id);
			} catch (NodeDoesNotExistException e) {
				System.out.println("Node doesn't Exist");
			}
			if(immediateParents!=null)
			printList(immediateParents);
			break;
		case 2:
			System.out.println("Enter the id:");
			List<GraphNode> immediateChildren = null;
			id = sc.nextInt();
			try {
				immediateChildren = graph.getImmediateParents(id);
			} catch (NodeDoesNotExistException e) {
				System.out.println("Node doesn't Exist");
			}
			if(immediateChildren!=null)
			printList(immediateChildren);
			break;
		case 3:
			System.out.println("Enter the id:");
			List<GraphNode> ancestors = null;
			id = sc.nextInt();
			try {
				ancestors = graph.getAncestors(id);
			} catch (NodeDoesNotExistException e) {
				System.out.println("Node doesn't Exist");
			}
			if(ancestors!=null)
			printList(ancestors);
			break;
		case 4:
			System.out.println("Enter the id:");
			List<GraphNode> decendants = null;
			id = sc.nextInt();
			try {
				decendants = graph.getAncestors(id);
			} catch (NodeDoesNotExistException e) {
				System.out.println("Node doesn't Exist");
			}
			if(decendants!=null)
			printList(decendants);
			break;
		case 5:
			System.out.println("Enter two ids");
			int id1 = sc.nextInt();
			int id2 = sc.nextInt();
			try {
				graph.deleteDependency(id1, id2);
			} catch (NodeDoesNotExistException e) {
			}
			break;
		case 6:
			System.out.println("Enter the id");
			id = sc.nextInt();
			try {
				graph.deleteNode(id);
			} catch (NodeDoesNotExistException e) {
				System.out.println("Node does not exist");
			}
			break;
		case 7:
			System.out.println("Enter the 2 ids");
			id1 = sc.nextInt();
			id2 = sc.nextInt();
			try {
				graph.addDependency(id1, id2);
			} catch (Exception e) {
			}
			break;
		case 8:
			System.out.println("Enter the id [Integer]");
			id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the name of Node [String]");
			String name = sc.nextLine();
			graph.createNode(id, name);
			break;
		case 9:
			List<String> allNodes= graph.getAllNodes();
			for(String node: allNodes) {
				System.out.println(node);
			}
			break;
		case 10:
			break;
		default:
			System.out.println("Invalid Choice Please Try Again");
		}
	}
	
	public static void run() {
		while(true) {
			showMenu();
			int option = -1;
			try {
				option = sc.nextInt();
				performAction(option);
			} catch (Exception e) {
				System.out.println("Not an Integer");
			}
			if(option==10) break;
		}
	}
	
}

























