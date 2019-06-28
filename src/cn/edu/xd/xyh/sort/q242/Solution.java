package cn.edu.xd.xyh.sort.q242;

import java.util.Arrays;

/**
 * @author LitheLight
 * @date 2019/6/28
 * https://leetcode.com/problems/valid-anagram/
 * 思路：
 * 首先长度不等肯定为false。定义一个count数组，用来记录每个字母出现的次数，
 * 数组下标就是 字母-a的值，所以是 0~25，长度26。
 * 遍历字符串s，字母出现则次数+1，之后遍历字符串t，字母出现则次数-1,
 * 如果t是由s中的字母组成的，那么最后count数组所有元素都为0
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int charNum = 26;
        int[] count = new int[charNum];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < charNum; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
