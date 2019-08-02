package cn.edu.xd.xyh.stack.q20;

import java.util.Stack;

/**
 * @author LitheLight
 * @date 2019/8/2
 * https://leetcode.com/problems/valid-parentheses/
 * 思路：
 * 出栈入栈消除括号
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (c == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                } else if (c == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                } else if (c == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
