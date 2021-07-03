/*
 * Created by Manu KJ 
 */
package Assignment3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DependencyGraph {

	// HashMap to store all the node in the dependencyGraph
	private Map<Integer, Node> graphNodes = new HashMap<Integer, Node>();
	private Scanner sc = new Scanner(System.in);

	/*
	 * function to add new, and no duplicate's are allowed
	 */
	public boolean addNewNode(int id, String name, boolean add_info) {
		// check if the node with id already present in the graph
		if (getNode(id) != null) {
			System.out.println("Node with " + id + " already exsist");
			return false;
		}

		Node newNode = new Node();
		newNode.setId(id);
		newNode.setName(name);
		newNode.setChild(null);
		newNode.setParent(null);

		if (add_info) {
			String key, value;
			int add_info_choice;

			outter: while (true) {
				System.out.println("select \n1:Add Additional Info(key value pair)\n2:Exit");
				add_info_choice = sc.nextInt();
				switch (add_info_choice) {
				case 1:
					System.out.println("Enter the key");
					key = sc.nextLine();
					System.out.println("Enter the value");
					value = sc.nextLine();
					newNode.setAdditional_info(key, value);
					break;
				case 2:
					break outter;
				}
			}
		}

		// add the node to the list
		graphNodes.put(id, newNode);
		System.out.println("Node " + id + " Added to the graph");
		return true;
	}

	public boolean addDependency(int parent_id, int child_id) {

		// get the child and parent node
		Node child = getNode(child_id);
		if (child == null) {
			System.out.println(child_id + " Does not exist in the graph");
			return false;
		}

		Node parent = getNode(parent_id);
		if (parent == null) {
			System.out.println(parent_id + " Does not exist in the graph");
			return false;
		}

		// add the dependency
		parent.setChild(child);
		child.setParent(parent);

		System.out.println(parent_id + " Node child is set to " + parent.getChild());
		System.out.println(child_id + " Node parent is set to " + child.getParent());
		System.out.println("there for the dependency between " + parent_id + " and " + child_id + " established");

		// checking for cyclic dependencies.
		if (!(child.getChild() == null)) {
			if (child.getChild().getId() == parent.getId())
				System.out.println("Cylic dependency");
		}
		return true;
	}

	public boolean deleteDependency(int parent_id, int child_id) {

		// get the child anf parent node
		Node child = getNode(child_id);
		if (child == null) {
			System.out.println(child_id + " Does not exist in the graph");
			return false;
		}

		Node parent = getNode(parent_id);
		if (parent == null) {
			System.out.println(parent_id + " Does not exist in the graph");
			return false;
		}

		// delete the dependency
		parent.setChild(null);
		child.setParent(null);

		System.out.println(parent_id + " Node child is set to " + parent.getChild());
		System.out.println(child_id + " Node parent is set to " + child.getParent());
		System.out.println("there for the dependency between " + parent_id + " and " + child_id + " deleted");
		return true;
	}

	public boolean deleteNode(int id) {
		// get the node
		Node node = getNode(id);
		if (node == null) {
			System.out.println(id + " Does not exist in the graph");
			return false;
		}

		// delete the dependencies
		deleteDependency(node.getParent().getId(), node.getId());
		deleteDependency(node.getId(), node.getChild().getId());

		// delete the node from the graph
		graphNodes.remove(id);
		System.out.println(id + " Node deleted");
		return true;
	}

	// function used to check if the node is present and returns if it does
	public Node getNode(int id) {
		Node node = null;
		if (graphNodes.containsKey(id)) {
			node = graphNodes.get(id);
		}
		return node;
	}

	public int getImmediateChild(int id) {
		// get the node
		Node node = getNode(id);
		if (node == null) {
			System.out.println(id + " Does not exist in the graph");
			return -1;
		}
		// check if the node has a child
		Node child = node.getChild();
		if (child == null) {
			System.out.println(id + " doesnt have child");
			return -1;
		}
		return child.getId();
	}

	public int getImmediateParent(int id) {
		Node node = getNode(id);
		if (node == null) {
			System.out.println(id + " Does not exist in the graph");
			return -1;
		}
		// check if the node has a parent
		Node parent = node.getParent();
		if (parent == null) {
			System.out.println(id + " doesnt have child");
			return -1;
		}
		return parent.getId();
	}

	public List<Integer> getDescendants(int id) {
		Node node = getNode(id);
		if (node == null) {
			System.out.println(id + "  Does not exist in the graph");
			return null;
		}
		// list to store the descendants
		List<Integer> nodes = new ArrayList<Integer>();
		int count = -1;

		do {
			count++;
			if (count > graphNodes.size()) {
				System.out.println("its A cyclic dependency");
				break;
			}
			nodes.add(node.getId());
			node = node.getChild();

		} while (node != null);

		return nodes;
	}

	public List<Integer> getAncestors(int id) {

		Node node = getNode(id);
		if (node == null) {
			System.out.println(id + "  Does not exist in the graph");
			return null;
		}
		// list to store the ancestors
		List<Integer> nodes = new ArrayList<Integer>();
		int count = -1;

		do {
			count++;
			if (count > graphNodes.size()) {
				System.out.println("its A cyclic dependency");
				break;
			}
			nodes.add(node.getId());
			node = node.getParent();

		} while (node != null);
		return nodes;
	}
}
