// Java program to implement Graph
// with the help of Generics

import java.util.*;

class Graph<T> {

    // We use Hashmap to store the edges in the graph
    private Map<T, Set<T>> map = new HashMap<>();
    public List<Integer> ancestors;

    public Graph() {
        this.ancestors = new LinkedList<>();
    }

    // This function adds a new vertex to the graph
    public void addVertex(T s) {
        map.put(s, new HashSet<>());
    }

    // This function adds the edge
    // between source to destination
    public void addEdge(T source, T destination, boolean bidirectional) {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    // This function gives the count of vertices
    public void getVertexCount() {
        System.out.println("The graph has "
                + map.keySet().size()
                + " vertex");
    }

    // This function gives the count of edges
    public void getEdgesCount(boolean bidirection) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }

    // This function gives whether a vertex is present or not.
    public void hasVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains "
                    + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain "
                    + s + " as a vertex.");
        }
    }

    // This function gives whether an edge is present or not.
    public void hasEdge(T s, T d) {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between "
                    + s + " and " + d + ".");
        } else {
            System.out.println("The graph has no edge between "
                    + s + " and " + d + ".");
        }
    }


    public void remove(int s, int d) {
        map.get(s).remove(d);
    }

    public void rem(int s) {
        map.remove(s);
    }


    public List<Integer> getImmediateParents(int node) {
        List<Integer> list = new LinkedList<>();
        for (Map.Entry<T, Set<T>> li : map.entrySet()) {
            if (li.getValue().contains(node))
                list.add((Integer) li.getKey());
        }
        return list;
    }


    public String getImmediateChildrens(int node) {
        return map.get(node).toString();
    }


    public Set<Integer> getAncestors(int node) {
        ancestors = new LinkedList<>();
        for (Map.Entry<T, Set<T>> li : map.entrySet()) { // first checking for the current node
            if (li.getValue().contains(node))
                ancestors.add((Integer) li.getKey());
        }
        for (int i = 0; i < ancestors.size(); i++) {
            for (Map.Entry<T, Set<T>> li : map.entrySet()) { // iterating the list upto last to get every node parents
                if (li.getValue().contains(ancestors.get(i)))
                    ancestors.add((Integer) li.getKey());
            }
        }
        Set<Integer> set = new HashSet<>(ancestors); // using set to remove repeated elements
        return set;
    }

    public void getChildrensUtil(int node, Set<Integer> result) {
        Set<T> childrens = map.get(node);
    }

    public String getChildrens(int node) {
        Set<Integer> result = new HashSet<Integer>();
        getChildrensUtil(node, result);
        return result.toString();
    }

    public boolean checkCycle(int source, int destination) {
        //parent should not exist in child Descendents
        Set<Node> childDes = getChildrens(destination);

        if (childDes.contains(source)) {
            return true;  // cycle exist
        }
        //child should not exit in parent Ansestors
        Set<Node> parentAnc = getAncestors(source);
        if (parentAnc.contains(destination)) {
            return true;
        }
        return false;
    }

}