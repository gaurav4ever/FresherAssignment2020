package assignment3.src.com.company;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Operations {
    String name;
    Boolean flag, verify;
    Scanner sc = new Scanner(System.in);
    Map<Integer, Node> graph = new HashMap<Integer, Node>();

    boolean menu() {
        int choice, parentId = 0, childID = 0, nodeId;
        System.out.println("Enter Choice (1 for Get Parent, 2 for Get child, 3 for Getting Ancestors, 4 for Getting Descendors, 5 for Deleting Dependancy, 6 for Deleting node, 7 for adding a new Dependency and 8 for Adding a New Node, 9 to Terminate ) ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter Node Id: ");
                nodeId = readVerifyId();
                printParent(nodeId);
                break;
            case 2:
                System.out.println("Enter the Node Id for getting child");
                nodeId = readVerifyId();
                printChildren(nodeId);
                break;
            case 3:System.out.println("Enter the Node ID for which Ancestor is req: ");
                nodeId = readVerifyId();
                printAncestors(nodeId);
                break;
            case 4:
                System.out.println("Enter the node id for which descendor is required :");
                nodeId = readVerifyId();
                printDescendants(nodeId);
                break;
            case 5:System.out.println("Enter parent Id and Child Id");
                parentId = readVerifyId();
                childID = readVerifyId();
                deleteDependency(parentId, childID);
                break;
            case 6:System.out.println("Enter Id for node to delete");
                nodeId = readVerifyId();
                deleteNode(nodeId);
                break;
            case 7:
                System.out.println("Enter The Parent Id and Child Id : ");
                parentId = readVerifyId();
                childID = readVerifyId();
                addDependency(parentId,childID);
                System.out.println("Dependency added");
                break;
            case 8:
                addNode();
                break;
            case 9: return FALSE;
            default: System.out.println("Input out of range, enter b/w 1-9");
        }
        return TRUE;
    }

    int readVerifyId(){
        int temId = 0, flag1 = 0;
        try {
            do {
                temId = sc.nextInt();
                for(Integer identity: graph.keySet()) {
                    if (identity == temId) {
                        flag1 = 1;
                        return temId;
                    }
                }
                if(flag1 == 0){
                    System.out.println("Id not present");
                }
            } while (!verify);
        }catch (NumberFormatException e){
            System.out.println("Not a Valid ID");
        }
        return temId;
    }

    void deleteNode(int id){
        graph.remove(id);
    }

    void deleteDependency(int parentId, int childID){
        graph.get(parentId).children.remove(childID);
    }

    public List<Integer> getDescendants(int id) {
        List<Integer> descendants = new ArrayList<>();
        descendants.addAll(graph.get(id).children.keySet());

        for (Integer i : graph.get(id).children.keySet()) {
            descendants.addAll(getDescendants(i));
        }
        return descendants;
    }

    public void printDescendants(int id) {
        // id as a flag
        System.out.println("Dedcendants are:");
        List<Integer> descendants = getDescendants(id);
        System.out.println(descendants);
    }

    void printChildren(int id){
        System.out.println("Children for the id" + id + "are");
        System.out.println(graph.get(id).children.keySet());
    }

    void printParent(int id){
        System.out.println("Parents for the id " + id + "are: ");
        for(Node node:graph.values()){
            if(node.children.containsKey(id)){
                System.out.println(node.id);
            }
        }
    }

    int readId() {
        int temId = 0;
        try {
            do {
                temId = sc.nextInt();
                verify = checkID(temId);
                if (!verify)
                    System.out.println("ID added");
            } while (verify);
        }catch (NumberFormatException e){
            System.out.println("Not a Valid ID");
        }
        return temId;
    }

    boolean checkID(int id){
        for(Integer identity: graph.keySet()) {
            if (identity == id) {
                System.out.println("ID :" + id + " is already present");
                return TRUE;
            }
        }
        return FALSE;
    }

    void addNode(){
        int id;
        flag = FALSE;
        System.out.println(" Enter ID ");
        id = readId();
        sc.nextLine();
        System.out.println("Enter Name: ");
        name = sc.nextLine();
        Node n = new Node(id, name);
        graph.put(id,n);
    }

    void addDependency(int parentId, int childId){
        graph.get(parentId).children.put(childId, graph.get(childId));
    }

    public List<Integer> getAncestors(int id) {
        List<Integer> parents = new ArrayList<>();
        for (Node node : graph.values())
            if (node.children.containsKey(id))
                parents.add(node.id);

        List<Integer> ancestors = new ArrayList<>(parents);
        for (Integer i : parents)
            ancestors.addAll(getAncestors(i));
        return ancestors;
    }

    public void printAncestors(int id) {
        // id as a flag
        System.out.println("Ancestors are:");
        List<Integer> ancestors;
        ancestors = getAncestors(id);
        for (Integer ancestor : ancestors)
            System.out.print(ancestor + " , ");
        System.out.println("");
    }

}

