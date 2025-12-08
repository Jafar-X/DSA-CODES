package detect.undirected.graph.cycle;

import java.util.ArrayList;

public class SolutionDFS {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = edgeToAdjList(edges, V);
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(adj, vis, i, -1)) return true;
            }
        }
        return false;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj,
                boolean[] vis, int node, int parent) {
        vis[node] = true;
        for(int adjacentNode : adj.get(node)) {
            if(!vis[adjacentNode]) {
                if(dfs(adj, vis, adjacentNode, node)) return true;
            } else if(adjacentNode != parent) {
                return true;
            }
        }
        return false;

    }

    ArrayList<ArrayList<Integer>> edgeToAdjList(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
