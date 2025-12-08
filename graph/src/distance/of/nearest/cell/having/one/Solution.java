//https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
package distance.of.nearest.cell.having.one;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int rowPos;
    int colPos;
    int dist;

    public Pair(int r, int c, int d) {
        rowPos = r;
        colPos = c;
        dist = d;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];
        //Integer[][] distances = new Integer[rows][cols];
        ArrayList<ArrayList<Integer>> distances = new ArrayList<>();

        for(int i = 0; i < rows; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for(int j = 0; j < cols; j++) {
                rowList.add(0);
            }
            distances.add(rowList);
        }

        // for(int i = 0; i < rows; i++) {
        //     Arrays.fill(distances[i], Integer.MAX_VALUE);
        // }

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()) {
            int[] deltaRows = {-1, 0, 1, 0};
            int[] deltaCols = {0, 1, 0, -1};

            Pair p = q.poll();
            int rowPos = p.rowPos;
            int colPos = p.colPos;
            int dist = p.dist;

            distances.get(rowPos).set(colPos, dist);
            //distances[rowPos][colPos] = dist;

            for(int i = 0; i < 4; i++) {
                int nrow = rowPos + deltaRows[i];
                int ncol = colPos + deltaCols[i];

                if(nrow >= 0 && nrow < rows && ncol >= 0
                        && ncol < cols && vis[nrow][ncol] == false) {
                    q.add(new Pair(nrow, ncol, dist + 1));
                    vis[nrow][ncol] = true;
                }
            }
        }
        return distances;
    }
}