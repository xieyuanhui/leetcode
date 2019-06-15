package cn.edu.xd.xyh.array.q11;

/**
 * @author LitheLight
 * @date 2019/6/15
 * https://leetcode.com/problems/container-with-most-water/
 * 首先计算容器最长的底的水的容积，当右边挡板高度小于左边挡板时，右边挡板向前移动一块
 * 否则左边挡板向前移动一块，在此过程中找到最大容积
 */
public class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int value = 0;
        while (left < right) {
            value = Math.max(value, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return value;
    }
}
