package cn.edu.xd.xyh.depth_first_search.q130;

/**
 * @author LitheLight
 * @date 2019/6/18
 * https://leetcode.com/problems/surrounded-regions/
 * dfs
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

    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }
        row = board.length;
        column = board[0].length;
        visited = new boolean[row][column];
        /**
         * 找出左右两条边界与O相连的所有O，并标记为*
         */
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][column - 1] == 'O') {
                dfs(board, i, column - 1);
            }
        }
        /**
         * 找出上下两条边界与O相连的所有O，并标记为*
         */
        for (int j = 0; j < column; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                dfs(board, row - 1, j);
            }
        }
        /**
         * 遍历矩阵，为O的替换为X，为*的替换为O（因为没有被X包围）
         */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 判断坐标是否有效
     * @param x
     * @param y
     * @return
     */
    private boolean inArea(int x, int y) {
        if (x >= 0 && x < row && y >= 0 && y < column) {
            return true;
        }
        return false;
    }

    private void dfs(char[][] board, int x, int y) {
        visited[x][y] = true;
        if (board[x][y] == 'O') {
            board[x][y] = '*';
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && board[newX][newY] == 'O') {
                dfs(board, newX, newY);
            }
        }
    }
}
