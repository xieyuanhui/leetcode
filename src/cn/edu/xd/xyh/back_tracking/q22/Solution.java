package cn.edu.xd.xyh.back_tracking.q22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/23
 * https://leetcode.com/problems/generate-parentheses/
 * 还是回溯法，不过这次为了保证字符串的合法性，需要维护两个变量来记录左括号和右括号的数量。
 * 当左括号数量小于n的时候，可以拼接左括号，再进一步，当右括号数量小于左括号数量的时候可以拼接右括号
 */
public class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return res;
        }
        findCombination(n, "", 0, 0);
        return res;
    }

    private void findCombination(int n, String s, int open, int close) {
        // 当字符串长度等于2 * n时已经找到满足条件的了，添加进结果并直接返回
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        // 左括号数量小于n，可以添加左括号
        if (open < n) {
            findCombination(n, s + "(", open + 1, close);
        }
        // 右括号数量小于左括号数量，可以添加右括号
        if (close < open) {
            findCombination(n, s + ")", open, close + 1);
        }
    }
}
