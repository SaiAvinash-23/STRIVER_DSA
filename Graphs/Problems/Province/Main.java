package Graphs.Problems.Province;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] adj = {
            {1, 1},
            {1, 1}
        };

        // {1, 0, 1},
        // {0, 1, 0},
        // {1, 0, 1}

        // {1, 1},
        // {1, 1}

        // {1, 0, 0, 1},
        // {0, 1, 1, 0},
        // {0, 1, 1, 0},
        // {1, 0, 0, 1}

        Solution sol = new Solution();

        System.out.print("The number of provinces in the given graph: " + sol.numProvinces(adj) + '\n');
    }
}

class Solution {
    private void bfs(int node, List<List<Integer>> adjList, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            for(int neighbour: adjList.get(current)) {
                if(!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    public int numProvinces(int[][] adj) {
        int count = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        int V = adj.length;

        for(int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < adj.length; i++) {
            for(int j = 0; j < adj[i].length; j++) {
                if(i != j && adj[i][j] == 1) {
                    adjList.get(i+1).add(j+1);
                }
            }
        }

        boolean[] vis = new boolean[V+1];
        vis[0] = true;

        for(int i=0; i <= V; i++) {
            if(!vis[i]) {
                count++;
                bfs(i, adjList, vis);
            }
        }
        
        return count;
    }
}