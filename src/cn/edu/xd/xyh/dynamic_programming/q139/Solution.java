package cn.edu.xd.xyh.dynamic_programming.q139;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/21
 * https://leetcode.com/problems/word-break/
 * dp[i]表示字符串中第1个到第i个字符能否由dict里面的单词组成。
 * 遍历第1个字符到第i个字符，如果第一个到第j个字符可以由字典表示
 * 并且第j + 1到第i个字符组成的字符串在字典里，那么dp[i] = true
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
