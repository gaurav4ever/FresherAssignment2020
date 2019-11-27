package asgn3;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		DependencyGraph g = new DependencyGraph();
		int choice;
		boolean flg=true;
		while(flg) {
			System.out.println("Please select an option :");
			System.out.println("1. Get Immediate Parent of a node");
			System.out.println("2. Get Immediate Children of a node");
			System.out.println("3. Get Ancestors of a node");
			System.out.println("4. Get Descendants of a node");
			System.out.println("5. Delete a dependency");
			System.out.println("6. Delete a node");
			System.out.println("7. Add a dependency");
			System.out.println("8. Add a Node");
			System.out.println("9. Print the Graph");
			System.out.println("10. Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Enter the node ID : ");
				System.out.println();
				if(g.getParents(sc.nextInt())) {
					System.out.println("Immediate Parents are : "+ g.parents);
				}
				else
					System.out.println("No parents exists");
				break;
			case 2:
				System.out.print("Enter the node ID : ");
				System.out.println();
				if(g.getChildren(sc.nextInt())) {
					System.out.println("Immediate Children are : "+ g.children);
				}
				else
					System.out.println("No children exists");
				break;
			case 3:
				System.out.print("Enter the node ID : ");
				System.out.println();
				if(g.getAncestors(sc.nextInt())) {
					System.out.println("Immediate Ancestors are : "+ g.ancestors);
				}
				else
					System.out.println("No ancestors exists");
				break;
			case 4:
				System.out.print("Enter the node ID : ");
				System.out.println();
				if(g.getDescendants(sc.nextInt())) {
					System.out.println("Immediate Descendants are : "+ g.descendants);
				}
				else
					System.out.println("No Descendants exists");
				break;
			case 5:
				System.out.print("Enter the parent ID : ");
				System.out.println();
				int pid = sc.nextInt();
				System.out.print("Enter the child ID : ");
				System.out.println();
				int cid = sc.nextInt();
				if(g.deleteDependency(pid, cid)) {
					System.out.println("Dependency Deleted.");
				}
				else
					System.out.println("No dependency exists");
				break;
			case 6:
				System.out.print("Enter the parent ID : ");
				System.out.println();
				int nid = sc.nextInt();
				if(g.deleteNode(nid)) {
					System.out.println("Node Deleted.");
				}
				else
					System.out.println("No node exists");
				break;
			case 7:
				Node n1 = new Node();
				Node n2 = new Node();
				System.out.println("Enter the parent node id : ");
				int pID = sc.nextInt();
				if (g.checkId(pID) ==0) {
					System.out.println("Enter the name of the node : ");
					n1.setNodeName(sc.next());
					n1.setNodeId(pID);
					g.addVertex(n1);
				}
				else {
					n1=g.checkNode(pID);
				}
				
				System.out.println("Enter the child node id : ");
				int cID = sc.nextInt();
				if (g.checkId(cID) ==0) {
					System.out.println("Enter the name of the node : ");
					n2.setNodeName(sc.next());
					n2.setNodeId(pID);
					g.addVertex(n2);
				}
				else {
					n2=g.checkNode(cID);
				}
				g.addEdge(n1,n2);
				break;
			case 8:
				Node n = new Node();
				while (true) {
					System.out.print("Enter the node id : ");
					System.out.println();
					int id = sc.nextInt();
					if(g.checkId(id) == 0) {
						n.setNodeId(id);
						break;
					}
					else
						System.out.println("This node exists.");
				}
				System.out.println("Enter the node name : ");
				n.setNodeName(sc.next());
				g.addVertex(n);
				break;
			case 9:
				System.out.println(g.toString());
				break;
			case 10:
				flg=false;
				break;
			default:
				System.out.println("Re Enter your choice");
			}
		}	
	}
}
