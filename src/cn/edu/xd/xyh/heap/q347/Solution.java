package cn.edu.xd.xyh.heap.q347;

import java.util.*;

/**
 * @author LitheLight
 * @date 2019/6/17
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 首先将每个数字以及出现的频率存入HashMap中，然后遍历HashMap的键值对，
 * 将键值对存入最大堆中，然后取出最大堆的前k个存入List中返回
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue(new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
