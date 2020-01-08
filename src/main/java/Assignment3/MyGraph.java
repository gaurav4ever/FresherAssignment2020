package Assignment3;

import Assignment3.exceptions.DependencyAlreadyExist;
import Assignment3.exceptions.DependencyDoesNotExist;
import Assignment3.exceptions.NodeNotExist;
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
        if(!graph.containsKey(parentId)) try {
            throw new NodeNotExist("Parent node with id "+parentId+" not exist");
        } catch (NodeNotExist nodeNotExist) {
            nodeNotExist.printStackTrace();
        }
        if(!graph.containsKey(childId)) try {
            throw new NodeNotExist("Child node with id "+childId+" not exist");
        } catch (NodeNotExist nodeNotExist) {
            nodeNotExist.printStackTrace();
        }
        if(graph.get(parentId).getchildrens().contains(childId)) try {
            throw new DependencyAlreadyExist("Dependency already Exist");
        } catch (DependencyAlreadyExist dependencyAlreadyExist) {
            dependencyAlreadyExist.printStackTrace();
        }
        graph.get(parentId).getchildrens().add(childId);
        System.out.println("Dependency added successfully");
        return false;
    }

    @Override
    public boolean deleteDependency(Integer parentId, Integer childId) {
        if(!graph.get(parentId).getchildrens().contains(childId)) try {
            throw new DependencyDoesNotExist("Dependency doesn't Exist");
        } catch (DependencyDoesNotExist dependencyDoesNotExist) {
            dependencyDoesNotExist.printStackTrace();
        }
        graph.get(parentId).getchildrens().remove(childId);
        System.out.println("Dependency deleted successfully");
        return false;
    }

    @Override
    public boolean deleteNode(Integer nodeId) {
        if(!graph.containsKey(nodeId)) try {
            throw new NodeNotExist("Node with id "+nodeId+" not exist");
        } catch (NodeNotExist nodeNotExist) {
            nodeNotExist.printStackTrace();
        }
        for(Node node: graph.values())
            node.getchildrens().remove(nodeId);
        graph.remove(nodeId);
        System.out.println("Node deleted successfully");
        return false;
    }

    @Override
    public boolean addNode(Integer nodeId, String nodeName) {
        if(graph.containsKey(nodeId)) try {
            throw new NodeNotExist("Node with id "+nodeId+" already exist");
        } catch (NodeNotExist nodeNotExist) {
            nodeNotExist.printStackTrace();
        }
        graph.put(nodeId, new Node(nodeName, nodeId));
        System.out.println("Node added successfully");
        return false;
    }

    @Override
    public List<Integer> getParents(Integer nodeId) {
        if(!graph.containsKey(nodeId)) try {
            throw new NodeNotExist("Node with id "+nodeId+" not exist");
        } catch (NodeNotExist nodeNotExist) {
            nodeNotExist.printStackTrace();
        }
        List<Integer> parents = new ArrayList<>();
        for (Node node: graph.values())
            if(node.getchildrens().contains(nodeId))
                parents.add(node.getId());

        return parents;
    }

    @Override
    public List<Integer> getChildrens(Integer nodeId) {
        if(!graph.containsKey(nodeId)) try {
            throw new NodeNotExist("Node with id "+nodeId+" not exist");
        } catch (NodeNotExist nodeNotExist) {
            nodeNotExist.printStackTrace();
        }
        return graph.get(nodeId).getchildrens();
    }

    @Override
    public List<Integer> getAncestors(Integer nodeId) {
        if(!graph.containsKey(nodeId)) try {
            throw new NodeNotExist("Node with id "+nodeId+" not exist");
        } catch (NodeNotExist nodeNotExist) {
            nodeNotExist.printStackTrace();
        }
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
        if(!graph.containsKey(nodeId)) try {
            throw new NodeNotExist("Node with id "+nodeId+" not exist");
        } catch (NodeNotExist nodeNotExist) {
            nodeNotExist.printStackTrace();
        }
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
