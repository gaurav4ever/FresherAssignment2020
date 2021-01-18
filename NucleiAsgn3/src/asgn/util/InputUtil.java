package asgn.util;

import java.util.Scanner;
import java.util.Set;

import asgn.GraphOperation;

public class InputUtil {

	static Scanner sc = new Scanner(System.in);

	public static void getInput() {
		while (true) {
			showMenu();
		}
	}

	public static void showMenu() {
		System.out.println("\nChoose from the given menu\n");
		System.out.println("1 Get Immediate Parents of a Node");
		System.out.println("2 Get Immediate Children of a Node");
		System.out.println("3 Get Ancestors of a Node");
		System.out.println("4 Get Descendants of a Node");
		System.out.println("5 Delete a Dependency");
		System.out.println("6 Delete a Node");
		System.out.println("7 Add a New Dependency");
		System.out.println("8 Add a new Node");
		System.out.println("9 Print Nodes with parents and children Nodes");
		System.out.println("10 Exit");
		getChoice();
	}

	private static void getChoice() {
		int choice = sc.nextInt();
		performAction(choice);
	}

	private static void performAction(int choice) {
		switch (choice) {
		case 1:
			System.out.println("Enter the node id in Integer to get immediate parents of the node");
			int nodeForImmediateParents = sc.nextInt();
			if (GraphOperation.getImmediateParents(nodeForImmediateParents)) {
				System.out.println("No immediate parents available");
			}
			break;

		case 2:
			System.out.println("Enter the node id in Integer to get immediate child of the node");
			int nodeForImmediateChildren = sc.nextInt();
			if (GraphOperation.getImmediateChildren(nodeForImmediateChildren)) {
				System.out.println("No immediate children available");
			}
			break;

		case 3:
			System.out.println("Enter the node id in Integer to get ancestors");
			int anode = sc.nextInt();
			Set<Integer> ancestors = GraphOperation.getAncestors(anode);
			if (ancestors != null) {
				System.out.println("Ancestors : ");
				for (Integer n : ancestors) {
					System.out.println(" " + n + " ");
				}
			}
			break;

		case 4:
			System.out.println("Enter the node id in Integer to get decendants");
			int dnode = sc.nextInt();

			Set<Integer> decendants = GraphOperation.getDescendants(dnode);
			if (decendants != null) {
				System.out.println("Decendants : ");
				for (Integer n : decendants) {
					System.out.println(" " + n + " ");
				}
			}
			break;

		case 5:
			System.out.println("Enter the child node id in Integer");
			int deleteChildId = sc.nextInt();
			System.out.println("Enter the parent node id in Integer");
			int deleteParentId = sc.nextInt();
			if (GraphOperation.deleteDependency(deleteChildId, deleteParentId)) {
				System.out.print("Dependency deleted successfully!");
			}
			break;

		case 6:
			System.out.println("Enter the node id in Integer to be deleted");
			int deleteNodeId = sc.nextInt();
			if (GraphOperation.deleteNode(deleteNodeId)) {
				System.out.println("Node deleted successfully!");
			}
			break;

		case 7:
			System.out.println("Enter the child node id in Integer");
			int childId = sc.nextInt();
			System.out.println("Enter the parent node id in Integer");
			int parentId = sc.nextInt();
			if (GraphOperation.addDependency(childId, parentId)) {
				System.out.println("Dependency added successfully!");
			}
			break;

		case 8:
			System.out.println("Enter the id in Integer");
			int nodeId = sc.nextInt();
			System.out.println("Enter the name of Node");
			String nodeName = sc.next();
			if (!GraphOperation.createNode(nodeId, nodeName)) {
				System.out.println("Node id already exists!");
			} else {
				System.out.println("Node added successfully!");
			}
			break;

		case 9:
			GraphOperation.printAllNodes();
			break;

		case 10:
			System.exit(0);
			break;

		default:
			System.out.println("Invalid Input! Please try again.");
		}
	}
}
