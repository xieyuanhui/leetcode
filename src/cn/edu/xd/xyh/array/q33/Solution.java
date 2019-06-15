package cn.edu.xd.xyh.array.q33;

/**
 * @author LitheLight
 * @date 2019/6/15
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 还是使用二分法，不过要考虑的情况多一些
 * 1. 首先找到中间的值，等于目标值时直接返回；
 * 2. 当中间值大于等于最左边的值时，如果目标值在这个范围内就将中间值前一个位置设为右边界，否则将中间值后一个位置设为左边界
 * 3. 当中间值小于等于最右边的值时，如果目标值在这个范围内就将中间值后一个位置设为左边界，否则将中间值前一个位置设为右边界
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == -1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            // 对应情况1
            if (nums[mid] == target) {
                return mid;
            }
            // 对应情况2
            if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 对应情况3
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
