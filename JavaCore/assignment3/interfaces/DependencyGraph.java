package assignment3.interfaces;

import assignment3.exceptions.CyclicDependencyException;
import assignment3.exceptions.NoSuchNodeException;
import assignment3.exceptions.NodeAlreadyExistsException;
import assignment3.models.Node;

import java.util.Set;

public interface DependencyGraph {
    Set<Node> getParents(Integer nodeId) throws NoSuchNodeException;

    Set<Node> getChildren(Integer nodeId) throws NoSuchNodeException;

    Set<Node> getAncestors(Integer nodeId) throws NoSuchNodeException;

    Set<Node> getDescendents(Integer nodeId) throws NoSuchNodeException;

    void deleteDependency(Integer parentId, Integer childID) throws NoSuchNodeException;

    void deleteNode(Integer nodeId) throws NoSuchNodeException;

    void addDependency(Integer parentId, Integer childID) throws NoSuchNodeException, CyclicDependencyException;

    void addNode(Integer nodeId, String name) throws NodeAlreadyExistsException;
}
