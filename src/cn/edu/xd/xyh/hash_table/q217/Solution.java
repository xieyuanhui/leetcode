package cn.edu.xd.xyh.hash_table.q217;

import java.util.HashSet;

/**
 * @author LitheLight
 * @date 2019/7/3
 * https://leetcode.com/problems/contains-duplicate/
 * 思路：
 * 利用hashset存储元素，当元素存在时add方法会返回false，说明有重复
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
