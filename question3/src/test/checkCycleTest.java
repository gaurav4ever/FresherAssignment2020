
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import question3.Node;
import question3.checkCycle;
import question3.dependencyGraph;


class checkCycleTest {

	private static dependencyGraph graph = new dependencyGraph(5);
	public checkCycleTest()
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
		graph.addDependency(4,1);
		
	}
	@Test
	void test() {
		//fail("Not yet implemented");
		checkCycle cycle = new checkCycle();
		graph.addDependency(3, 4);
		assertEquals(true,graph.hasCycle);
	}

}
