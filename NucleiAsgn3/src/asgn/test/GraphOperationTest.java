/**
 * 
 */
package asgn.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import asgn.GraphOperation;

/**
 * @author khushbu
 *
 */
public class GraphOperationTest {

	@Test
	public void test_for_create_node() {
		assertEquals(true, GraphOperation.createNode(1, "demo1"));
		assertEquals(false, GraphOperation.createNode(1, "demo2"));// same id different name
		assertEquals(true, GraphOperation.createNode(2, "demo1"));// different id same name
		assertEquals(true, GraphOperation.createNode(3, "demo3"));
	}

	@Test
	public void test_for_delete_node() {
		// add some node first
		GraphOperation.createNode(4, "demo1");
		GraphOperation.createNode(5, "demo2");
		GraphOperation.createNode(6, "demo2");

		// add some dependency
		GraphOperation.addDependency(5, 4);

		assertEquals(true, GraphOperation.deleteNode(5)); // delete node and dependency
		assertEquals(true, GraphOperation.deleteNode(4)); // delete node and dependency
		assertEquals(false, GraphOperation.deleteNode(41)); // no such node
		assertEquals(true, GraphOperation.deleteNode(6)); // delete node no dependency
	}

	@Test
	public void test_for_delete_node_dependency() {
		// add some node first
		GraphOperation.createNode(4, "demo1");
		GraphOperation.createNode(5, "demo2");
		GraphOperation.createNode(6, "demo2");

		// add some dependency
		GraphOperation.addDependency(5, 4);
		GraphOperation.addDependency(5, 6);
		GraphOperation.addDependency(6, 4);

		assertEquals(true, GraphOperation.deleteDependency(5, 4)); // delete node and dependency
		assertEquals(false, GraphOperation.deleteDependency(10, 5)); // no such node
		assertEquals(false, GraphOperation.deleteDependency(6, 5)); // no such dependency
	}

	@Test
	public void test_for_add_dependency() {
		GraphOperation.createNode(4, "demo1");
		GraphOperation.createNode(5, "demo2");
		GraphOperation.createNode(6, "demo2");
		GraphOperation.createNode(7, "demo2");
		GraphOperation.createNode(8, "demo2");

		assertEquals(true, GraphOperation.addDependency(6, 4));
		assertEquals(true, GraphOperation.addDependency(5, 4)); // add multiple child of a parent
		assertEquals(true, GraphOperation.addDependency(4, 7));
		assertEquals(true, GraphOperation.addDependency(4, 8)); // add multiple parents to a child
		assertEquals(false, GraphOperation.addDependency(10, 5)); // node does not exists
	}

	@Test
	public void test_for_get_immediate_parents() {
		// add some node first
		GraphOperation.createNode(11, "demo1");
		GraphOperation.createNode(12, "demo2");
		GraphOperation.createNode(13, "demo2");

		// add some dependency
		GraphOperation.addDependency(12, 11);
		GraphOperation.addDependency(13, 12);

		assertEquals(true, GraphOperation.getImmediateParents(13));
		assertEquals(false, GraphOperation.getImmediateParents(11));
	}

	@Test
	public void test_for_get_immediate_children() {
		// add some node first
		GraphOperation.createNode(11, "demo1");
		GraphOperation.createNode(12, "demo2");
		GraphOperation.createNode(13, "demo2");

		// add some dependency
		GraphOperation.addDependency(12, 11);
		GraphOperation.addDependency(13, 12);

		assertEquals(true, GraphOperation.getImmediateParents(13));
		assertEquals(false, GraphOperation.getImmediateParents(11));
	}

	@Test
	public void test_for_get_ancestors() {
		// add some node first
		GraphOperation.createNode(11, "demo1");
		GraphOperation.createNode(12, "demo2");
		GraphOperation.createNode(13, "demo2");

		// add some dependency
		GraphOperation.addDependency(12, 11);
		GraphOperation.addDependency(13, 12);

		Set<Integer> expectedAncestors = new HashSet<>();
		expectedAncestors.add(11);
		expectedAncestors.add(12);

		assertEquals(expectedAncestors, GraphOperation.getAncestors(13));
	}

	@Test
	public void test_for_get_decendants() {
		// add some node first
		GraphOperation.createNode(11, "demo1");
		GraphOperation.createNode(12, "demo2");
		GraphOperation.createNode(13, "demo2");

		// add some dependency
		GraphOperation.addDependency(12, 11);
		GraphOperation.addDependency(13, 12);

		Set<Integer> expectedAncestors = new HashSet<>();
		expectedAncestors.add(12);
		expectedAncestors.add(13);

		assertEquals(expectedAncestors, GraphOperation.getDescendants(11));
	}

}
