package cn.edu.xd.xyh.array.q283;

/**
 * @author LitheLight
 * @date 2019/6/27
 * https://leetcode.com/problems/move-zeroes/
 * 思路：
 * 第一次遍历把非0元素放到数组前面，剩下的位置补0
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
