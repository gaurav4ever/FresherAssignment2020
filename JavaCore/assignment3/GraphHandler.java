package assignment3;

import assignment3.exceptions.CyclicDependencyException;
import assignment3.exceptions.NoSuchNodeException;
import assignment3.exceptions.NodeAlreadyExistsException;
import assignment3.interfaces.DependencyGraph;
import assignment3.models.Node;

public class GraphHandler {
    static void start() {
        DependencyGraphImpl dependencyGraph = new DependencyGraphImpl(new Node(1, "Root"));
        try {
            dependencyGraph.addNode(2, "Natesh");
            dependencyGraph.addDependency(1, 2);
            dependencyGraph.addNode(3, "Suresh");
        } catch (CyclicDependencyException | NoSuchNodeException | NodeAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
