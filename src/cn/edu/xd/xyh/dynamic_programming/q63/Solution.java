package cn.edu.xd.xyh.dynamic_programming.q63;

/**
 * @author LitheLight
 * @date 2019/7/12
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int i = 0;
        while (i < m && obstacleGrid[i][0] != 1) {
            dp[i][0] = 1;
            i++;
        }
        i = 0;
        while (i < n && obstacleGrid[0][i] != 1) {
            dp[0][i] = 1;
            i++;
        }
        for (i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
                        dp[i][j] = 0;
                    } else if (obstacleGrid[i - 1][j] == 1) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (obstacleGrid[i][j - 1] == 1){
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
