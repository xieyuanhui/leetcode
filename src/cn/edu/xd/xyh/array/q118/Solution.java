package cn.edu.xd.xyh.array.q118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/24
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    // 上一行的左边元素
                    int a = res.get(i - 1).get(j - 1);
                    // 上一行的右边元素
                    int b = res.get(i - 1).get(j);
                    temp.add(a + b);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
