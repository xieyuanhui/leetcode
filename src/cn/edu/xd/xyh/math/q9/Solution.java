package cn.edu.xd.xyh.math.q9;

/**
 * @author LitheLight
 * @date 2019/7/10
 * https://leetcode-cn.com/problems/palindrome-number/
 * 思路：
 * 1. 首先想到的是将数字转为字符串，然后首位两指针比较字符是否相等
 * 2. 下面代码的做法是每次取数字的第一位（除以相同位数的起始整数，一位数的起始整数是1；
 * 两位数的起始整数是10；三位数的起始整数是100，以此类推）和最后一位比较（对10取模）。
 * 这样比较完一次之后将首尾两个数字去掉（去掉首字母就是对相同位数的起始整数取模，去掉尾数字就是除以10）
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        // 找到相同位数的起始整数，这里除以10比较而不是help*10 < x是为了防止溢出
        int help = 1;
        while (x / help >= 10) {
            help *= 10;
        }
        while (x != 0) {
            // 比较首尾数字
            if (x / help != x % 10) {
                return false;
            }
            // 去掉首尾数字
            x = (x % help) / 10;
            help /= 100;
        }
        return true;
    }
}
