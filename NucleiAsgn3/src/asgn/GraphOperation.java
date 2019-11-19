package asgn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import asgn.model.Node;

public class GraphOperation {

	private static Map<Integer, Node> nodeHashMap = new HashMap<>();

	// create node with given id and name
	public static boolean createNode(int id, String name) {
		// check if node id already exists
		if (nodeHashMap.containsKey(id)) {
			return false;
		} else {
			Node node = new Node();
			node.setNodeID(id);
			node.setNodeName(name);
			nodeHashMap.put(id, node); // add node to hash map with key as given node id.
			return true;
		}
	}

	// add parent and child dependency if nodes exists
	public static boolean addDependency(int childId, int parentId) {
		if (nodeHashMap != null) {
			if (nodeHashMap.containsKey(parentId) && nodeHashMap.containsKey(childId)) {

				// add child node to the parent node's childNode list
				Node pnode = nodeHashMap.get(parentId);
				ArrayList<Node> childNodes, parentNodes;
				if (pnode != null && pnode.getChildNodes() == null) {
					childNodes = new ArrayList<>();
				} else {
					childNodes = pnode.getChildNodes();
				}
				childNodes.add(nodeHashMap.get(childId));
				pnode.setChildNodes(childNodes);

				// add parent node to the child node's parentNode list
				Node cnode = nodeHashMap.get(childId);
				if (cnode != null && cnode.getParentNodes() == null) {
					parentNodes = new ArrayList<>();
				} else {
					parentNodes = cnode.getParentNodes();
				}
				parentNodes.add(nodeHashMap.get(parentId));
				cnode.setParentNodes(parentNodes);

				// check if there is any cycle
				if (!checkCycle(childId, parentId)) {
					return true;
				} else {
					childNodes.remove(nodeHashMap.get(childId));
					pnode.setChildNodes(childNodes);
					parentNodes.remove(nodeHashMap.get(parentId));
					cnode.setParentNodes(parentNodes);
					return false;
				}
			} else {
				System.out.print("No such id exists!");
				return false;
			}
		} else {
			System.out.print("No nodes in graph!");
			return false;
		}
	}

	// check if cycle exists
	private static boolean checkCycle(int childId, int parentId) {
		// child should not exit in parent's Ancestors
		Set<Integer> parentAncestor = getAncestors(parentId);
		for (Integer p : parentAncestor) {
			if (p == childId) {
				return true; // cycle exists
			}
		}

		// parent should not exist in child Descendants
		Set<Integer> childDesendants = getDescendants(childId);
		for (Integer c : childDesendants) {
			System.out.print(c + " " + parentId);
			if (c == parentId) {
				return true; // cycle exists
			}
		}
		return false;
	}

	// get list of all descendants
	public static Set<Integer> getDescendants(int id) {
		Node node = nodeHashMap.get(id);
		Set<Integer> descendents = new HashSet<>();
		ifNodeExists(node);

		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			Node temp = q.peek();
			q.remove();
			descendents.add(temp.getNodeId());
			if (temp.getChildNodes() != null && temp.getChildNodes().size() != 0) {
				q.addAll(temp.getChildNodes());
			}
		}
		descendents.remove(node.getNodeId());
		return descendents;
	}

	// get list of all ancestors
	public static Set<Integer> getAncestors(int id) {
		Node node = nodeHashMap.get(id);
		Set<Integer> ancestors = new HashSet<>();
		ifNodeExists(node);

		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			Node temp = q.peek();
			q.remove();
			ancestors.add(temp.getNodeId());
			if (temp.getParentNodes() != null && temp.getParentNodes().size() != 0) {
				q.addAll(temp.getParentNodes());
			}
		}
		ancestors.remove(node.getNodeId());
		return ancestors;
	}

	// delete node with given id, if id exists
	public static boolean deleteNode(int deleteNodeId) {
		Node node = nodeHashMap.get(deleteNodeId);
		if (!ifNodeExists(node)) {
			return false;
		} else {
			if (node.getChildNodes() != null) {
				// delete node from the child node dependency
				for (Node n : node.getChildNodes()) {
					Node n1 = nodeHashMap.get(n.getNodeId());
					n1.getParentNodes().remove(node);
				}
			}

			if (node.getParentNodes() != null) {
				// delete node from the parent node dependency
				for (Node n : node.getParentNodes()) {
					Node n1 = nodeHashMap.get(n.getNodeId());
					n1.getChildNodes().remove(node);
				}
			}

			nodeHashMap.remove(deleteNodeId);
			return true;
		}
	}

	// get list of immediate parents
	public static boolean getImmediateParents(int id) {
		Node node = nodeHashMap.get(id);
		if (!ifNodeExists(node) || node.getParentNodes() == null || node.getParentNodes().isEmpty()) {
			return false;
		}
		System.out.print("Immediate parents : ");
		for (int i = 0; i < node.getParentNodes().size(); i++)
			System.out.print(" " + node.getParentNodes().get(i).getNodeId() + " ");
		return true;
	}

	// get list of immediate children
	public static boolean getImmediateChildren(int id) {
		Node node = nodeHashMap.get(id);
		if (!ifNodeExists(node) || node.getChildNodes() == null || node.getChildNodes().isEmpty()) {
			return false;
		}
		System.out.println("Immediate children : ");
		for (int i = 0; i < node.getChildNodes().size(); i++)
			System.out.println(" " + node.getChildNodes().get(i).getNodeId() + " ");
		return true;
	}

	// delete child parent dependency
	public static boolean deleteDependency(int deleteChildId, int deleteParentId) {
		Node nc = nodeHashMap.get(deleteChildId);
		Node np = nodeHashMap.get(deleteParentId);
		if (!ifNodeExists(nc) || !ifNodeExists(np) || nc.getParentNodes() == null || np.getChildNodes() == null) {
			return false;
		}
		nc.getParentNodes().remove(np);
		np.getChildNodes().remove(nc);
		return true;
	}

	// check if a node is null of not
	private static boolean ifNodeExists(Node node) {
		if (node == null) {
			System.out.println("No such node exists!");
			return false;
		}
		return true;
	}

	public static void printAllNodes() {
		System.out.println("Display details of each node: ");
		for (Node n : nodeHashMap.values()) {
			System.out.print("\nNode id : " + n.getNodeId() + "  Node name : " + n.getNodeName());
			if (n.getParentNodes() != null && !n.getParentNodes().isEmpty()) {
				System.out.print("  Parent nodes : ");
				for (Node a : n.getParentNodes()) {
					System.out.print(a.getNodeId() + " ,");
				}
			}

			if (n.getChildNodes() != null && !n.getChildNodes().isEmpty()) {
				System.out.print("  Child nodes : ");
				for (Node a : n.getChildNodes()) {
					System.out.print(a.getNodeId() + " ,");
				}
			}
		}
	}
}