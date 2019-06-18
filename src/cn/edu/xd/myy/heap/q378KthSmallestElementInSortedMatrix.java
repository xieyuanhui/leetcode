package cn.edu.xd.myy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * q378
 * @author myy
 * @date 2019/6/18
 */
public class q378KthSmallestElementInSortedMatrix {
    /**利用优先队列 最大堆来实现
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                queue.offer(matrix[i][j]);
                if(queue.size()>k){
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

    /**
     * 利用二分查找来实现，在二分查找循环中，统计矩阵中小于等于中间值得数字个数，那她和k比较来确定第k小的数字在左半部分还是右半部分。
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix.length-1];
        while(left <= right){
            int mid = left+(right-left)/2;
            int count =0;
            int j=matrix.length-1;
            for(int i=0;i<matrix.length;i++){
                while(j>=0 && matrix[i][j]>mid){
                    j--;
                }
                count +=(j+1);
            }
            if(count >= k){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
