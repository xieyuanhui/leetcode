package cn.edu.xd.xyh.dynamic_programming.q91;

/**
 * @author LitheLight
 * @date 2019/6/21
 * https://leetcode.com/problems/decode-ways/
 * 动态规划思想：dp[i]表示第一个字符到第i个字符的编码方式，
 * 如果第i个字符是0，那么它只能跟前一个字符拼接， 20只有1种编码方式 21有2种编码方式
 * 如果在1~26之间那么它的编码数量等于dp[i - 2]，如果不在范围内则返回0.
 * 如果第i个字符不是0，如果它前一个字符是0或者它跟前一个字符拼接不在范围内，
 * 那么dp[i] = dp[i - 1]
 * 在最后一种情况下，就有两种选择了，i处字符单独编码 或者 和前一个字符拼接一起编码，
 * 那么 dp[i] = dp[i - 1] + dp[i - 2]
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 第一个字符为0的要单独考虑
        if (s.charAt(0) == '0') {
            return 0;
        }
        // dp[i]表示第i个字符之前的编码方式
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            char pre = s.charAt(i - 2);
            String num = pre + String.valueOf(c);
            if (c == '0') {
                if (inArea(num)) {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (pre == '0' || !inArea(num)) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }

    private boolean inArea(String s) {
        return s.compareTo("1") >= 0 && s.compareTo("26") <= 0;
    }
}
