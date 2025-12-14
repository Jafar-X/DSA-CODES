package valid.graph.tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = adjList(edges, n);
        boolean[] vis = new boolean[n];
        if(!dfs(edges, vis, adj, 0, -1)) return false;
        for(boolean v : vis) {
            if(v == false) return false;
        }
        return true;
    }

    boolean dfs(int[][] edges, boolean[] vis,
                List<List<Integer>> adjList, int node, int parent) {
        vis[node] = true;
        for(int neighbor : adjList.get(node)) {
            if(!vis[neighbor]) {
                if(!dfs(edges, vis, adjList, neighbor, node)) {
                    return false;
                }
            }
            else if(neighbor != parent && vis[neighbor] == true) {
                return false;
            }

        }
        return true;
    }

    List<List<Integer>> adjList(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(adj);
        return adj;
    }

}
