//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
package number.of.distinct.islands;

import java.util.HashSet;

import java.util.Set;

// User function Template for Java
class Pair {
    int x;
    int y;

    public Pair(int _x, int _y) {
        x = _x;
        y = _y;
    }
}
class Solution {
    int rows = 0;
    int cols = 0;
    int countDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        rows = grid.length;
        cols = grid[0].length;
        int[] base = new int[2];

        boolean[][] vis = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, vis, i, j, i, j, islands, sb);
                    islands.add(sb.toString());
                }
            }
        }

        return islands.size();
    }

    void dfs(int[][] grid, boolean[][] vis, int i, int j,
             int baseI, int baseJ, Set<String> islands, StringBuilder sb) {

        if(i < 0 || i >= rows || j < 0 || j >= cols ||
                vis[i][j] == true || grid[i][j] == 0) {
            return;
        }

        vis[i][j] = true;
        int iDiff = i - baseI;
        int jDiff = j - baseJ;
        sb.append(iDiff + " " + jDiff + ";");

        dfs(grid, vis, i, j + 1, baseI, baseJ, islands, sb);
        dfs(grid, vis, i + 1, j, baseI, baseJ, islands, sb);
        dfs(grid, vis, i, j - 1, baseI, baseJ, islands, sb);
        dfs(grid, vis, i - 1, j, baseI, baseJ, islands, sb);
    }
}

