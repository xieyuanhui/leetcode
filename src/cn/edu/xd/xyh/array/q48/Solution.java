package cn.edu.xd.xyh.array.q48;

/**
 * @author LitheLight
 * @date 2019/6/24
 * https://leetcode.com/problems/rotate-image/
 * 先进行左下角和右上角的交换，然后以y轴作为轴进行交换
 */
public class Solution {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
