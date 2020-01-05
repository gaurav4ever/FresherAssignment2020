package Assignment3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;


public class Main{
  public static Scanner sc = new Scanner(System.in);
  public static void main(String args[]){
    FamilyTree treeObj = new FamilyTree();
    Boolean flag = true;
    while(flag){
      System.out.println("Choices :\n"+
      " 1. Add New Node\n"+
      " 2. Add New Dependency\n"+
      " 3. Delete Dependency\n"+
      " 4. Get Imediate Parent of a Node\n"+
      " 5. Get Imediate Child of a Node\n"+
      " 6. Get Ancestors of a Node\n"+
      " 7. Get Decendents of a Node\n"+
      " 8. Delete a Node\n"+
      " 0. Exit\n"
      );
      int choice = sc.nextInt();
      switch(choice){
        case 1 :
         System.out.print("Enter the name of node : "); 
         String name = sc.next();
         System.out.println("** Enter the Additional info for node ( press 0 to end info ) ***  ");
         HashMap<String,String> info  = new HashMap<String,String>();
         while(true){
           System.out.print("Enter key : ");
           String key = sc.next();
           if(key.equals("0")){
             break;
           }
           System.out.print("Enter value : ");
           String value = sc.next();
           info.put(key,value);
         }
         System.out.println("Node is created : " + treeObj.addNewNode(name,info));
         break;

        case 2 : 
          System.out.print("Enter the Parent Node Id : ");
          int parentNodeId = sc.nextInt();
          System.out.print("\nEnter the Child Node Id");
          int childNodeId = sc.nextInt();
          try{
            treeObj.addDependency(parentNodeId,childNodeId);
            System.out.println("Depenedency added");
          }catch(Exception e){
            System.out.print(e);
          }
          break;

        case 3: 
          System.out.print("Enter the Parent Node Id : ");
          parentNodeId = sc.nextInt();
          System.out.print("\nEnter the Child Node Id");
          childNodeId = sc.nextInt();
          try{
            treeObj.deleteDependency(parentNodeId,childNodeId);
            System.out.println("dependency deleted");
          }catch(Exception e){
            System.out.println(e);
          }
          break;

        case 4:
          System.out.print("Enter the nodeId : ");
          int nodeId = sc.nextInt();
          try{
            TreeSet<Node> imediateParentNode = treeObj.getImediateParents(nodeId);
            System.out.println(imediateParentNode);
          }catch(Exception e){
            e.printStackTrace();
          }
          break;
        case 5: 
          System.out.print("Enter the node id : ");
          nodeId = sc.nextInt();
          try{
            TreeSet<Node> imediateChildNode = treeObj.getImediateChilds(nodeId);
            System.out.println(imediateChildNode);
          }catch(Exception e){
            e.printStackTrace();
          }
          break;
        case 6: 
          System.out.println("Enter the node id : ");
          nodeId = sc.nextInt();
          try{
            TreeSet<Node> ancestors = treeObj.getAncestors(nodeId, new TreeSet<Node>());
            System.out.println(ancestors);
          }catch(Exception e){
            e.printStackTrace();
          }
          break;
        
        case 7: 
          System.out.println("Enter the node id : ");
          nodeId = sc.nextInt();
          try{
            TreeSet<Node> decendetns = treeObj.getDecendents(nodeId, new TreeSet<Node>());
            System.out.println(decendetns); 
          }catch(Exception e){
            e.printStackTrace();
          }
          break;
        case 8: 
          System.out.println("Enter the node id : ");
          nodeId = sc.nextInt();
          try{
            treeObj.deleteNode(nodeId); 
          }catch(Exception e){
            e.printStackTrace();
          }
          break;
        case 0: 
          flag = false;
        break;
        default : 
          System.out.println("Invalid choice");
      }
    }
  }
}