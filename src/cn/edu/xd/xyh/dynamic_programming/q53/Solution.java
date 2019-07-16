package cn.edu.xd.xyh.dynamic_programming.q53;

/**
 * @author LitheLight
 * @date 2019/6/20
 * https://leetcode.com/problems/maximum-subarray/
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // sum < 0 说明 i-1之前的和小于 0，所以0 ~（i - 1）这个序列不要，直接让sum = 0就相当于清空
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            // max赋值前为 前 i - 1 项的最大子序列和，所以这里也是动态规划的思想
            max = Math.max(max, sum);
        }
        return max;
    }
}
