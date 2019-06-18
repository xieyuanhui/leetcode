package cn.edu.xd.myy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**https://leetcode.com/problems/kth-largest-element-in-an-array/
 * q215
 * @author myy
 * @date 2019/6/17
 */
public class q215KthLargestElementInArray {
    /**
     * 利用优先队列（最大堆）实现
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i=1;i<k;i++){
            pq.poll();
        }
        return pq.peek();
    }

    /**
     * 利用快速排序的partition实现
     */
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,k);
    }
    public int quickSort(int[] nums,int start,int end,int k){
        int index = partition(nums,start,end);
        while((nums.length-index)!= k){
            if((nums.length-index) > k){
                index = partition(nums, index + 1, end);
            }else {

                index = partition(nums,start,index-1);
            }
        }
        return nums[index];
    }
    public int partition(int[] nums,int start,int end){
        int key = nums[start];
        while(start <end){
            while(start<end && nums[end]>=key){
                end--;
            }
            nums[start]=nums[end];
            while(start<end && nums[start] <= key){
                start++;
            }
            nums[end]=nums[start];
        }
        nums[start]=key;
        return start;
    }
}
