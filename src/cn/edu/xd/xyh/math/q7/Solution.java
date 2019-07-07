package cn.edu.xd.xyh.math.q7;

/**
 * @author LitheLight
 * @date 2019/7/7
 * https://leetcode.com/problems/reverse-integer/
 * 思路：
 * 要注意翻转后溢出的情况，这里是在计算当前翻转的数的时候再倒回去看能不能得到前一个数，可以的话说明没有溢出
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        int tail = 0;
        int newResult;
        while (x != 0) {
            tail = x % 10;
            newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
