package cn.edu.xd.xyh.binary_search.q69;

/**
 * @author LitheLight
 * @date 2019/6/22
 * https://leetcode.com/problems/sqrtx/
 * 二分法
 */
public class Solution {
    public int mySqrt(int x) {
        // x为0和1的情况单独考虑，这样后面的数开根号的值不会超过x/2
        if (x < 2) {
            return x;
        }
        // 左边界1
        int left = 1;
        // 右边界x/2
        int right = (x >> 1);
        while (left <= right) {
            // 取中位数，不是直接（right+left）/2是为了防止溢出
            int mid = left + (right - left) / 2;
            // 这里比较mid和x/mid的值而不是 x和mid平方的值也是为了防止溢出
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                // 当 mid*mid <= x 而(mid + 1)*(mid + 1) > x时mid就是我们要的值
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return right;
    }
}
