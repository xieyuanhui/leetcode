package cn.edu.xd.xyh.greedy.q122;

/**
 * @author LitheLight
 * @date 2019/6/26
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 思路：计算相邻价格之间的差值，只要差值大于0就是可以赚的钱。
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += (prices[i] - prices[i - 1]) > 0 ? prices[i] - prices[i - 1] : 0;
        }
        return res;
    }
}
