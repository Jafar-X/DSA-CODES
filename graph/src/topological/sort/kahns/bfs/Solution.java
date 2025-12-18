package topological.sort.kahns.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

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
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int elem = q.poll();
            list.add(elem);
            for(int neighbor : adjList.get(elem)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        return list;
    }

    List<List<Integer>> edgesToAdjList(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
        }
        //System.out.println(adjList);
        return adjList;
    }
}
