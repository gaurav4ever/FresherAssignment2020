/*
 * Created by Manu KJ 
 */
package Assignment3;
import java.util.HashMap;
import java.util.Map;

public class Node {
	private int id;
	private String Name;
	private Map<String, String> additional_info = new HashMap<String, String>();
	private Node child;
	private Node parent;

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Map<String, String> getAdditional_info() {
		return additional_info;
	}

	public void setAdditional_info(String key, String value) {
		additional_info.put(key, value);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this.hashCode() == obj.hashCode())
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id;
	}

}
