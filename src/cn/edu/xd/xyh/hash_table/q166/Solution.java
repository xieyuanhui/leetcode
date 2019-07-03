package cn.edu.xd.xyh.hash_table.q166;

import java.util.HashMap;

/**
 * @author LitheLight
 * @date 2019/7/3
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * 思路：
 * 用StringBuilder res拼接字符串，首先计算分子除以分母的商，将商存入，然后计算分子除以分母的余数，
 * 余数为0说明后面没有了，直接返回。不为0则需要将余数以及对应当前res的长度存入map，然后在余数不为0的时候循环，
 * 将余数乘以10再除以分母，得到小数位上的数字，然后再求出余数，如果余数在map中存在，说明后面的小数数字都是一样的，
 * 则在开始位置插入(，最后位置插入），结束循环。如果不一样则将这个余数和当前res长度存入map。继续循环
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // 处理结果的正负问题（异或相同为0不同为1，不同的时候要加 - ）
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 3;
        int b = 7;
        System.out.println(solution.fractionToDecimal(a, b));
    }
}
