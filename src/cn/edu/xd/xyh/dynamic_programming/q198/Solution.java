package cn.edu.xd.xyh.dynamic_programming.q198;

/**
 * @author LitheLight
 * @date 2019/6/21
 * https://leetcode.com/problems/house-robber/
 * 动态规划思想：dp[i]表示前i个数能抢到的最大值。
 * 情况1：第i个房子抢劫，那么i - 1个房子不能抢，dp[i] = dp[i - 2] + nums[i]
 * 情况2：第i个房子不抢，dp[i] = dp[i - 1]
 * 取两种情况的最大值
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
