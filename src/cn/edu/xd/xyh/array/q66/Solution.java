package cn.edu.xd.xyh.array.q66;

/**
 * @author LitheLight
 * @date 2019/6/24
 * https://leetcode.com/problems/plus-one/
 * 注意一下进位以及第一位加1需要进位的情况即可
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int len = digits.length;
        int carry = 0;
        int sum = digits[len - 1] + 1;
        if (sum > 9) {
            digits[len - 1] = 0;
            carry = 1;
            for (int i = len - 2; i >= 0; i--) {
                if (digits[i] + carry > 9) {
                    carry = 1;
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + carry;
                    carry = 0;
                    break;
                }
            }
            if (carry == 1) {
                int[] res = new int[len + 1];
                res[0] = 1;
                for (int i = 1; i < len + 1; i++) {
                    res[i] = digits[i - 1];
                }
                return res;
            } else {
                return digits;
            }
        } else {
            digits[len - 1] = sum;
            return digits;
        }
    }
}
