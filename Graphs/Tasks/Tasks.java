package Graphs.Tasks;
import java.util.ArrayList;
import java.util.Scanner;

public class Tasks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes and edges:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] adj = new int[n + 1][n + 1];

        System.out.println("Enter " + m + " edges:");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i=0; i <=n; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge_list(adjList, 1, 2);
        addEdge_matrix(adj, 1, 2);
        
        addEdge_list(adjList, 2, 3);
        addEdge_matrix(adj, 3, 2);

        addEdge_matrix(adj, 3, 4);
        addEdge_matrix(adj, 4, 3);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        // Print
        System.out.println("\nAdjacency Matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }


        System.out.printf("Adjacency List\n");


        for (int i=1; i<=n; i++) {
            System.out.println(i + " -> " + adjList.get(i));
        }
        sc.close();
    }

    static void addEdge(int[][] adj, int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    static void addEdge_matrix(int[][] adj, int i, int j) {
        adj[i][j] = 1;
        adj[j][i] = 1;
    }

    static void addEdge_list(ArrayList<ArrayList<Integer>> adjList, int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }
}
