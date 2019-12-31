package Assignment3;

import Assignment3.interfaces.DependencyGraph;
import Assignment3.models.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MyGraph implements DependencyGraph {

    private HashMap<Integer, Node> graph;

    MyGraph(){
        graph = new HashMap<>();
    }

    @Override
    public boolean addDependency(Integer parentId, Integer childId) {
        /*
        TODO: Check wether node exists or not
         */
        graph.get(parentId).getchildrens().add(childId);
        return false;
    }

    @Override
    public boolean deleteDependency(Integer parentId, Integer childId) {
        /*
        TODO: Check existance of dependency
         */
        graph.get(parentId).getchildrens().remove(childId);
        return false;
    }

    @Override
    public boolean deleteNode(Integer nodeId) {
        /*
        TODO: Check wether node exist or not
         */
        for(Node node: graph.values())
            node.getchildrens().remove(nodeId);
        graph.remove(nodeId);
        return false;
    }

    @Override
    public boolean addNode(Integer nodeId, String nodeName) {
        /*
        TODO: check node with same id exist or not
         */
        graph.put(nodeId, new Node(nodeName, nodeId));
        return false;
    }

    @Override
    public List<Integer> getParents(Integer nodeId) {
        /*
        TODO: Check node exist or not
         */
        List<Integer> parents = new ArrayList<>();
        for (Node node: graph.values())
            if(node.getchildrens().contains(nodeId))
                parents.add(node.getId());

        return parents;
    }

    @Override
    public List<Integer> getChildrens(Integer nodeId) {
        /*
        TODO: Check node exist or not
         */
        return graph.get(nodeId).getchildrens();
    }

    @Override
    public List<Integer> getAncestors(Integer nodeId) {
        /*
        TODO: Check node exist or not
         */
        List<Integer> ancestors = new ArrayList<>();
        List<Integer> parents = new ArrayList<>(getParents(nodeId));
        while(!parents.isEmpty()){
            int parent = parents.get(0);
            parents.remove(0);
            ancestors.add(parent);
            parents.addAll(getParents(parent));
            parents = parents.stream().distinct().collect(Collectors.toList());
        }
        return ancestors;
    }

    @Override
    public List<Integer> getDescendants(Integer nodeId) {
        /*
        TODO: Check node exist or not
         */
        List<Integer> decendants = new ArrayList<>();
        List<Integer> childrens = new ArrayList<>(getChildrens(nodeId));
        while(!childrens.isEmpty()){
            int children = childrens.get(0);
            childrens.remove(0);
            decendants.add(children);
            childrens.addAll(getParents(children));
            childrens = childrens.stream().distinct().collect(Collectors.toList());
        }
        return decendants;
    }
}
