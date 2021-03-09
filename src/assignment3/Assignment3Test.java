package assignment3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import assignment3.Exceptions.CyclicDependencyException;
import assignment3.Exceptions.DependencyNotFoundException;
import assignment3.Exceptions.NodeAlreadyExistsException;
import assignment3.Exceptions.NodeNotFoundException;

class Assignment3Test {

	@Test
	void test_get_immediate_parents_and_children() {
		DependencyGraph dg = new DependencyGraph();
		ArrayList<Integer> parents = new ArrayList<Integer>();
		parents.add(1);
		parents.add(2);
		ArrayList<Integer> children = new ArrayList<Integer>();
		children.add(3);
		children.add(4);
		assertAll(
				() -> dg.addNode(1, "Node1", new HashMap<String,String>()),
				() -> dg.addNode(2, "Node2", new HashMap<String,String>()),
				() -> dg.addNode(3, "Node3", new HashMap<String,String>()),
				() -> dg.addNode(4, "Node4", new HashMap<String,String>()),
				() -> dg.addDependency(1, 3),
				() -> dg.addDependency(2, 3),
				() -> dg.addDependency(2, 4),
				() -> assertThrows(NodeNotFoundException.class,() -> dg.getParents(5)),
				() -> assertEquals(parents,dg.getParents(3)),
				() -> assertEquals(children,dg.getChildren(2))
				);	
	}
	@Test
	void test_get_ancestors_and_descendents() {
		DependencyGraph dg = new DependencyGraph();
		ArrayList<Integer> ancestors = new ArrayList<Integer>();
		ancestors.add(1);
		ancestors.add(2);
		ancestors.add(4);
		ancestors.add(5);
		ArrayList<Integer> descendents = new ArrayList<Integer>();
		descendents.add(2);
		descendents.add(3);
		descendents.add(4);
		descendents.add(5);
		descendents.add(6);
		assertAll(
				() -> dg.addNode(1, "Node1", new HashMap<String,String>()),
				() -> dg.addNode(2, "Node2", new HashMap<String,String>()),
				() -> dg.addNode(3, "Node3", new HashMap<String,String>()),
				() -> dg.addNode(4, "Node4", new HashMap<String,String>()),
				() -> dg.addNode(5, "Node5", new HashMap<String,String>()),
				() -> dg.addNode(6, "Node6", new HashMap<String,String>()),
				() -> dg.addDependency(1, 2),
				() -> dg.addDependency(2, 3),
				() -> dg.addDependency(2, 4),
				() -> dg.addDependency(4, 5),
				() -> dg.addDependency(5, 6),
				() -> assertThrows(NodeNotFoundException.class,() -> dg.getAncestors(7)),
				() -> assertEquals(ancestors,dg.getAncestors(6)),
				() -> assertEquals(descendents,dg.getDescendents(1))
				);
	}
	@Test
	void test_add_and_delete_dependency() {
		DependencyGraph dg = new DependencyGraph();
		assertAll(
				() -> dg.addNode(1, "Node1", new HashMap<String,String>()),
				() -> dg.addNode(2, "Node2", new HashMap<String,String>()),
				() -> dg.addNode(3, "Node3", new HashMap<String,String>()),
				() -> dg.addNode(4, "Node4", new HashMap<String,String>()),
				() -> dg.addNode(5, "Node5", new HashMap<String,String>()),
				() -> dg.addNode(6, "Node6", new HashMap<String,String>()),
				() -> assertThrows(NodeNotFoundException.class,() -> dg.addDependency(7,2)),
				() -> dg.addDependency(2, 3),
				() -> dg.addDependency(2, 4),
				() -> dg.addDependency(4, 5),
				() -> assertThrows(CyclicDependencyException.class,() -> dg.addDependency(4,2)),
				() -> assertThrows(DependencyNotFoundException.class,() -> dg.deleteDependency(4,2)),
				() -> dg.deleteDependency(4, 5)
				);
	}
	@Test
	void test_add_and_delete_node() {
		DependencyGraph dg = new DependencyGraph();
		assertAll(
				() -> dg.addNode(1, "Node1", new HashMap<String,String>()),
				() -> dg.addNode(2, "Node2", new HashMap<String,String>()),
				() -> assertThrows(NodeAlreadyExistsException.class,() -> dg.addNode(1, "Node1", new HashMap<String,String>())),
				() -> assertThrows(NodeNotFoundException.class,() -> dg.deleteNode(3)),
				() -> dg.deleteNode(1)
				);
	}
}
