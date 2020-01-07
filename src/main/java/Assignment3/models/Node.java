package Assignment3.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node {
    private String name;
    private Integer id;
    private List<Integer> childrens;

    public Node() {
        childrens = new ArrayList<>();
    }

    public Node(String name, Integer id) {
        childrens = new ArrayList<>();
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getchildrens() {
        return childrens;
    }

    public void setDependency(List<Integer> childrens) {
        this.childrens = childrens;
    }
}
