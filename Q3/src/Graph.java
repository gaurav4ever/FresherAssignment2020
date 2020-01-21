import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Graph {
    Scanner scan = new Scanner(System.in);
    HashMap<Integer, Node> graph = new HashMap<Integer, Node>();

    public int graphOperationMenu() {
        int choice;
        System.out.println("\n\n Menu : ");
        System.out.println("1. Get immediate parent of : (ID)");
        System.out.println("2. Get immediate child of : (ID)");
        System.out.println("3. Get ancestors of : (ID)");
        System.out.println("4. Get descendants of (ID)");
        System.out.println("5. Delete dependency between parent node(ID) and child node(ID) : ");
        System.out.println("6. Delete a node and its related dependencies (ID) : ");
        System.out.println("7. Add new dependency between parent node(ID) and child node(ID) : ");
        System.out.println("8. Add new node : ");
        System.out.println("9. Exit");
        System.out.println("Enter choice : ");
        choice = scan.nextInt();
        return choice;
    }

    public void getParent() {
        System.out.println("Enter ID :");
        int id = scan.nextInt();
        if (!graph.containsKey(id)) {
            System.out.println("Node with id : " + id + " does not exist");
        }
        List<Integer> parents = new ArrayList<>();
        for (Node node : graph.values())
            if (node.children.containsKey(id))
                parents.add(node.id);

        System.out.println("Parents of node with ID : " + id + " is ");
        for (Integer i : parents)
            System.out.println(i.intValue());

    }

    public void getChildren() {
        System.out.println("Enter ID of parent whose children to be found :");
        int id = scan.nextInt();
        System.out.println("Children are : " + graph.get(id).children.keySet());
    }

    public void addNode() {
        System.out.println("Enter ID : ");
        int id = scan.nextInt();
        for (Integer i : graph.keySet()) {
            if (graph.containsKey(id)) {
                System.out.println("ID " + id + " already exists!, re-enter ID :");
                id = scan.nextInt();
            }
        }
        System.out.println("Enter name : ");
        String name = scan.next();
        Node n = new Node(id, name);
        graph.put(id, n);
    }

    public List<Integer> getAncestors(int nodeId) {
        List<Integer> parents = new ArrayList<>();
        for (Node node : graph.values())
            if (node.children.containsKey(nodeId))
                parents.add(node.id);

        List<Integer> ancestors = new ArrayList<>(parents);
        for (Integer i : parents)
            ancestors.addAll(getAncestors(i));
        return ancestors;
    }

    public void printAncestors(int nodeId) {
        // id as a flag
        if (nodeId == 0) {
            System.out.println("Enter ID of the node whose ancestors to be found : ");
            nodeId = scan.nextInt();
            System.out.println("Ancestors are : ");
        }
        List<Integer> ancestors;
        ancestors = getAncestors(nodeId);
        for (Integer ancestor : ancestors)
            System.out.print(ancestor + " , ");
    }

    public List<Integer> getDescendants(int nodeId) {
        List<Integer> descendants = new ArrayList<>();
        descendants.addAll(graph.get(nodeId).children.keySet());

        for (Integer i : graph.get(nodeId).children.keySet()) {
            descendants.addAll(getDescendants(i));
        }
        return descendants;
    }

    public void printDescendants(int nodeId) {
        // id as a flag
        if (nodeId == 0) {
            System.out.println("Enter ID of the node whose descendants to be found : ");
            nodeId = scan.nextInt();
            System.out.println("Descendants are : ");
        }
        List<Integer> descendants = getDescendants(nodeId);
        System.out.println(descendants);
    }

    public void deleteDependency() {
        System.out.println("Enter parent ID and children ID whose dependency to be deleted : ");
        int id1 = scan.nextInt();
        int id2 = scan.nextInt();
        graph.get(id1).children.remove(id2);
    }

    public void deleteNode() {
        System.out.println("Enter ID of the node to be deleted");
        int id = scan.nextInt();
        graph.remove(id);
    }

    public Graph() {
        Node n1 = new Node(123, "GrandGrandFather");
        Node n2 = new Node(124, "GrandFather");
        Node n3 = new Node(125, "Father");
        Node n4 = new Node(126, "Mother");
        Node n5 = new Node(127, "GrandMother");
        Node n6 = new Node(128, "GrandGrandMother");
        Node n7 = new Node(129, "child");
        Node n8 = new Node(130, "GrandChild");
        Node n9 = new Node(131, "GrandGrandChild");

        graph.put(123, n1);
        graph.put(124, n2);
        graph.put(125, n3);
        graph.put(126, n4);
        graph.put(127, n5);
        graph.put(128, n6);
        graph.put(129, n7);
        graph.put(130, n8);
        graph.put(131, n9);

        addDependency(123, 124, 0);
        addDependency(124, 125, 0);
        addDependency(125, 129, 0);
        addDependency(126, 129, 0);
        addDependency(127, 126, 0);
        addDependency(128, 127, 0);
        addDependency(129, 130, 0);
        addDependency(130, 131, 0);
    }

    public void addDependency(int parentId, int childId, int flag) {
        if (flag == 1) {
            System.out.println("Enter Parent ID and Children ID :");
            parentId = scan.nextInt();
            childId = scan.nextInt();
            checkCycle(parentId, childId);
            graph.get(parentId).children.put(childId, graph.get(childId));
        } else {
            checkCycle(parentId, childId);
            graph.get(parentId).children.put(childId, graph.get(childId));
        }
    }

    public void checkCycle(int parentId, int childId) {
        List<Integer> ancestors = new ArrayList<>();
        ancestors = getAncestors(parentId);
        if (ancestors.contains(childId) || parentId == childId) {
            System.out.println("It is a cycle, re-enter parent and child IDs :");
            parentId = scan.nextInt();
            childId = scan.nextInt();
            addDependency(parentId, childId, 0);
        }
    }
}
