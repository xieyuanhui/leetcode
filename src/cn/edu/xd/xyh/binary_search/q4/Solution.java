package cn.edu.xd.xyh.binary_search.q4;

/**
 * @author LitheLight
 * @date 2019/7/7
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 思路：
 * https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int i = 0;
        int j = 0;
        int iMin = 0;
        int iMax = m;
        int half = (m + n + 1) / 2;
        double maxLeft = 0;
        double minRight = 0;
        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = half - i;
            if (j > 0 && i < m && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                if (i == 0) {
                    maxLeft = (double)nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = (double)nums1[i - 1];
                } else {
                    maxLeft = (double)Math.max(nums1[i - 1], nums2[j - 1]);
                }
                break;
            }
        }
        if ((m + n) % 2 == 1) {
            return maxLeft;
        }
        if (i == m) {
            minRight = (double)nums2[j];
        } else if (j == n) {
            minRight = (double)nums1[i];
        } else {
            minRight = (double)Math.min(nums1[i], nums2[j]);
        }
        return (double)(maxLeft + minRight) / 2;
    }
}
