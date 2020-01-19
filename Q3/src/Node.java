import java.util.HashMap;

public class Node {
    int id;
    String name;
    HashMap<Integer, Node> children;

    public Node(int id,String name)
    {
        this.id = id;
        this.name = name;
        this.children = new HashMap<>();
    }

    public void add(int id,String name,int[] children)
    {
        this.id = id;
        this.name = name;
    }
    public void fetchNodeInfo(int id)
    {
        System.out.println("ID : "+id+" Name : "+name+" Children : ");
        for(Integer i : children.keySet()){
            System.out.println(i);
        }

    }
}