package com.company.main.model;
import java.util.HashMap;

public class Node {
    public int nodeId;
    String name;
    public HashMap<Integer, Node> children;

    public Node(int nodeId, String name)
    {
        this.nodeId = nodeId;
        this.name = name;
        this.children = new HashMap<>();
    }
}
