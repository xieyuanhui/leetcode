package cn.edu.xd.xyh.q71;

import java.util.Stack;

/**
 * @author LitheLight
 * @date 2019/6/12
 *
 * https://leetcode-cn.com/problems/simplify-path/
 * 首先将字符串分割，得到/之间的字符串，然后遍历这个字符串数组，
 * 值为空或者为 . 就继续；为 .. 就先判断栈是否为空，为空就不操作
 * 不为空就弹出栈顶元素；为其他值就压入栈。
 * 最后栈中的元素出栈并且与拼接上‘/’就是路径了（由于栈顶的元素在最后面所以用的是insert方法）
 */
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        String[] words = path.split("/");
        for (String s : words) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuffer result = new StringBuffer();
        // 如果栈为空的话直接返回 "/"
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 表示从第0个位置开始插入
        System.out.println(solution.simplifyPath("/../../a/a//b/./c"));
    }
}
