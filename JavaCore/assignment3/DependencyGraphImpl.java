package assignment3;

import assignment3.exceptions.CyclicDependencyException;
import assignment3.exceptions.NoSuchNodeException;
import assignment3.exceptions.NodeAlreadyExistsException;
import assignment3.interfaces.DependencyGraph;
import assignment3.models.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DependencyGraphImpl implements DependencyGraph {
    private Map<Integer, Node> idToNodeMap;
    private Node root;

    public DependencyGraphImpl(Node root) {
        this.root = root;
        idToNodeMap = new HashMap<>();
        idToNodeMap.put(root.getId(), root);
    }

    public Map<Integer, Node> getIdToNodeMap() {
        return idToNodeMap;
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public Set<Node> getParents(Integer nodeId) throws NoSuchNodeException {
        if (!idToNodeMap.containsKey(nodeId)) throw new NoSuchNodeException("No such node : " + nodeId);
        return idToNodeMap.get(nodeId).getParentsSet();
    }

    @Override
    public Set<Node> getChildren(Integer nodeId) throws NoSuchNodeException {
        if (!idToNodeMap.containsKey(nodeId)) throw new NoSuchNodeException("No such node : " + nodeId);
        return idToNodeMap.get(nodeId).getDescendents();
    }

    @Override
    public Set<Node> getAncestors(Integer nodeId) throws NoSuchNodeException {
        if (!idToNodeMap.containsKey(nodeId)) throw new NoSuchNodeException("No such node : " + nodeId);
        return idToNodeMap.get(nodeId).getAncestors();
    }

    @Override
    public Set<Node> getDescendents(Integer nodeId) throws NoSuchNodeException {
        if (!idToNodeMap.containsKey(nodeId)) throw new NoSuchNodeException("No such node : " + nodeId);
        return idToNodeMap.get(nodeId).getDescendents();
    }

    @Override
    public void deleteDependency(Integer parentId, Integer childID) throws NoSuchNodeException {
        if (!idToNodeMap.containsKey(parentId)) throw new NoSuchNodeException("No such node : " + parentId);
        if (!idToNodeMap.containsKey(childID)) throw new NoSuchNodeException("No such node : " + childID);
        idToNodeMap.get(parentId).removeChild(childID);
        idToNodeMap.get(childID).removeParent(parentId);
    }

    private void deleteAllDescendentNodes(final Set<Node> nodes) {
        for (Node n : nodes) {
            deleteAllDescendentNodes(n.getChildrenSet());
            idToNodeMap.remove(n.getId());
        }
    }

    @Override
    public void deleteNode(Integer nodeId) throws NoSuchNodeException {
        if (!idToNodeMap.containsKey(nodeId)) throw new NoSuchNodeException("No such node : " + nodeId);
        final Set<Node> childrenSet = idToNodeMap.get(nodeId).getChildrenSet();
        final Set<Node> parentsSet = idToNodeMap.get(nodeId).getParentsSet();

        /// Remove the Node reference from all its parent nodes
        for (Node n : parentsSet) n.removeChild(nodeId);
        /// Remove all the descendent node references from the graph
        deleteAllDescendentNodes(childrenSet);
        idToNodeMap.remove(nodeId); /// remove this node from this graph
    }

    @Override
    public void addDependency(Integer parentId, Integer childID) throws NoSuchNodeException, CyclicDependencyException {
        if (!idToNodeMap.containsKey(parentId)) throw new NoSuchNodeException("No such node : " + parentId);
        if (!idToNodeMap.containsKey(childID)) throw new NoSuchNodeException("No such node : " + childID);

        Node child = idToNodeMap.get(childID);
        Node parent = idToNodeMap.get(parentId);
        if (child.getDescendents().contains(parent)) throw new CyclicDependencyException();
        if (parent.getAncestors().contains(child)) throw new CyclicDependencyException();
        idToNodeMap.get(parentId).addChild(idToNodeMap.get(childID));
        idToNodeMap.get(childID).addParent(idToNodeMap.get(parentId));
    }

    @Override
    public void addNode(Integer nodeId, String name) throws NodeAlreadyExistsException {
        if (idToNodeMap.containsKey(nodeId))
            throw new NodeAlreadyExistsException("Node with id : " + nodeId + " already exists in the graph ! ");
        idToNodeMap.put(nodeId, new Node(nodeId, name == null ? nodeId.toString() : name));
    }
}
