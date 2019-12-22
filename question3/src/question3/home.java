package question3;

import java.util.ArrayList;

public class home {

	public void Display(ArrayList<Integer> list)
	{
		for(int x : list)
		{
			System.out.print(x+ " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		int noOfNodes=5;
		dependencyGraph graph = new dependencyGraph(noOfNodes);
		home homeObject = new home();
		
		/**
		 * Following Methods can be used based on defination to perform the operations
		 * public void addNode(int id, Node n);
	
				public ArrayList<Integer> getParents(int id);
				
				public ArrayList<Integer> getChildren(int id);
			
				public ArrayList<Integer> getAncestors(int id);
				
				public ArrayList<Integer> getDescendents(int id);
				
				public void addDependency(int id1, int id2);
				
				public void deleteDependency(int id);
				
				public void deleteDependency(int parentId, int childId);
		 */
		
		// Following is an example to use the methods
		
		Node n1 = new Node(0,"A");
		Node n2 = new Node(1,"B");
		Node n3 = new Node(2,"C");
		Node n4 = new Node(3,"D");
		Node n5 = new Node(4,"E");
		
		graph.addNode(0, n1);
		graph.addNode(1, n2);
		graph.addNode(2, n3);
		graph.addNode(3, n4);
		graph.addNode(4, n5);
		
		graph.addDependency(0,2);
		graph.addDependency(1,3);
		graph.addDependency(3,2);
		graph.addDependency(1,4);
		
		
		System.out.println("The Graph using List Representation");
		graph.displayGraph(graph.depGraph);
		
		// Using getParents(int id)
		
		System.out.println("-----------------------------------------");
		System.out.println("Parents of Node ");
		ArrayList<Integer> parents = graph.getParents(2);
		homeObject.Display(parents);

		// Using getAncestors(int id)
		System.out.println("-----------------------------------------");
		System.out.println("Ancestors of Node ");
		ArrayList<Integer> Ancestors = graph.getAncestors(2);
		homeObject.Display(Ancestors);
		
		graph.addDependency(1,2);
		
		// using getChildren(int id)
		System.out.println("-----------------------------------------");
		System.out.println("Immediate Children");
		ArrayList<Integer> children = graph.getChildren(1);
		homeObject.Display(children);

		// Using getDescendants(int id)
		System.out.println("-----------------------------------------");
		System.out.println("Descendants");
		ArrayList<Integer> descendants = graph.getDescendents(1);
		homeObject.Display(descendants);


		// Using deleteDependency(int id)
		graph.deleteDependency(4);
		
		// Using deleteDependency(int parent, int children)
		graph.deleteDependency(1,2);
		
		System.out.println("-----------------------------------------");
		System.out.println("The Final Graph after the previous Delete Operations");
		graph.displayGraph(graph.depGraph);
		
	}
}
