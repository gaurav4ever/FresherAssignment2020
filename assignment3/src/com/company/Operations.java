package assignment3.src.com.company;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Operations {
    private String name;
    private boolean flag;
    private boolean verify;
    private Scanner scanner = new Scanner(System.in);
    Map<Integer, Node> graph = new HashMap<>();

    public boolean menu() {
        int choice;
        int parentId = 0;
        int childID = 0;
        int nodeId;
        System.out.println("Enter Choice (1 for Get Parent, 2 for Get child, 3 for Getting Ancestors, 4 for Getting Descannerendors, 5 for Deleting Dependancy, 6 for Deleting node, 7 for adding a new Dependency and 8 for Adding a New Node, 9 to Terminate ) ");
        choice = scanner.nextInt();
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
                addDependency( parentId, childID );
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

    public int readVerifyId(){
        int temId = 0;
        int flag1 = 0;
        try {
            do {
                temId = scanner.nextInt();
                for( final Integer identity: graph.keySet() ) {
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

    public void deleteNode( final int id ){
        graph.remove(id);
    }

    public void deleteDependency( final int parentId, final int childID ){
        graph.get(parentId).children.remove(childID);
    }

    public List<Integer> getDescendants( final int id ) {
        final List<Integer> descendants = new ArrayList<>();
        descendants.addAll(graph.get(id).children.keySet());

        for ( final Integer i : graph.get(id).children.keySet() ) {
            descendants.addAll(getDescendants(i));
        }
        return descendants;
    }

    public void printDescendants( final int id ) {
        // id as a flag
        System.out.println("Dedcendants are:");
        final List<Integer> descendants = getDescendants(id);
        System.out.println(descendants);
    }

    public void printChildren( final int id ){
        System.out.println("Children for the id" + id + "are");
        System.out.println(graph.get(id).children.keySet());
    }

    public void printParent( final int id ){
        System.out.println("Parents for the id " + id + "are: ");
        for( final Node node:graph.values() ) {
            if(node.children.containsKey(id)){
                System.out.println(node.id);
            }
        }
    }

    public int readId() {
        int temId = 0;
        try {
            do {
                temId = scanner.nextInt();
                verify = checkID(temId);
                if (!verify) {
                    System.out.println("ID added");
                }
            } while (verify);
        }catch (NumberFormatException e){
            System.out.println("Not a Valid ID");
        }
        return temId;
    }

    /* default */boolean checkID( final int id ){
        for( final Integer identity: graph.keySet() ) {
            if (identity == id) {
                System.out.println("ID :" + id + " is already present");
                return TRUE;
            }
        }
        return FALSE;
    }

    /* default */void addNode(){
        int id;
        System.out.println(" Enter ID ");
        id = readId();
        scanner.nextLine();
        System.out.println("Enter Name: ");
        name = scanner.nextLine();
        final Node n = new Node(id, name);
        graph.put(id,n);
    }

    /* default */void addDependency( final int parentId, final int childId ){
        graph.get(parentId).children.put(childId, graph.get(childId));
    }

    /* default */public List<Integer> getAncestors( final int id ) {
        final List<Integer> parents = new ArrayList<>();
        for ( final Node node : graph.values() ) {
            if (node.children.containsKey(id)) {
                parents.add(node.id);
            }
        }

        final List<Integer> ancestors = new ArrayList<>(parents);
        for ( final Integer i : parents ) {
            ancestors.addAll(getAncestors(i));
        }
        return ancestors;
    }

    /* default */public void printAncestors( final int id ) {
        // id as a flag
        System.out.println("Ancestors are:");
        List<Integer> ancestors;
        ancestors = getAncestors(id);
        for ( final Integer ancestor : ancestors ) {
            System.out.print(ancestor + " , ");
        }
        System.out.println("");
    }

}

