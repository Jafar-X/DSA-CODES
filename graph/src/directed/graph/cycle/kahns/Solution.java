package directed.graph.cycle.kahns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adjList = edgesToAdjList(V, edges);

        int[] indegree = new int[V];
        for(int i = 0; i < V; i++) {
            for(int neighbor : adjList.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()) {
            int elem = q.poll();
            count++;

            for(int n : adjList.get(elem)) {
                indegree[n]--;
                if(indegree[n] == 0) {
                    q.add(n);
                }
            }
        }
        if(count != V) return true;


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
