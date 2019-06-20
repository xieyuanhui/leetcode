package cn.edu.xd.xyh.dynamic_programming.q62;

/**
 * @author LitheLight
 * @date 2019/6/20
 * https://leetcode.com/problems/unique-paths/
 * 动态规划：dp[i][j]表示从点（0，0）到点（i，j）有多少条不同路径。
 * 左边界和上边界上的点只有一种路径可以到达，dp[i][j] = 1，
 * 又因为只能向下或者向右，所以
 * 其余的点的状态转移方程为 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
