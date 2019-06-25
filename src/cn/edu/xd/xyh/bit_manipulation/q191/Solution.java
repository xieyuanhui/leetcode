package cn.edu.xd.xyh.bit_manipulation.q191;

/**
 * @author LitheLight
 * @date 2019/6/25
 * https://leetcode.com/problems/number-of-1-bits/
 * n&(n-1)可以消去一位1，当这个结果赋值给n，当n等于0时就消去了所有的1
 */
public class Solution {
    /**
     * you need to treat n as an unsigned value
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
