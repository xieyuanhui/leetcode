package cn.edu.xd.xyh.bit_manipulation.q169;

/**
 * @author LitheLight
 * @date 2019/6/25
 * https://leetcode.com/problems/majority-element/
 */
public class Solution {

    /**
     * 计数法，先取数组第一个数作为目标，然后遍历数组，当元素和目标数一样的时候计数加1，
     * 元素和目标数不一样的时候计数减1，当计数为0的时候说明肯定不是目标数（因为目标数出现次数大于一半）,
     * 这个时候就替换当前数为目标数，计数加1
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    /**
     * 位操作，因为有一个数出现次数超过了一半，所以将这些数二进制相同位置的0和1数量统计起来，
     * 那么这个数二进制各个位置上的0或者1都会超过统计数量的一半，那么1的数量超过一半就是1，不超过一半就是0，
     * 那么这个二进制数就是我们要的结果
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int[] bit = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if (((nums[i] >> 31 - j) & 1) == 1) {
                    bit[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
            res += bit[i] * (1 << (31 - i));
        }
        return res;
    }
}
