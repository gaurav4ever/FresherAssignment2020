package Assignment3.interfaces;

import java.util.List;

public interface DependencyGraph {
    public boolean addDependency(Integer parentId, Integer childId);
    public boolean deleteDependency(Integer parentId, Integer childId);
    public boolean deleteNode(Integer nodeId);
    public boolean addNode(Integer nodeId, String nodeName);
    public List<Integer> getParents(Integer nodeId);
    public List<Integer> getChildrens(Integer nodeId);
    public List<Integer> getAncestors(Integer nodeId);
    public List<Integer> getDescendants(Integer nodeId);
}
