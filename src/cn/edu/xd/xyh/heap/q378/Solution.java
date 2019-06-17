package cn.edu.xd.xyh.heap.q378;

/**
 * @author LitheLight
 * @date 2019/6/17
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13 ,15}};
        int k = 8;
        solution.kthSmallest(matrix, k);
    }
}
