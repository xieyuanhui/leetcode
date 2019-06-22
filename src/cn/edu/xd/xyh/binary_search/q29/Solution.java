package cn.edu.xd.xyh.binary_search.q29;

/**
 * @author LitheLight
 * @date 2019/6/22
 * https://leetcode.com/problems/divide-two-integers/
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        int sig = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sig = -1;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        if ((a == 0) || (a < b)) {
            return 0;
        }
        long lans = divide(a, b);
        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = (sig == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int)(sig * lans);
        }
        return ans;
    }

    /**
     * 递归，每次除以翻倍的b，可以更快得到a / b的值
     * @param a
     * @param b
     * @return
     */
    private long divide(long a, long b) {
        if (a < b) {
            return 0;
        }
        long sum = b;
        long multiple = 1;
        while ((sum + sum) < a) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + divide(a - sum, b);
    }

}
