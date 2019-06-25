package cn.edu.xd.xyh.bit_manipulation.q190;

/**
 * @author LitheLight
 * @date 2019/6/25
 */
public class Solution {
    /**
     * you need treat n as an unsigned value
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int[] bit = new int[32];
        for (int i = 0; i < 32; i++) {
            bit[i] = ((n >> i) & 1);
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += bit[i] * (1 << (31 - i));
        }
        return res;
    }
}
