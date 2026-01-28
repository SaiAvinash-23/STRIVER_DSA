package Graphs.Tasks;
import java.util.Scanner;
import java.util.ArrayList;

public class DirectredGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes and edges");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] adj = new int[n+1][n+1];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i=0; i<= n; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter " + m +  " edges: ");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge_matrix(adj, u, v);
            addEdge_list(adjList, u, v);
        }


        // print them
        System.out.println("Adjacency Matrix ");
        for (int i=1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                System.out.printf(adj[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Adjacency List ");
        for (int i=1; i <= n; i++) {
            System.out.println(i + " -> " + adjList.get(i));
        }
        sc.close();
    }

    static void addEdge_matrix(int[][] matrix, int u, int v) {
        matrix[u][v] = 1;
    }

    static void addEdge_list(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
    }
}
