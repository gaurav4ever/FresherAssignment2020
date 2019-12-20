package com.gonuclei.assignment.q3.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	 	public String name;
	 	public int id;
	    private List<GraphNode> comingInNodes ;
	    private List<GraphNode> goingOutNodes ;

	    
	    public GraphNode() {
			super();
			this.comingInNodes = new ArrayList();
			this.goingOutNodes = new ArrayList<>();
			// TODO Auto-generated constructor stub
		}

		/**
	     * Adds an incoming node to the current node
	     *
	     * @param node
	     *            The incoming node
	     */
	    public void addComingInNode(GraphNode node) {
	        comingInNodes.add(node);
	    }

	    /**
	     * Adds an outgoing node from the current node
	     *
	     * @param node
	     *            The outgoing node
	     */
	    public void addGoingOutNode(GraphNode node) {
	        goingOutNodes.add(node);
	    }

	    /**
	     * Provides all the coming in nodes
	     *
	     * @return The coming in nodes
	     */
	    public List<GraphNode> getComingInNodes() {
	        return comingInNodes;
	    }

		/**
	     * Provides all the going out nodes
	     *
	     * @return The going out nodes
	     */
	    
	    public List<GraphNode> getGoingOutNodes() {
	        return goingOutNodes;
	    }
	    

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setComingInNodes(List<GraphNode> comingInNodes) {
			this.comingInNodes = comingInNodes;
		}

		public void setGoingOutNodes(List<GraphNode> goingOutNodes) {
			this.goingOutNodes = goingOutNodes;
		}

		
		
}












