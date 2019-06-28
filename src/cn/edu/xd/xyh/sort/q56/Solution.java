package cn.edu.xd.xyh.sort.q56;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LitheLight
 * @date 2019/6/28
 * https://leetcode.com/problems/merge-intervals/
 * 思路：
 * 首先对于一个区间定义一个比较标准，首先按照开始位置排序，开始位置相同就按照结束位置大小排序，
 * 排序都是从小到大排序。定义好之后就是需要将区间排好序，这里用的是优先队列，
 * 排好序之后遍历队列，如果前一个区间结束位置大于等于后一个区间开始位置，那么这两个区间可以合并，
 * 否则就是直接存入结果数组。
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        if (intervals.length == 1) {
            return intervals;
        }
        // 定义比较规则
        Comparator<Pair<Integer, Integer>> comparator = new Comparator<Pair<Integer, Integer>>() {

            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                if (p1.getKey().compareTo(p2.getKey()) == 0) {
                    return p1.getValue().compareTo(p2.getValue());
                } else {
                    return p1.getKey().compareTo(p2.getKey());
                }
            }
        };
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(comparator);
        // 遍历输入数组，将元素组装成pair存入优先队列，存储完之后就已经是有序的了
        for (int i = 0; i < intervals.length; i++) {
            queue.offer(new Pair<>(intervals[i][0], intervals[i][1]));
        }
        int[][] res = new int[intervals.length][2];
        Pair<Integer, Integer> temp = queue.poll();
        // 区间起始位置
        int begin = temp.getKey();
        // 区间结束位置
        int end = temp.getValue();
        // i用来记录结果区间数量 i <= intervals.length
        int i = 0;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            // 前一个区间结束位置大于等于后一个区间的开始位置
            if (end >= temp.getKey()) {
                // 因为前一个区间的末尾可能会大于后一个区间的末尾，所以需要取两者最大值
                end = Math.max(end, temp.getValue());
            } else {
                // 两个区间没有连在一起，前一个区间可以直接存在结果数组中
                res[i++] = new int[]{begin, end};
                begin = temp.getKey();
                end = temp.getValue();
            }
        }
        res[i++] = new int[]{begin, end};
        res = Arrays.copyOf(res, i);
        return res;
    }
}
