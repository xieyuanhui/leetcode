package cn.edu.xd.xyh.stack.q496;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author LitheLight
 * @date 2019/6/12
 *
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * 思路：遍历nums2数组，数据与栈顶元素进行比较，如果比栈顶元素大，
 * 将栈顶元素作为key，当前元素作为value放入hashmap，如此循环直到找到栈中的大于当前元素的值
 * 然后遍历nums1，如果hashmap里的key包含当前元素，则将value存入结果数组
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : nums2) {
            while (!stack.isEmpty() && stack.peek() < item) {
                map.put(stack.pop(), item);
            }
            stack.push(item);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                result[i] = map.get(nums1[i]);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}
