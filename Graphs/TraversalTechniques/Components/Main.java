package Graphs.TraversalTechniques.Components;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int V = 7;

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 3));
        edges.add(Arrays.asList(4, 5));

        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Solution sol = new Solution();

        int count = sol.numberOfComponents(V, adj, sol::bfs);

        System.out.println("Number of components: " + count + '\n');

        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
}

@FunctionalInterface
interface TraversalStrategy {
    void execute(int node, List<List<Integer>> adj, boolean[] vis);
}

class Solution {
    public void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for(int neighbour: adj.get(node)) {
            if(!vis[neighbour]) {
                dfs(neighbour, adj, vis);
            }
        }
    }

    public void bfs(int node, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while(!q.isEmpty()) {
            int current = q.poll();

            for(int neighbour: adj.get(current)) {
                if(!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }


    public int numberOfComponents(int V, List<List<Integer>> adj, TraversalStrategy strategy) {
        boolean[] vis = new boolean[V];
        int count = 0;

        for(int i=0; i<V; i++) {
            if (!vis[i]) {
                count++;
                strategy.execute(i, adj, vis);
            }
        }
        return count;
    }
}

