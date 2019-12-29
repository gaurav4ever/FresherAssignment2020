package source_package;

import java.util.ArrayList;

public class node {
	
	String name;
	int node_id;
	ArrayList<node> back_nodes;
	ArrayList<node> front_nodes;
	
	node(String name,int node_id)
	{
		this.name = name;
		this.node_id = node_id;
		front_nodes = new ArrayList<>();
		back_nodes = new ArrayList<>();
	}
}
