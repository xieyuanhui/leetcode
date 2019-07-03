package cn.edu.xd.xyh.hash_table.q204;

/**
 * @author LitheLight
 * @date 2019/7/3
 * https://leetcode.com/problems/count-primes/
 * 思路：
 * 每找到一个素数，就将这个素数的倍数标记为非素数
 */
public class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int count = 1;
        boolean[] notPrime = new boolean[n];
        for (int i = 3; i < n; i += 2) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}
