package cn.edu.xd.xyh.bit_manipulation.q136;

/**
 * @author LitheLight
 * @date 2019/6/25
 * https://leetcode.com/problems/single-number/
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = (res ^ nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(~1);
    }
}
