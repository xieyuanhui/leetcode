package cn.edu.xd.xyh.array.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/15
 * https://leetcode.com/problems/3sum/
 * 首先将数组排序，然后遍历数组，取当前遍历值的下一个作为左指针，最后一个值作为指针
 * 根据它们的和来滑动指针，在此过程中找到所有的可能组合。
 * 为了不重复，下一次遍历数组的时候要找到和前一个有组合的第一个值不相同的值
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        int left;
        int right;
        int expect;
        int sum;
        Arrays.sort(nums);
        // 当找到组合时，记录该组合的第一个值
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // 为了避免重复值，需要移动到下一个和上一个找到的组合的第一个值不同的位置
            while (nums[i] == pre && i < nums.length - 2) {
                i++;
            }
            expect = 0 - nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (expect == sum) {
                    pre = nums[i];
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (expect > sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
