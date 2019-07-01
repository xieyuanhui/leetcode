package cn.edu.xd.xyh.hash_table.q202;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LitheLight
 * @date 2019/7/1
 * https://leetcode.com/problems/happy-number/
 * 思路：
 * 这题主要是理解题意，一个数如果不是快乐数那么它会进入一个循环，所以我们可以用hashset
 * 记录过程中出现的数，如果重复了就停止。在过程中如果数变成了1则返回true，否则返回false。
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum, remain;
        while (set.add(n)) {
            sum = 0;
            while (n > 0) {
                remain = n % 10;
                sum += remain * remain;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }
}
