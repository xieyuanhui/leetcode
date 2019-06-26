package cn.edu.xd.xyh.greedy.q44;

/**
 * @author LitheLight
 * @date 2019/6/26
 * https://leetcode.com/problems/wildcard-matching/
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int s_index = 0;
        int p_index = 0;
        int match = 0;
        int star_index = -1;
        while (s_index < s.length()) {
            // s和p的字符相等或者p的字符为？，移动两个字符串的指针
            if (p_index < p.length() && (p.charAt(p_index) == '?' || s.charAt(s_index) == p.charAt(p_index))) {
                s_index++;
                p_index++;
            }
            // 找到了*，记录*的位置，并且p指针往后移动，s指针不移动，记录当前s指针位置为匹配位置
            else if (p_index < p.length() && p.charAt(p_index) == '*') {
                star_index = p_index;
                match = s_index;
                p_index++;
            }
            // p指针和s指针字符元素不相等，但是p指针前面一个元素是*，那么就从s匹配位置开始往后找，因为这一段都可以在p中用*表示
            else if (star_index != -1) {
                p_index = star_index + 1;
                match++;
                s_index = match;
            }
            // p指针和s指针字符不相等，并且p指针前一个元素不是*，已经无法匹配，返回false
            else {
                return false;
            }
        }
        while (p_index < p.length() && p.charAt(p_index) == '*') {
            p_index++;
        }
        return p_index == p.length();
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        String p = "*ab*fg*";
        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}
