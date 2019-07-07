package cn.edu.xd.xyh.math.q8;

/**
 * @author LitheLight
 * @date 2019/7/7
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 思路：
 * 1.去除里面的空格；
 * 2.判断开头的符号；
 * 3.在将每一个字符加入数字之前判断一下当前的数字是否已经大于 Integer.MAX_VALUE / 10 或者
 * 是否等于 Integer.MAX_VALUE / 10 并且当前准备加入的数字大于 7，如果是的话说明溢出了，根据第 2 步的正负号
 * 返回 Integer 的最大值或者最小值。因为 Integer 的范围是 -2147483648 ~ 2147483647，这里比较有趣的一点是当字符串是
 * 最小值时会判断它已经溢出，然后返回了最小值。
 * 4.将当前字符加入数字，就是前一个数字乘以 10 加上当前的字符的大小
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        str = str.trim();
        int sign = 1;
        int base = 0;
        int i = 0;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + (str.charAt(i++) - '0');
        }
        return sign * base;
    }
}
