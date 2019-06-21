package cn.edu.xd.xyh.dynamic_programming.q121;

/**
 * @author LitheLight
 * @date 2019/6/21
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 跟昨天的最大子序列和的题目思路一样，不过这里是要计算数组相邻的数之间的差值数组
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int sum = prices[1] - prices[0];
        int max = sum;
        for (int i = 2; i < prices.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += prices[i] - prices[i - 1];
            max = Math.max(sum, max);
        }
        if (max < 0) {
            return 0;
        }
        return max;
    }
}
