package cn.edu.xd.xyh.bit_manipulation.q260;

/**
 * @author LitheLight
 * @date 2019/6/25
 * https://leetcode.com/problems/single-number-iii/
 * 思路：还是先将所有元素异或和求出，最后的结果是我们要找的两个数的异或和，
 * 这个异或和二进制中必定有一位为1，否则他们就是相同的了，我们找到第一位为1并且把其余位置置为0得到一个数，
 * 那么对这个数来说，要求的两个结果中有一个跟它相与结果为0，另一位相与结果不为0，那么这样就将这两个分开到两边了，
 * 再次遍历数组，与这个数相与为0的放一起做异或操作，不为0的放一起做异或操作
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int a = 0;
        // 所有元素的异或和
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        // 要求结果的两个数的异或和第一位为1，其余为置为0的数（负数是原码取反然后加1，那么它们相与就是找到了第一个为1，其余为0的数）
        a &= -a;
        int[] res = new int[]{0, 0};
        for (int i = 0; i < nums.length; i++) {
            if ((a & nums[i]) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
