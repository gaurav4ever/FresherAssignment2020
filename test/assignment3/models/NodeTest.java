package assignment3.models;

import assignment3.exceptions.CyclicDependencyException;
import assignment3.exceptions.NoSuchNodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node orphanNode;
    Node rootNode;
    Node leafNode;

    @BeforeEach
    void init() {
        orphanNode = new Node(0, "orphan");
        leafNode = new Node(2, "leaf");
        rootNode = new Node(1, "root");
        try {
            leafNode.addParent(new Node(1 , "p1"));
            rootNode.addChild(new Node(2, "c1"));
            rootNode.addChild(new Node(3, "c2"));
            rootNode.getChildren().get(2).addChild(new Node(4, "c3"));

        } catch (CyclicDependencyException e) {
            e.printStackTrace();
        }

    }

    @Test
    void getId() {
        assertEquals(orphanNode.getId(), 0);
        assertEquals(rootNode.getId(), 1);
    }


    @Test
    void addParent() {
        try {
            rootNode.addParent(new Node(10 , "parent"));
            assertEquals(rootNode.getParentsSet().iterator().next().getId() , 10) ;
        } catch (CyclicDependencyException e) {
            e.printStackTrace();
        }
    }

    @Test
    void removeParent() {
        try {
            leafNode.removeParent(1);
        } catch (NoSuchNodeException e) {
            e.printStackTrace();
        }
        assertThrows(NoSuchNodeException.class , ()->leafNode.removeParent(1));
        assertThrows(NoSuchElementException.class, ()->leafNode.getParentsSet().iterator().next());
    }

    @Test
    void removeChild() {
        try {
            rootNode.removeChild(2);
        } catch (NoSuchNodeException e) {
            e.printStackTrace();
        }
        assertEquals(rootNode.getChildrenSet().size() , 1);
        assertThrows(NoSuchNodeException.class,()-> rootNode.removeChild(2)) ;
        assertEquals(rootNode.getChildren().get(3).getId() ,3 );
    }

    @Test
    void addChild() {
        try {
            orphanNode.addChild(new Node(0 , "new")) ; //Duplicate node
            orphanNode.addChild(new Node(2,"new")) ;
        } catch (CyclicDependencyException e) {
            e.printStackTrace();
        }
        assertEquals(orphanNode.getChildrenSet().iterator().next().getId() , 0) ;
    }

    @Test
    void addExtraInfo() {
        rootNode.addExtraInfo("extra1" , 1);
        assertEquals(rootNode.getExtraInfo().get("extra1") , 1); ;
    }

    @Test
    void getParents() {
        Map<Integer, Node> parents = leafNode.getParents();
        assertTrue(parents.containsKey(1));
        assertTrue(parents.get(1).getId()==1) ;
    }

    @Test
    void getChildren() {
        Map<Integer, Node> children = rootNode.getChildren();
        assertFalse(children.containsKey(1)); ;
        assertTrue(children.containsKey(2)) ;
        assertTrue(children.get(2).getChildren().get(4).getId()==4) ;
    }

    @Test
    void getExtraInfo() {
       rootNode.getExtraInfo().get("extra")  ;
    }

    @Test
    void getParentsSet() {
        assertEquals(orphanNode.getParentsSet().size(), 0);
   }

    @Test
    void getChildrenSet() {
        assertEquals(orphanNode.getChildrenSet().size(), 0);
        assertNotEquals(rootNode.getChildrenSet().size(), 0);
        assertTrue(rootNode.getChildrenSet().size()>0);
        assertEquals(rootNode.getChildrenSet().size() , 2);
    }

    @Test
    void getAncestors() {
        assertFalse(rootNode.getChildren().get(2).getAncestors().iterator().hasNext()) ;
        assertEquals(leafNode.getAncestors().iterator().next().getId() , 1);
    }

    @Test
    void getDescendents() {
        assertEquals(rootNode.getDescendents().size(),3);
    }
}