package model;

public class GraphNode {
    Integer nodeId;
    String nodeName;

    public GraphNode(Integer nodeId, String nodeName) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
    }


   public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }



}
