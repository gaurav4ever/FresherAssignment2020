package com.company.main;

import com.company.main.graph.GraphOperation;
import com.company.main.model.Node;

import java.util.HashMap;

public class SampleGraph {
    public void build(HashMap<Integer, Node> graph){
        Node n1 = new Node(123,"GrandGrandFather" );
        Node n2 = new Node(124,"GrandFather");
        Node n3 = new Node(125,"Father");
        Node n4 = new Node(126,"Mother");
        Node n5 = new Node(127,"GrandMother");
        Node n6 = new Node(128,"GrandGrandMother");
        Node n7 = new Node(129,"child");
        Node n8 = new Node(130,"GrandChild");
        Node n9 = new Node(131,"GrandGrandChild");

        graph.put(123,n1);
        graph.put(124,n2);
        graph.put(125,n3);
        graph.put(126,n4);
        graph.put(127,n5);
        graph.put(128,n6);
        graph.put(129,n7);
        graph.put(130,n8);
        graph.put(131,n9);

        new GraphOperation().addDependency(123,124,false,graph);
        new GraphOperation().addDependency(124,125,false,graph);
        new GraphOperation().addDependency(125,129,false,graph);
        new GraphOperation().addDependency(126,129,false,graph);
        new GraphOperation().addDependency(127,126,false,graph);
        new GraphOperation().addDependency(128,127,false,graph);
        new GraphOperation().addDependency(129,130,false,graph);
        new GraphOperation().addDependency(130,131,false,graph);
    }
}
