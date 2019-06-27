package cn.edu.xd.xyh.array.q268;

/**
 * @author LitheLight
 * @date 2019/6/27
 * https://leetcode.com/problems/missing-number/
 * 思路：
 * 计算0--n的和，然后遍历数组，减去每一个元素，结果就是遗漏的元素
 */
public class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (0 + n) * (n + 1) >> 1;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
