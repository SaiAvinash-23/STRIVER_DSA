package Graphs.Basics;

import java.util.ArrayList;

public class Basic {
    public static void main(String[] args) {
        int N = 5, M = 6;
        ArrayList<ArrayList<Integer>> adjList= new ArrayList<>();

        for (int i=0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 4);
        addEdge(adjList, 3,  5);

        for (int i = 1; i <= N; i++) {
            System.out.println(i + " -> " + adjList.get(i));
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
}