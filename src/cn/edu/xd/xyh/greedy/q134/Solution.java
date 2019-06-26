package cn.edu.xd.xyh.greedy.q134;

/**
 * @author LitheLight
 * @date 2019/6/26
 * https://leetcode.com/problems/gas-station/
 * 思路：前提：只要油的总数量大于等于消耗的油的总数量，就一定可以走完一圈，我证明不了，但也找不到反例
 * 那我们需要遍历一次找到开始位置就行了。遍历的时候计算每一站能剩余的油数量，如果小于0的话说明到不了下一站，
 * 那么就需要将下一站作为出发位置，依次遍历完所有元素。
 * 最后判断油的总数量和消耗的油的总数量，大于则返回起始位置，否则返回-1
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }
}
