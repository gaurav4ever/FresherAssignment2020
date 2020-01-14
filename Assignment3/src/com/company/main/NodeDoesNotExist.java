package com.company.main;

public class NodeDoesNotExist extends Exception {
    String message;
    NodeDoesNotExist(){
        message = "doesn't exist";
    }
    public String getMessage(int nodeId){
        return "Node id: " + nodeId + ", " + message;
    }
}
