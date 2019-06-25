package cn.edu.xd.xyh.bit_manipulation.q137;

/**
 * @author LitheLight
 * @date 2019/6/25
 * https://leetcode.com/problems/single-number-ii/
 * 思路：Single Number的本质，就是用一个数记录每个bit出现的次数，
 * 如果一个bit出现两次就归0，这种运算采用二进制底下的位操作^是很自然的。
 * Single Number II中，如果能定义三进制底下的某种位操作，也可以达到相同的效果，
 * Single Number II中想要记录每个bit出现的次数，一个数搞不定就加两个数，
 * 用ones来记录只出现过一次的bits，用twos来记录只出现过两次的bits，o
 * nes&twos实际上就记录了出现过三次的bits，
 * 这时候我们来模拟进行出现3次就抵消为0的操作，抹去ones和twos中都为1的bits。
 */
public class Solution {

    public int singleNumber(int[] nums) {
        // 记录只出现过一次的bits
        int one = 0;
        // 记录只出现过两次的bits
        int two = 0;
        // 记录出现过三次的bits
        int three;
        for (int i = 0; i < nums.length; i++) {
            // 要在更新one之前更新two
            two |= (one & nums[i]);
            one ^= nums[i];
            // one和two中都为1说明出现了三次
            three = one & two;
            // 出现了三次则抵消为0
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
