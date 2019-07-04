package cn.edu.xd.xyh.two_pointers.q125;

/**
 * @author LitheLight
 * @date 2019/7/4
 * https://leetcode.com/problems/valid-palindrome/
 * 思路：
 * 双指针法，一个从开头，一个从结尾，遇到非字母和非数字则跳过
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() < 2) {
            return true;
        }
        int begin = 0;
        int end = s.length() - 1;
        char[] chs = s.toLowerCase().toCharArray();
        while (begin < end) {
            char a = chs[begin];
            char b = chs[end];
            if (!Character.isLetterOrDigit(a)) {
                begin++;
            } else if (!Character.isLetterOrDigit(b)) {
                end--;
            } else {
                if (! (a == b)) {
                    return false;
                } else {
                    begin++;
                    end--;
                }
            }
        }
        return true;
    }

}
