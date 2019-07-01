package cn.edu.xd.xyh.hash_table.q36;

import java.util.HashMap;

/**
 * @author LitheLight
 * @date 2019/7/1
 * https://leetcode.com/problems/valid-sudoku/
 * 思路：
 * 检查每一行每一列以及3 * 3 的格子
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i) || !checkColomn(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkSubGrid(board, i * 3, j * 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 检查每一行
     * @param board
     * @param i
     * @return
     */
    private boolean checkRow(char[][] board, int i) {
        boolean[] seen = new boolean[9];
        for (int j = 0; j < 9; j++) {
            char c = board[i][j];
            if (c != '.') {
                if (seen[c - '1']) {
                    return false;
                }
                seen[c - '1'] = true;
            }
        }
        return true;
    }

    /**
     * 检查每一列
     * @param board
     * @param j
     * @return
     */
    private boolean checkColomn(char[][] board, int j) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char c = board[i][j];
            if (c != '.') {
                if (seen[c - '1']) {
                    return false;
                }
                seen[c - '1'] = true;
            }
        }
        return true;
    }

    /**
     * 检查3 * 3 的格子
     * @param board
     * @param m
     * @param n
     * @return
     */
    private boolean checkSubGrid(char[][] board, int m, int n) {
        boolean[] seen = new boolean[9];
        for (int i = m; i < m + 3; i++) {
            for (int j = n; j < n + 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (seen[c - '1']) {
                        return false;
                    }
                    seen[c - '1'] = true;
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return true;
    }
}
