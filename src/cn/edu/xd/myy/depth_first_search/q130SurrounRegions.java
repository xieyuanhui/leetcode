package cn.edu.xd.myy.depth_first_search;

/**
 * @author myy
 * @date 2019/6/18
 */
public class q130SurrounRegions {
    /**
     * 从外围找O，找到了就用DFS或者BFS之类的把都是O的neighbor赋值成Y。然后扫两遍，把O变成X，Y变回O。
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0, row, col);
            if (col > 1)
                //这样的话只有一列的情况不用单独处理了
                dfs(board, i, col - 1, row, col);
        }
        //这里可以掐头去尾
        for (int i = 1; i < col - 1; i++) {
            dfs(board, 0, i, row, col);
            if (row > 1)
                dfs(board, row - 1, i , row, col);
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
    }
    private void dfs(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') return;
        board[i][j] = 'Y';
        dfs(board, i - 1, j, row, col);
        dfs(board, i + 1, j, row, col);
        dfs(board, i, j - 1, row, col);
        dfs(board, i, j + 1, row, col);
    }
}
