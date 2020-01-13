package assignment3;

import assignment3.models.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;


public class FamilyTree {
  
  private HashMap<Integer, Node> nodeIdToNodeMap;
  private int size;

  public FamilyTree(){
    size = 0;
    nodeIdToNodeMap = new HashMap<Integer,Node> ();
  }

  public int getSize(){
    return size;
  }

  public Node addNewNode(String name, HashMap<String,String> info){
   Node tempNode = new Node(++size,name,info);
   nodeIdToNodeMap.put(tempNode.nodeId, tempNode);
   return tempNode;
  }

  public boolean dfs(Node curNode, Node searchNode, HashSet<Node> visitedNode){
    visitedNode.add(curNode);
    if(searchNode == curNode){
         return true;
    }
    for(Node childNode : curNode.child){
      if(visitedNode.contains(childNode) == false){
        if(dfs(childNode,searchNode,visitedNode)){
          return true;
        }
      }
    }
    return false;
  }

  public Boolean checkCycle(Node sourceNode, Node searchNode){
    HashSet<Node> visitedNode = new HashSet<Node>();
    return dfs(sourceNode,searchNode,visitedNode);
  }

  public Boolean addDependency(int parentNodeId, int childNodeId)throws Exception{
    if(nodeIdToNodeMap.containsKey(parentNodeId) == false){
      throw new Exception("parentNodeId does not exist\n");
    }
    if(nodeIdToNodeMap.containsKey(childNodeId) == false){
      throw new Exception("childNodeId not exist\n");
    }
    Node parentNode = nodeIdToNodeMap.get(parentNodeId);
    Node childNode = nodeIdToNodeMap.get(childNodeId);
    System.out.println(" node are " + parentNode + childNode);
    if(checkCycle(childNode,parentNode)){
      throw new Exception("Given Dependency creating cycle");
    }
    parentNode.child.add(childNode);
    childNode.parent.add(parentNode);
    return true;
  }

  public Boolean deleteDependency(int parentNodeId,int childNodeId)throws Exception{
     if(nodeIdToNodeMap.containsKey(parentNodeId) == false){
      throw new Exception("parentNodeId not exist\n");
   
    }
    if(nodeIdToNodeMap.containsKey(childNodeId) == false){
      throw new Exception("childNodeId not exist\n");
      
    }
    Node parentNode = nodeIdToNodeMap.get(parentNodeId);
    Node childNode = nodeIdToNodeMap.get(childNodeId);
    System.out.println(" node are " + parentNode + childNode);
    parentNode.child.remove(childNode);
    childNode.parent.remove(parentNode);
    return true;
  }

  public TreeSet<Node> getImediateParents(int nodeId) throws Exception{
    if(nodeIdToNodeMap.containsKey(nodeId)==false){
      throw new Exception("node does not exist");
    }
    Node curNode = nodeIdToNodeMap.get(nodeId);
    return curNode.parent;
  }

  public TreeSet<Node> getImediateChilds(int nodeId)throws Exception{
    if(nodeIdToNodeMap.containsKey(nodeId)==false){
      throw new Exception("node does not exist");
    }
    Node curNode = nodeIdToNodeMap.get(nodeId);
    return curNode.child;
  }
  
  public TreeSet<Node> getAncestors(int nodeId,TreeSet<Node> ancestors)throws Exception{
    Node curNode = nodeIdToNodeMap.get(nodeId);
    if (curNode == null) {
      throw new Exception("node does not exist");
    }
    for(Node parentNode : curNode.parent){
      ancestors.add(parentNode);
      getAncestors(parentNode.nodeId,ancestors);
    }
    return ancestors;    
  }

  public TreeSet<Node> getDecedents(int nodeId, TreeSet<Node> decendents)throws Exception{
    Node curNode = nodeIdToNodeMap.get(nodeId);
    if (curNode == null) {
      throw new Exception("node does not exist");
    }
    for(Node childNode : curNode.child){
      decendents.add(childNode);
      getDecedents(childNode.nodeId,decendents);
    }
    return decendents;
  }

  public Boolean deleteNode(int nodeId)throws Exception{
    Node curNode = nodeIdToNodeMap.get(nodeId);
    if (curNode == null) {
      throw new Exception("node does not exist");
    }
    for(Node parent :  curNode.parent){
      parent.child.remove(curNode);
    }
    for(Node child : curNode.child){
      child.parent.remove(curNode);
    }
    nodeIdToNodeMap.remove(nodeId);
    size = size - 1 ;
    return true;
  }
  
}