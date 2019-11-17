/*
 * Created by Manu KJ 
 */
package Assignment3;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestAssignment3 {

	@Test
	@DisplayName("Testing to add duplicate node")
	void test_addNewNode() {
		System.out.println("------Testing to add duplicate node------");
		DependencyGraph dependencyGraph = new DependencyGraph();
		int id = 12;
		String name = "Node1";
		assertAll(() -> assertEquals(true, dependencyGraph.addNewNode(id, name, false)),
				// adding a new node with same id
				() -> assertEquals(false, dependencyGraph.addNewNode(id, name, false)),
				// adding a new node with same name but different id
				() -> assertEquals(true, dependencyGraph.addNewNode(id + 1, name, false)));
	}

	@Test
	@DisplayName("Testing for Adding new dependency")
	void test_addDependency() {
		System.out.println("------Testing for Adding new dependency------");
		DependencyGraph dependencyGraph = new DependencyGraph();
		dependencyGraph.addNewNode(1, "Node1", false);
		dependencyGraph.addNewNode(2, "Node2", false);
		dependencyGraph.addNewNode(3, "Node3", false);
		assertAll(() -> assertEquals(true, dependencyGraph.addDependency(1, 2)),
				// checking for acyclic dependencies
				() -> assertEquals(true, dependencyGraph.addDependency(2, 1)));

	}

	@Test
	@DisplayName("Testing for delete node")
	void test_deleteNode() {
		System.out.println("------Testing for delete node------");
		DependencyGraph dependencyGraph = new DependencyGraph();
		dependencyGraph.addNewNode(1, "Node1", false);
		dependencyGraph.addNewNode(2, "Node2", false);
		dependencyGraph.addNewNode(3, "Node3", false);

		assertEquals(true, dependencyGraph.addDependency(1, 2));
		assertEquals(true, dependencyGraph.addDependency(2, 3));
		// delete the node
		assertEquals(true, dependencyGraph.deleteNode(2));
		// check if the node deleted
		assertEquals(null, dependencyGraph.getNode(2));
		// check for the dependency
		assertEquals(null, dependencyGraph.getNode(1).getChild());

	}

	@Test
	@DisplayName("Testing all the get method")
	void test_get_parent_child_ancestors_descendants() {
		System.out.println("------Testing for delete node------");
		DependencyGraph dependencyGraph = new DependencyGraph();
		dependencyGraph.addNewNode(1, "Node1", false);
		dependencyGraph.addNewNode(2, "Node2", false);
		dependencyGraph.addNewNode(3, "Node3", false);
		dependencyGraph.addNewNode(4, "Node4", false);
		dependencyGraph.addNewNode(5, "Node5", false);

		assertEquals(true, dependencyGraph.addDependency(1, 2));
		assertEquals(true, dependencyGraph.addDependency(2, 3));
		assertEquals(true, dependencyGraph.addDependency(3, 4));
		assertEquals(true, dependencyGraph.addDependency(4, 5));
		assertEquals(true, dependencyGraph.addDependency(5, 1));

		List<Integer> expectedDescendants = new ArrayList<Integer>();
		expectedDescendants.add(1);
		expectedDescendants.add(2);
		expectedDescendants.add(3);
		expectedDescendants.add(4);
		expectedDescendants.add(5);
		expectedDescendants.add(1);
		assertArrayEquals(expectedDescendants.toArray(), dependencyGraph.getDescendants(1).toArray());

		dependencyGraph.deleteDependency(5, 1);

		List<Integer> expected = new ArrayList<Integer>();
		expected.add(4);
		expected.add(3);
		expected.add(2);
		expected.add(1);
		assertArrayEquals(expected.toArray(), dependencyGraph.getAncestors(4).toArray());

	}

}
