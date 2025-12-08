//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
package detect.undirected.graph.cycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int parent;
    int src;

    public Pair(int _p, int _s) {
        parent = _p;
        src = _s;
    }
}

public class SolutionBFS {
    boolean checkCycle(boolean[] vis, int src, ArrayList<ArrayList<Integer>> adj, int V) {
        Queue<Pair> q = new LinkedList<>();
        vis[src] = true;
        q.add(new Pair(-1, src));
        while(!q.isEmpty()) {
            Pair elem = q.poll();
            int parent = elem.parent;
            int node = elem.src;

            for(int adjNode : adj.get(node)) {
                if(!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(new Pair(node, adjNode));
                }
                else if(adjNode != parent){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = edgeToArrayList(edges, V);

        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(vis[i] == false) {
                if(checkCycle(vis, i, adjList, V)) return true;
            }
        }
        return false;
    }

    ArrayList<ArrayList<Integer>> edgeToArrayList(int[][] edges, int n) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            //u -> v
            adjList.get(u).add(v);

            //v -> u
            adjList.get(v).add(u);
        }
        return adjList;
    }

}
