package cn.edu.xd.xyh.hash_table.q128;

import java.util.HashMap;

/**
 * @author LitheLight
 * @date 2019/7/4
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 思路：
 * 利用hashmap记录数组中出现的元素（key）以及它的连续子序列长度（value），
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 如果map中不包含这个元素的话就看看它的前一个和后一个元素是否在map中，在的话把它们存储的连续子序列长度拿出来与现在这个元素加在一起存入到这个元素对应的key中。
            if (!map.containsKey(num)) {
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                int sum = left + right + 1;
                map.put(num, sum);
                res = Math.max(res, sum);
                // 这一步是为了让当前元素的连续子序列前面的元素也进行更新
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }
}
