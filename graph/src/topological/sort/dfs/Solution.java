package topological.sort.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = edgeToAdjList(V, edges);;
        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(adj, i, vis, s);
            }
        }


        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(!s.isEmpty()) {
            list.add(s.pop());
        }
        return list;

    }

    void dfs(List<List<Integer>> adjList, int node, boolean[] vis, Stack<Integer> s) {
        vis[node] = true;

        for(int neighbor : adjList.get(node)) {
            if(!vis[neighbor]) {
                dfs(adjList, neighbor, vis, s);
            }
        }
        s.push(node);
    }

    List<List<Integer>> edgeToAdjList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }
        return adj;
    }
}
