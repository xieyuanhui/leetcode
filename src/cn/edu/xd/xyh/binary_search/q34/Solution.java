package cn.edu.xd.xyh.binary_search.q34;

/**
 * @author LitheLight
 * @date 2019/6/21
 * 二分法先找到目标值，有目标值的话得到它的下标，然后从这个下标开始向两边找和它相等的
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int begin = 0;
        int end = nums.length - 1;
        // 目标值下标，初始为-1
        int index = -1;
        while (begin <= end) {
            // 防止溢出
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (index == -1) {
            return res;
        }
        int left = index;
        int right = index;
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }
        res[0] = left;
        res[1] = right;
        return res;
    }
}
