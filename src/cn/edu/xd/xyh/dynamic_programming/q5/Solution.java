package cn.edu.xd.xyh.dynamic_programming.q5;

/**
 * @author LitheLight
 * @date 2019/6/20
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 动态规划 dp[i][j]表示下标为i和j之间的字符串是否为回文串，
 * 当i和j处的字符相等时，dp[i][j] = dp[i+1][j-1]，不过在i和j差1时即像bb这种情况下这个式子不成立，
 * 所以需要加上 j - i = 1的情况
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() < 1) {
            return s;
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && ((j - i) == 1 || dp[i + 1][j - 1]));
                if (dp[i][j] && (j - i) > (right - left)) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
