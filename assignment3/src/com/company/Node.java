package assignment3.src.com.company;

import java.util.HashMap;

public class Node {
    public int id;
    public String name;
    public HashMap<Integer, Node> children;

    Node( final int identity, final String name ){
        this.id = identity;
        this.name = name;
        this.children = new HashMap<>();
    }
}
