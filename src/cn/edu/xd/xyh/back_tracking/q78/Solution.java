package cn.edu.xd.xyh.back_tracking.q78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/23
 * https://leetcode.com/problems/subsets/
 * 回溯法,和上一题思路一样
 * 不过这此遍历数组要从不同的位置开始，从0一直到 n - 1，
 * 不是像前一题每次都是从0开始，因为这里是要找子序列
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        findCombination(nums, temp, 0, res);
        return res;
    }

    private void findCombination(int[] nums, List<Integer> temp, int start, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            findCombination(nums, temp, i + 1, res);
            temp.remove(temp.size() - 1);
        }
    }
}
