package question3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Aditya
 */
class Node {

    private int id;
    private String name;
    private ArrayList<Node> parents;
    private ArrayList<Node> children;

    public Node(int id) {
        this.id = id;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Node> parents) {
        this.parents = parents;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

}

class Family {

    int id = 0;
    HashMap<Integer, Node> familyTree = new HashMap<>(); //To Store Family Nodes and Dependencies

    public boolean checkCycle(Node parent, Node child) {
        //parent should not exist in child Descendents
        Set<Node> childDes = getDescendents(child.getId());
        if (childDes.contains(parent)) {
            return true;  // cycle exist
        }
        //child should not exit in parent Ansestors
        Set<Node> parentAnc = getAncestors(parent.getId());
        if (parentAnc.contains(child)) {
            return true;
        }

        return false;
    }

    public boolean addDependency(int pId, int cId) {
        if (!familyTree.containsKey(cId) || !familyTree.containsKey(pId)) {
            return false; //Node doesnt exist
        }
        Node parent = familyTree.get(pId);
        Node child = familyTree.get(cId);

        // add dependency & check cycle
        ArrayList<Node> childToParent = child.getParents();
        childToParent.add(parent);
        child.setParents(childToParent);

        ArrayList<Node> parentToChild = parent.getChildren();
        parentToChild.add(child);
        parent.setChildren(parentToChild);

        if (checkCycle(parent, child)) {

            //cycle exite & remove this dependency
            parentToChild.remove(child);
            parent.setChildren(parentToChild);
            childToParent.remove(parent);
            child.setParents(childToParent);
            return false;
        }
        //dependency added if cycle doesnt exit
        return true;
    }

    public boolean deleteDependency(int pId, int cId) {
        if (!familyTree.containsKey(cId) || !familyTree.containsKey(pId)) {
            return false; //Nodes doesnt exist
        }
        Node parent = familyTree.get(pId);
        Node child = familyTree.get(cId);

        ArrayList<Node> childToParent = child.getParents();
        childToParent.remove(parent);
        child.setParents(childToParent);

        ArrayList<Node> parentToChild = parent.getChildren();
        parentToChild.remove(child);
        parent.setChildren(parentToChild);
        //deleted successfully
        return true;

    }

    public void getParents(int id) {

        Node node = familyTree.get(id);
        ArrayList<Node> parents = node.getParents();
        if (parents.isEmpty()) {
            System.out.println("No Parent");
            return;
        }
        for (Node parent : parents) {
            System.out.println(parent.getName());
        }
    }

    public Set<Node> getAncestorsUtil(Node currentNode, Set<Node> ancestors) {

        ArrayList<Node> parents = currentNode.getParents();
        for (Node parent : parents) {
            if (!ancestors.contains(parent)) {
                ancestors.add(parent);
                getAncestorsUtil(parent, ancestors);
            }
        }
        return ancestors;
    }

    public Set<Node> getAncestors(int id) {
        //ancestors to Store Ancestors & also to use Visited Marking
        Set<Node> ancestors = new HashSet<>();
        Node node = familyTree.get(id);
        ancestors.add(node); // To prevent visiting currentNode node again
        ancestors = getAncestorsUtil(node, ancestors);
        ancestors.remove(node);
        return ancestors;
    }

    public void getChildren(int id) {
        Node node = familyTree.get(id);
        ArrayList<Node> children = node.getChildren();
        if (children.isEmpty()) {
            System.out.println("No Children!!");
            return;
        }
        children.forEach((child) -> {
            System.out.println(child.getName());
        });
    }

    public Set<Node> getDescendentsUtil(Node currentNode, Set<Node> descendents) {

        ArrayList<Node> children = currentNode.getChildren();
        for (Node child : children) {
            if (!descendents.contains(child)) {
                descendents.add(child);

                getDescendentsUtil(child, descendents);
            }
        }
        return descendents;
    }

    public Set<Node> getDescendents(int id) {
        // to Store descendents &  use same for Visited Node Marking
        Set<Node> descendents = new HashSet<>();
        Node node = familyTree.get(id);
        descendents.add(node); // To prevent visiting currentNode node again
        descendents = getDescendentsUtil(node, descendents);
        descendents.remove(node);
        return descendents;
    }

    public int addNode(String name) {
        Node newNode = new Node(id);

        newNode.setName(name);
        familyTree.put(id, newNode);
        id++;
        return id - 1;
    }

    public boolean deleteNode(int id) {
        if (familyTree.containsKey(id)) {
            //if Node exist then delete
            familyTree.remove(id);
            return true;
        }
        return false;
    }

}

public class Question3 {

    static Family family;
    final static Scanner sc = new Scanner(System.in);

    ;
    public static void addNewNode() {

        System.out.println("Enter Node name");
        String name = sc.next();
        int id = family.addNode(name);
        System.out.println(name + " your id is : " + id);
        System.out.println("Node created succesfully");
    }

    public static void addNewDependency() {
        while (true) {
            try {
                System.out.println("Enter parent ID");
                int pid = Integer.parseInt(sc.next());
                System.out.println("Enter child ID");
                int cid = Integer.parseInt(sc.next());

                if (family.addDependency(pid, cid)) {
                    System.out.println("Dependency Added Successfully");
                    break;
                };

                System.out.println("Error!! Either Ids do not exits OR operation lead to Cyclic Dependency!!");
                System.out.println("Enter [t] to Try Again");
                if (!"t".equals(sc.next())) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Id Format!! Try Again");
            }
        }
    }

    public static void exploreNodeUtil(int id) {
        Node node = family.familyTree.get(id);
        String choice = "";

        //5 for exit
        while ("5".equals(choice)) {
            System.out.println("----------------------------" + node.getName() + "----------------------------");
            System.out.println("1. View Parents");
            System.out.println("2. View Children");
            System.out.println("3. View Ancestors");
            System.out.println("4. View Descendents");
            System.out.println("5. Go Back");
            System.out.println("-----------------------------------------------------------------");
            choice = sc.next();

            switch (choice) {

                case "1":
                    family.getParents(id);
                    break;
                case "2":
                    family.getChildren(id);
                    break;
                case "3":
                    Set<Node> ancestors = family.getAncestors(id);
                    if (ancestors.isEmpty()) {
                        System.out.println("No Ancestors exit");
                        break;
                    }
                    ancestors.forEach((ancestor) -> {
                        System.out.println(ancestor.getName());
                    });
                    break;
                case "4":
                    Set<Node> descendents = family.getDescendents(id);
                    if (descendents.isEmpty()) {
                        System.out.println("No Descendents exit");
                        break;
                    }
                    descendents.forEach((descendent) -> {
                        System.out.println(descendent.getName());
                    });
                    break;
                case "5":
                    System.out.println("Exit..");
                    break;
                default:
                    System.out.println("Invalid Input!!!");
                    break;
            }

        }
    }

    public static void exploreNode() {
        while (true) {
            try {
                System.out.println("Enter Node Id to be explored");
                int id = Integer.parseInt(sc.next());
                if (family.familyTree.containsKey(id)) {

                    exploreNodeUtil(id);

                    break;
                }
                System.out.println("Id doesn't exit!! Enter [t] to try again ");

               
                if ("t".equals(sc.next())) {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid Id Format");

            }

        }
    }

    public static void main(String[] args) {

        family = new Family();

        String choice = "";

        //5 for exit
        while (!"5".equals(choice)) {
            // Main Menu
            System.out.println("----------------------------Main Menu----------------------------");
            System.out.println("1. Add New Node");
            System.out.println("2. Add New Dependency");
            System.out.println("3. Explore a Node");
            System.out.println("4. Display Nodes");
            System.out.println("5. Exit");
            System.out.println("-----------------------------------------------------------------");
            choice = sc.next();

            switch (choice) {
                case "1":
                    addNewNode();
                    break;
                case "2":
                    addNewDependency();
                    break;
                case "3":
                    exploreNode();
                    break;
                case "4":
                    //Display Map
                    Set<Entry<Integer, Node>> familySet = family.familyTree.entrySet();
                    if (familySet.isEmpty()) {
                        System.out.println("No Node Exist");
                        break;
                    }
                    System.out.println("Id\tName");
                    for (Map.Entry<Integer, Node> entry : familySet) {
                        Node node = entry.getValue();
                        System.out.println(node.getId() + "\t" + node.getName());
                    }
                    break;
                case "5":

                    System.out.println("Exit..");
                    break;
                default:
                    System.out.println("Invalid Input!!!");
                    break;
            }

        }

    }
}
