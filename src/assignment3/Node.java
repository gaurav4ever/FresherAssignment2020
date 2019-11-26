package assignment3;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {
	private int id;
	private String name;
	private HashMap<String,String> additional_info = new HashMap<String,String>();
	private ArrayList<Node> parents = new ArrayList<Node>();
	private ArrayList<Node> children = new ArrayList<Node>();
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the additional_info
	 */
	public HashMap<String, String> getAdditional_info() {
		return additional_info;
	}
	/**
	 * @param additional_info the additional_info to set
	 */
	public void setAdditional_info(HashMap<String, String> additional_info) {
		this.additional_info = additional_info;
	}
	/**
	 * @return the parent
	 */
	public ArrayList<Node> getParents() {
		return parents;
	}
	/**
	 * @param parent the parent to set
	 */
	public void addParent(Node parent) {
		if(!parents.contains(parent))
		parents.add(parent);
	}
	/**
	 * @return the child
	 */
	public ArrayList<Node> getChildren() {
		return children;
	}
	/**
	 * @param child the child to set
	 */
	public void addChild(Node child) {
		if(!children.contains(child))
		children.add(child);
	}
	public void removeParent(Node parent) {
		parents.remove(parent);
	}
	public void removeChild(Node child) {
		children.remove(child);
	}
}
