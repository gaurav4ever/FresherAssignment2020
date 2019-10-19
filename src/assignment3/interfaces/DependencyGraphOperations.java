package assignment3.interfaces;

import assignment3.exceptions.CyclicDependencyException;
import assignment3.exceptions.InvalidNodeIdException;
import assignment3.models.Node;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface DependencyGraphOperations {
    Set<Node> getParents(Integer nodeId) throws InvalidNodeIdException;
    Set<Node> getChildren(Integer nodeId) throws InvalidNodeIdException;
    Set<Node> getAncestors(Integer nodeId) throws InvalidNodeIdException;
    Set<Node> getDescendents(Integer nodeId) throws InvalidNodeIdException;
    void deleteDependency(Integer parentId , Integer childID) throws InvalidNodeIdException;
    void deleteNode(Integer nodeId) throws InvalidNodeIdException ;
    void addDependency(Integer parentId , Integer childID) throws InvalidNodeIdException , CyclicDependencyException;
    void addNode( Integer nodeId ,String name) throws InvalidNodeIdException ;
}
