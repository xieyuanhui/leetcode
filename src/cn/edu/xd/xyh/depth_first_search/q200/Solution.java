package cn.edu.xd.xyh.depth_first_search.q200;

/**
 * @author LitheLight
 * @date 2019/6/18
 * https://leetcode.com/problems/number-of-islands/
 */
public class Solution {

    /**
     * 移动的四个方向：上右下左
     */
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    /**
     * 当前元素是否访问过
     */
    private boolean[][] visited;
    private int row;
    private int column;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        row = grid.length;
        column = grid[0].length;
        visited = new boolean[row][column];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        if (x >= 0 && x < row && y >= 0 && y < column) {
            return true;
        }
        return false;
    }
}
