package cn.edu.xd.xyh.sliding_window.q28;

/**
 * @author LitheLight
 * @date 2019/6/16
 * https://leetcode.com/problems/implement-strstr/
 * 暴力法。。。
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        int[] freq = new int[256];
        for (int i = 0; i < needle.length(); i++) {
            freq[needle.charAt(i)]++;
        }
        loop: for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = i; j < needle.length() + i; j++) {
                if (haystack.charAt(j) != needle.charAt(j - i)) {
                    continue loop;
                }
            }
            return i;
        }
        return -1;
    }
}
