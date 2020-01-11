package assignment3.models;

import java.util.HashMap;
import java.util.TreeSet;

public class Node implements Comparable<Node> {
  public int nodeId;
  public String nodeName;
  public HashMap<String, String> additionalInfo;
  public TreeSet<Node> parent;
  public TreeSet<Node> child;

  public Node(int id, String name, HashMap<String, String> info) {
    nodeName = name;
    nodeId = id;
    additionalInfo = info;
    parent = new TreeSet<Node>();
    child = new TreeSet<Node>();
  }

  public int compareTo(Node n) {
    return this.nodeId - n.nodeId;
  }

  public String toString() {
    return "Node Name : " + this.nodeName + " Node Id : " + this.nodeId + "\n";
  }
}