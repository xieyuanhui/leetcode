package cn.edu.xd.xyh.array.q238;

/**
 * @author LitheLight
 * @date 2019/6/27
 * https://leetcode.com/problems/product-of-array-except-self/
 * 思路：
 * 某一个位置要求的其他元素乘积等于它左边元素的乘积 * 右边元素的乘积，
 * 第一次遍历计算每一个位置左边元素的乘积，第二次倒着遍历，用第一遍的结果
 * 乘以右边元素的乘积就得到了结果
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
