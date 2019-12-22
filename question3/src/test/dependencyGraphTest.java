
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import question3.Node;
import question3.dependencyGraph;

class dependencyGraphTest {

	private static dependencyGraph graph = new dependencyGraph(5);
	
	public dependencyGraphTest()
	{
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
		
	}
	

	@Test
	void testAddNode() {

		Node node = new Node(10,"abc");
		graph.addNode(10, node);
		assertEquals(graph.nodesOfGraph.containsKey(10),true);
			
	}


	@Test
	void testGetParents() {
		ArrayList<Integer> parents = new ArrayList<>(Arrays.asList(0,3));
		assertArrayEquals(parents.toArray(),graph.getParents(2).toArray());
	}


	@Test
	void testGetChildren() {
		ArrayList<Integer> children = new ArrayList<>(Arrays.asList(3,4));
		assertEquals(children,graph.getChildren(1));
		
	}


	@Test
	void testGetAncestors() {
	ArrayList<Integer> ancestors = new ArrayList<>(Arrays.asList(0,3,1));
	assertEquals(ancestors,graph.getAncestors(2));
	}


	@Test
	void testGetDescendents() {
		ArrayList<Integer> descendants = new ArrayList<>(Arrays.asList(3,2,4));
		assertEquals(descendants,graph.getDescendents(1));
	}


	@Test
	void testAddDependency() {
		graph.addDependency(3, 4);
		assertEquals(true,graph.depGraph[3].contains(4));
	}


	@Test
	void testDeleteDependencyInt() {
		graph.deleteDependency(2);
		assertEquals(true,graph.depGraph[2].isEmpty());
	}

	@Test
	void testDeleteDependencyIntInt() {
		graph.deleteDependency(3, 4);
		assertEquals(false, graph.depGraph[3].contains(4));
	}

}
