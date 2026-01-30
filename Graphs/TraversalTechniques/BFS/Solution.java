package Graphs.TraversalTechniques.BFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void  main(String[] args) {
        int V = 8;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).addAll(Arrays.asList(2, 3));
        adj.get(2).addAll(Arrays.asList(1, 5, 6));
        adj.get(3).addAll(Arrays.asList(1, 4, 7));
        adj.get(4).addAll(Arrays.asList(3, 8));
        adj.get(5).add(2);
        adj.get(6).add(2);
        adj.get(7).addAll(Arrays.asList(3, 8));
        adj.get(8).addAll(Arrays.asList(4, 7));

        solution sol = new solution();
        System.out.println("BFS Vector: " + sol.bfsOfGraph(V, adj).toString());
        System.out.println("DFS Vector: " + sol.dfsOfGraph(V, adj).toString());
    }
}

class solution {
    // dfs engine
    public void dfs(int node, List<List<Integer>> adj, List<Integer> dfsVector, boolean[] vis) {
        dfsVector.add(node);
        vis[node] = true;

        for(int neighbour: adj.get(node)) {
            if (!vis[neighbour]) {
                dfs(neighbour, adj, dfsVector, vis);
            }
        }
    }

    // trigger the dfs engine for heads in non-connected structures
    public List<Integer> dfsOfGraph(int v, List<List<Integer>> adj) {
        List<Integer> dfsVector = new ArrayList<>();
        boolean[] vis = new boolean[v+1];

        for(int i=1; i<=v; i++) {
            dfs(i, adj, dfsVector, vis);
        }
        return dfsVector;
    }

    // bfs engine
    public void bfs(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> bfsVector) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            bfsVector.add(current);

            for (int neighboor: adj.get(current)) {
                if(!vis[neighboor]) {
                    vis[neighboor] = true;
                    q.add(neighboor);
                }
            }
        }
    }

    // trigger the bfs engine if the node has not been visited.
    public List<Integer> bfsOfGraph(int v, List<List<Integer>> adj) {
        List<Integer> bfsVector = new ArrayList<>();
        boolean[] vis = new boolean[v+1];

        vis[0] = true;
        for(int i=1; i<=v; i++) {
            if(!vis[i]) {
                bfs(i, adj, vis, bfsVector);
            }  
        }

        return bfsVector;
    }
}