package cn.edu.xd.xyh.back_tracking.q17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/23
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 回溯法：res[index]表示0~index的组合数量 res[index] = res[index - 1] + index处对应的数字键的字母，
 * 所以可以先从0一直找到最后（这个时候取了最后数字键上的第一个字母），然后往前一位之后再加上最后数字键上的第二个数字，
 * 依此往上回溯。
 */
public class Solution {

    private String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char num = digits.charAt(index);
        String letter = letterMap[num - '0'];
        for (int i = 0; i < letter.length(); i++) {
            findCombination(digits, index + 1, s + letter.charAt(i));
        }
    }
}
