import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice;
        Scanner scan = new Scanner(System.in);
        Graph graphOperation = new Graph();

        while (true) {
            choice = graphOperation.graphOperationMenu();
            switch (choice) {
            case 1:
                graphOperation.getParent();
                break;
            case 2:
                graphOperation.getChildren();
                break;
            case 3:
                graphOperation.printAncestors(0);
                break;
            case 4:
                graphOperation.printDescendants(0);
                break;
            case 5:
                graphOperation.deleteDependency();
                break;
            case 6:
                graphOperation.deleteNode();
                break;
            case 7:
                graphOperation.addDependency(1, 1, 1);
                break;
            case 8:
                graphOperation.addNode();
                break;
            case 9:
                return;
            }
        }
    }
}