package directed.graph.cycle.dfs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adjList = edgesToAdjList(V, edges);

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i = 0; i <V; i++) {
            if(!vis[i]) {
                if(dfsCheck(vis, pathVis, adjList, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfsCheck(boolean[] vis, boolean[] pathVis,
                     List<List<Integer>> adjList, int i) {
        vis[i] = true;
        pathVis[i] = true;

        for(int neighbor : adjList.get(i)) {
            if(!vis[neighbor]) {
                if(dfsCheck(vis, pathVis, adjList, neighbor)) {
                    return true;
                }
            } else if(pathVis[neighbor]) {
                return true;
            }
        }

        //set to false if no cycle found
        pathVis[i] = false;

        return false;
    }

    List<List<Integer>> edgesToAdjList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
        }
        return adj;
    }
}