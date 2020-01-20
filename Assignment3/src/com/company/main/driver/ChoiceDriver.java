package com.company.main.driver;

import com.company.main.graph.GraphOperation;
import com.company.main.model.Node;

import java.util.HashMap;

public class ChoiceDriver {
    public void start(HashMap<Integer, Node> graph){
        while(true){
            int choice = new UserChoiceMenu().getChoice();
            GraphOperation graphOperation = new GraphOperation();
            switch (choice)
            {
                case 1:
                    graphOperation.printParent(graph);
                        break;
                case 2:
                    graphOperation.printChildren(graph);
                    break;
                case 3:
                    graphOperation.printAncestors(graph);
                    break;
                case 4:
                    graphOperation.printDescendants(graph);
                    break;
                case 5:
                    graphOperation.deleteDependency(graph);
                    break;
                case 6:
                    graphOperation.deleteNode(graph);
                    break;
                case 7:
                    graphOperation.addDependency(1,1,true,graph);
                    break;
                case 8:
                    graphOperation.addNode(graph);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Enter valid choice : ");
                    break;
            }
        }
    }
}
