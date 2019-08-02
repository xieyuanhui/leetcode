package cn.edu.xd.xyh.string.q38;

/**
 * @author LitheLight
 * @date 2019/8/2
 * https://leetcode.com/problems/count-and-say/
 * 思路：
 * 按照规律来走
 */
class Solution {
    public String countAndSay(int n) {
        String s = "1";
        if (n == 1) {
            return s;
        }
        for (int k = 2; k <= n; k++) {
            StringBuilder tmp = new StringBuilder();
            int step = 1;
            for (int i = 0; i < s.length(); i = i + step) {
                int count = 1;
                int j = i;
                while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                    j++;
                }
                step = count;
                tmp.append(count);
                tmp.append(s.charAt(i));
            }
            s = tmp.toString();
        }
        return s;
    }
}
