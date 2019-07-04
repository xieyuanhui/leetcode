package cn.edu.xd.xyh.back_tracking.q131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/7/4
 * https://leetcode.com/problems/palindrome-partitioning/
 * 思路：
 * 回溯法
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> temp = new ArrayList<>();
        findPartition(s, 0, temp, res);
        return res;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    private void findPartition(String s, int index, List<String> temp, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                findPartition(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        solution.partition(s);
    }
}
