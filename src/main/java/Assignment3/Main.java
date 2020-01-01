package Assignment3;

import Assignment3.models.Node;

public class Main {
    public static void main(String[] args){
        MyGraph myGraph = new MyGraph();
        myGraph.addNode(0, "grandgrandfather");
        myGraph.addNode(1, "grandgrandmother");
        myGraph.addNode(2, "grandfather");
        myGraph.addNode(3, "grandmother");
        myGraph.addNode(4, "mother");
        myGraph.addNode(5, "father");
        myGraph.addNode(6, "girlchild");
        myGraph.addNode(7, "boychild");

        myGraph.addDependency(0, 2);
        myGraph.addDependency(1, 2);
        myGraph.addDependency(2, 4);
        myGraph.addDependency(2, 5);
        myGraph.addDependency(4, 6);
        myGraph.addDependency(5, 7);

        System.out.println(myGraph.getChildrens(0));
        System.out.println(myGraph.getAncestors(2));
        System.out.println(myGraph.getChildrens(4));
        System.out.println(myGraph.getAncestors(5));
        System.out.println(myGraph.deleteNode(4));
        System.out.println(myGraph.getAncestors(7));
        myGraph.deleteDependency(1,2);
        myGraph.deleteDependency(0,2);
        System.out.println(myGraph.getAncestors(7));

    }
}
