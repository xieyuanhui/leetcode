package cn.edu.xd.xyh.string.q14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LitheLight
 * @date 2019/8/2
 * https://leetcode.com/problems/longest-common-prefix/
 * 思路：
 * 将数组中的字符串按长度由小到大排序，然后以第一个为基准，找出其他字符串与它的相同前缀，
 * 去最短的那个前缀就是结果
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Comparator<String> comparator = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Arrays.sort(strs, comparator);
        String basic = strs[0];
        String res = getPrefix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            String tmp = getPrefix(basic, strs[i]);
            res = tmp.length() > res.length() ? res : tmp;
        }
        return res;
    }

    private String getPrefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s1.length() && s1.charAt(i) == s2.charAt(i)) {
            sb.append(s1.charAt(i));
            i++;
        }
        return sb.toString();
    }
}