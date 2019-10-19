package assignment3;

import assignment3.exceptions.CyclicDependencyException;
import assignment3.exceptions.InvalidNodeIdException;
import assignment3.models.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DependencyGraphTest {
    DependencyGraph dependencyGraph ;
    @BeforeEach
    void init(){
        dependencyGraph = new DependencyGraph(new Node(1,"Root"));
        try {
            dependencyGraph.addNode(2 , "multi child");
            dependencyGraph.addDependency(1,2);
            dependencyGraph.addNode(3 , "Suresh");
            dependencyGraph.addDependency(2,3);
            dependencyGraph.addNode(4 , "Dinesh");
            dependencyGraph.addDependency(2,4);
            dependencyGraph.addNode(5 , "Multiparent");
            dependencyGraph.addDependency(4,5);
            dependencyGraph.addDependency(1,5);
            dependencyGraph.addDependency(2,5);
        } catch (InvalidNodeIdException | CyclicDependencyException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testInvalidNodeExceptions(){
        assertThrows(InvalidNodeIdException.class , ()->dependencyGraph.addNode(3, "3"));
        assertThrows(InvalidNodeIdException.class , ()->dependencyGraph.addDependency(3, 999));
        assertThrows(NullPointerException.class , ()->dependencyGraph.getRoot().getChildren().get(3).getId());
        assertThrows(CyclicDependencyException.class , ()->dependencyGraph.addDependency(3, 1));
    }

    @Test
    void testParentChildRelationShips(){
        Node root = dependencyGraph.getRoot() ;
        assertEquals(2, root.getChildrenSet().size()) ;
        assertEquals( 5 , root.getDescendents().size()) ;
        assertEquals("multi child" , root.getChildren().get(2).getName()) ;
        try {
            dependencyGraph.addDependency(5,3) ;
        } catch (InvalidNodeIdException e) {
            e.printStackTrace();
        } catch (CyclicDependencyException e) {
            e.printStackTrace();
        }
        assertTrue(dependencyGraph.getIdToNodeMap().get(3).getParents().containsKey(5));
    }

}