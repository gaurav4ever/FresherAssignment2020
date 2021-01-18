package com.company.main;

import com.company.main.driver.ChoiceDriver;
import com.company.main.model.Node;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    static HashMap<Integer, Node> graph = new HashMap<>();

    public static void main(String[] args) {

        new SampleGraph().build(graph);
        new ChoiceDriver().start(graph);

    }
}
