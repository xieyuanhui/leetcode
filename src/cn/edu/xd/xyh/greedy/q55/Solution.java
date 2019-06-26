package cn.edu.xd.xyh.greedy.q55;

/**
 * @author LitheLight
 * @date 2019/6/26
 * https://leetcode.com/problems/jump-game/
 * 思路：遍历数组，计算最后一位之前的每一个位置所能达到的最大位置。
 * 如果下一个位置达不到的话直接返回失败，如果直接能达到最大位置，返回成功
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return false;
        }
        // 只有一个元素的时候一定能到达
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            // 每个位置所能达到的最远距离
            max = Math.max(max, nums[i] + i);
            // 如果下一个位置都到达不了直接返回false
            if (max < i + 1) {
                return false;
            }
            // 如果直接能到达最后一个位置返回true
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
