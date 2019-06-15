package cn.edu.xd.xyh.array.q26;

/**
 * @author LitheLight
 * @date 2019/6/15
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 当数组长度小于2的时候直接返回原数组长度
 * 数组长度大于1时，重新维护一个数组的索引，从1开始，
 * 从第二个元素开始遍历数组，当和前一个元素不相等的时候，数组对应新索引位置赋值为这个，并且索引加1
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        // 维护一个新的数组索引
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            // 不是重复的元素的时候就给新索引位置赋值，同时索引加1
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
