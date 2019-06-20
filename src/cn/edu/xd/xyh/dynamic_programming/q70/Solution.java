package cn.edu.xd.xyh.dynamic_programming.q70;

/**
 * @author LitheLight
 * @date 2019/6/20
 * https://leetcode.com/problems/climbing-stairs/
 * 如果用动态规划思想的话就是 dp[n] = dp[n - 1] + dp[n - 2];
 */
public class Solution {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
