package Graphs.Tasks;

import java.util.ArrayList;
import java.util.Scanner;

public class DirectedWeightedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes and edges");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] adj = new int[n+1][n+1];
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();

        for (int i=0; i<= n; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter " + m +  " edges: ");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            addEdge_matrix(adj, u, v, weight);
            addEdge_list(adjList, u, v, weight);
        }

        //output
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                System.out.printf(adj[i][j] + " ");
            }
            System.out.println();
        }

        for (int i=1; i<=n; i++) {
            System.out.print(i + " -> ");
            for (int[] pair: adjList.get(i)) {
                System.out.print("(" + pair[0] + ", w:" + pair[1] + ") ");
            }
            System.out.println();
        }

        System.out.println("Is edge there: " + edgeCheckMatrix(adj, 3, 2));
        System.out.println("Is edge there: " + edgeCheckList(adjList, 3, 2));

        sc.close();
    }

    static void addEdge_matrix(int[][] matrix, int u, int v, int weight) {
        matrix[u][v] = weight;
    }

    static void addEdge_list(ArrayList<ArrayList<int[]>> list, int u, int v, int weight) {
        list.get(u).add(new int[] {v, weight});
    }

    static boolean edgeCheckMatrix(int[][] adj, int u, int v) {
        if (adj[u][v] != 0) {
            return true;
        }
        return false;
    }

    static boolean edgeCheckList(ArrayList<ArrayList<int[]>> adjList, int u, int v) {
        for (int[] pair: adjList.get(u)) {
            if (pair[0] == v) {
                return true;
            }
        }
        return false;
    }
}




