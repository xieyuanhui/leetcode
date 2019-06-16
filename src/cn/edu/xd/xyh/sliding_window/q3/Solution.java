package cn.edu.xd.xyh.sliding_window.q3;

/**
 * @author LitheLight
 * @date 2019/6/16
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 滑动窗口，同时用长度为256的数组来表示某一个字符出现的次数
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int left = 0;
        int right = -1;
        int[] freq = new int[256];
        char[] chs = s.toCharArray();
        int res = 0;
        while (left < n) {
            if ((right + 1) < n && freq[chs[right + 1]] == 0) {
                right++;
                freq[chs[right]]++;
            } else {
                freq[chs[left]]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aab";
        String s1 = "bb";
        System.out.println(s.indexOf(s1));
    }
}
