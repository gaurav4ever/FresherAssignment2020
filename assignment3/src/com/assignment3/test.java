package com.assignment3;

public class test {
	public static void main(String args[]) {
		Graph graph = new Graph();
		Node a = new Node();
		a.setNodeID(1);
		a.setNodeName("a");
		Node b = new Node();
		b.setNodeID(2);
		b.setNodeName("b");
		Node c = new Node();
		c.setNodeID(3);
		c.setNodeName("c");
		Node d = new Node();
		d.setNodeID(4);
		d.setNodeName("d");
		Node e = new Node();
		e.setNodeID(5);
		e.setNodeName("e");
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(e);
		graph.addVertex(d);
		graph.addEdge(a, b);
		graph.addEdge(b, c);
		graph.addEdge(c, d);
		graph.addEdge(d, e);
		boolean fa = graph.getDescendants(1);
		if(fa == true) System.out.println(graph.descendants);
		boolean af = graph.getAncestors(5);
		if(af == true)	System.out.println(graph.ancestors);
		System.out.println(graph);
	}
}
