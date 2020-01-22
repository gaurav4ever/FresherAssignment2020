package assignment3.src.com.company;

import java.util.HashMap;

public class Node {
    public int id;
    private String name;
    HashMap<Integer, Node> children;


    Node(int id, String name){
        this.id = id;
        this.name = name;
        this.children = new HashMap<>();
    }
}
