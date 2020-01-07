package FresherAssignment2020.Assignment3;

import java.util.ArrayList;

public class Node {

	String name;
	int n_id;
	ArrayList<Node> parent_nodes;
	ArrayList<Node> child_nodes;

	Node(String name,int n_id)
	{
		this.name = name;
		this.n_id = n_id;
		child_nodes = new ArrayList<>();
		parent_nodes = new ArrayList<>();
	}
}
