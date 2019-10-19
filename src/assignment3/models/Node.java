package assignment3.models;

import assignment3.exceptions.CyclicDependencyException;
import assignment3.exceptions.InvalidNodeIdException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node {
    private Integer id;

    public String getName() {
        return name;
    }

    private String name;
    /// Mapping from parentId to corresponding Node reference
    private Map<Integer, Node> parents;
    /// Mapping from childId to corresponding Node reference
    private Map<Integer, Node> children;

    private Map<String, Object> extraInfo;

    public Node(Integer id, String name) {
        this.id = id;
        this.name = name;
        parents = new HashMap<>();
        children = new HashMap<>();
        extraInfo = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addParent(Node parent) throws CyclicDependencyException {
        parents.put(parent.id, parent);
    }

    public void removeParent(Integer parentId) throws InvalidNodeIdException {
        if(!parents.containsKey(parentId)) throw new InvalidNodeIdException();
        parents.remove(parentId);
    }

    public void removeChild(Integer childId) throws InvalidNodeIdException {
        if(!children.containsKey(childId)) throw new InvalidNodeIdException();
        children.remove(childId);
    }

    public void removeExtraInfo(String key) {
        extraInfo.remove(key);
    }

    public void addChild(Node child) throws CyclicDependencyException {
        children.put(child.id, child);
    }

    public void addExtraInfo(String key, Object value) {
        extraInfo.put(key, value);
    }

    public Map<Integer, Node> getParents() {
        return parents;
    }

    public Map<Integer, Node> getChildren() {
        return children;
    }

    public Map<String, Object> getExtraInfo() {
        return extraInfo;
    }

    public Set<Node> getParentsSet() {
        return new HashSet<Node>(getParents().values());
    }

    public Set<Node> getChildrenSet() {
        return new HashSet<Node>(getChildren().values());
    }

    private void getAncestorUtil(Set<Node> parents, Set<Node> ancestors) {
        ancestors.addAll(parents);
        for (Node n : parents) {
            getAncestorUtil(n.getParentsSet(), ancestors);
        }
    }

    public Set<Node> getAncestors() {
        Set<Node> ancenstors = new HashSet<>();
        Set<Node> tempParents = new HashSet<>(getParentsSet());
        getAncestorUtil(tempParents, ancenstors);
        return ancenstors;
    }

    private void getDescendentUtil(Set<Node> children, Set<Node> descendents) {
        descendents.addAll(children);
        for (Node n : children) {
            getAncestorUtil(n.getChildrenSet(), descendents);
        }
    }

    public Set<Node> getDescendents() {
        Set<Node> descendents = new HashSet<>();
        Set<Node> tempChildren = new HashSet<>(getChildrenSet());
        getDescendentUtil(tempChildren, descendents);
        return descendents;
    }
}
