import java.util.ArrayList;
import java.util.Arrays;

public class DFSGraph {
    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int sizeOfAdj = adj.size();
        boolean[] visited = new boolean[sizeOfAdj + 1];
        int startingNode = 3;
        ArrayList<Integer> list = new ArrayList<>();
        dfsRec(startingNode, visited, adj, list);
        return list;
    }

    public static void dfsRec(Integer node, boolean[] visited,
                              ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list) {
        visited[node] = true;
        list.add(node);

        for (int x : adj.get(node)) {
            if(!visited[x]) {
                dfsRec(x, visited, adj, list);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>()); //dummy list
        adj.add(new ArrayList<>(Arrays.asList(2,3)));
        adj.add(new ArrayList<>(Arrays.asList(1,5,6)));
        adj.add(new ArrayList<>(Arrays.asList(1,4,7)));
        adj.add(new ArrayList<>(Arrays.asList(3, 8)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(3,8)));
        adj.add(new ArrayList<>(Arrays.asList(4, 7)));

        ArrayList<Integer> ls = dfsOfGraph(adj);
        for(int x : ls) {
            System.out.print(x + " ");
        }
    }

}
