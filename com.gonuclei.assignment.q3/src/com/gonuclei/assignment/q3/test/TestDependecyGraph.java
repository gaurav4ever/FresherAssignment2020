package com.gonuclei.assignment.q3.test;

import java.util.ArrayList;
import java.util.List;

import com.gonuclei.assignment.q3.graph.Graph;
import com.gonuclei.assignment.q3.graph.GraphNode;

public class TestDependecyGraph {
	public static void main(String[] args) {
        testWithGenericInt();
    }

    public static void testWithGenericInt() {
        final List<Integer> nodeValueList = new ArrayList<Integer>();
        Graph graph = new Graph();
        graph.createNode(1, "one");
        graph.createNode(2, "Two");
        graph.createNode(5, "three");
        graph.createNode(6, "four");
        graph.createNode(7, "five");
		try {
			graph.addDependency(1, 5);
			graph.addDependency(2, 5);
			graph.addDependency(5, 7);
			graph.addDependency(6, 7);
			graph.addDependency(1, 7);
		} catch (Exception e) {
			
		}


		List<GraphNode> children = new ArrayList<>();
		List<GraphNode> parents = new ArrayList<>();
		
	
    }

}
