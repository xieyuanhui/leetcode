package cn.edu.xd.xyh.heap.q215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LitheLight
 * @date 2019/6/17
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 利用优先队列存储元素，当元素数量超过k时就移除队列元素，这时候队首元素就是第k大的
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int item : nums) {
            queue.add(item);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        solution.findKthLargest(nums, k);
    }

//    Comparator<Integer> intComparator = new Comparator<Integer>(){
//        @Override
//        public int compare(Integer o1,Integer o2){
//            return o2 - o1;
//        }
//    };
}
