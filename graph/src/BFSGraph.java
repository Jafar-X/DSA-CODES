import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {

    static ArrayList<Integer> bfs (ArrayList<ArrayList<Integer>> adj) {
        int sizeOfAdj = adj.size();
        boolean[] visited = new boolean[sizeOfAdj];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();

        int startingVertex = 0;
        visited[startingVertex] = true;
        q.add(startingVertex);

        while(!q.isEmpty()) {
            int curr = q.poll();
            bfs.add(curr);

            for(int x: adj.get(curr)) {
                //with this iteration, we are getting the mapping for each vertex for ex: curr = 0, x are like {1, 2, 3}
                // 0 -> {1, 2, 3}
                if(!visited[x]) {
                    q.add(x);
                    visited[x] = true;
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));

        ArrayList<Integer> bfs = bfs(adj);

        for (Integer x : bfs) {
            System.out.print(x + " ");
        }
    }
}
