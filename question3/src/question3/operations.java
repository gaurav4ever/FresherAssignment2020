package question3;

import java.util.ArrayList;

public interface operations {
	
	public void addNode(int id, Node n);
	
	public ArrayList<Integer> getParents(int id);
	
	public ArrayList<Integer> getChildren(int id);
	
	public ArrayList<Integer> getAncestors(int id);
	
	public ArrayList<Integer> getDescendents(int id);
	
	public void addDependency(int id1, int id2);
	
	public void deleteDependency(int id);
	
	public void deleteDependency(int parentId, int childId);
}
