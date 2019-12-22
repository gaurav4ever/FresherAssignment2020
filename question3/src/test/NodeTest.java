/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import question3.*;

class NodeTest {

	@Test
	void test() {
		
		Node node = new Node(1,"Adarsh");
		assertNotNull(node);
		assertEquals("Adarsh", node.getName());
		assertEquals(1,node.getId());
		
	}

}
