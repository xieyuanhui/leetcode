package cn.edu.xd.xyh.q503;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author LitheLight
 * @date 2019/6/12
 *
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * 思路：跟上一题思路差不多，不过这里有了重复元素，所以没有使用HashMap
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i % nums.length];
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return result;
    }
}
