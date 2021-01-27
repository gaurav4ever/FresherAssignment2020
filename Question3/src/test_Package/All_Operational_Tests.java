package test_Package;

import java.util.ArrayList;
import java.util.HashMap;
import source_package.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//This class tests all functionalities of the graph using JUnit Testing Framework
public class All_Operational_Tests {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting New Test **************************************************");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending Test ********************************************************");
	}

	@Test
	public void test() {
		ArrayList<node> root = new ArrayList<>();
		HashMap<Integer,node> hm = new HashMap<Integer,node>();
		operations_only_for_JUnit_Testing o = new operations_only_for_JUnit_Testing(root,hm);
		o.add(1,2,"A","B");
		o.add(2, 3,"B","C");
		o.add(2, 4,"B","D");
		o.add(2, 5,"B","E");
		o.add(3, 6,"C","F");
		o.add(6, 7,"F","G");
		assertEquals("Children Not Equal",o.get_immediate_children(1),"B");
		assertEquals("Parents Not Equal",o.get_immediate_parents(2),"A");
		assertEquals("Descendants Not Equal",o.get_descendants(1),"BCFGDE");
		assertEquals("Ancestors Not Equal",o.get_ancestors(7),"FCBA");
		o.delete_dependency(2,3);
		assertEquals("Deletion of Dependency Didnt Work",o.get_descendants(1),"BDE");
	}

}
