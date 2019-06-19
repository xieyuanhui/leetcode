package cn.edu.xd.xyh.breadth_first_search.q207;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LitheLight
 * @date 2019/6/19
 * https://leetcode.com/problems/course-schedule/
 * 判断一个有向图是不是有向无环图
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表 matrix[0][1] = 1表示0 -> 1
        int[][] matrix = new int[numCourses][numCourses];
        // 入度表，记录每个节点的入度
        int[] indegree = new int[numCourses];
        // 找出边和每个节点的入度
        for (int i = 0; i < prerequisites.length; i++) {
            int begin = prerequisites[i][1];
            int end = prerequisites[i][0];
            if (matrix[begin][end] == 0) {
                indegree[end]++;
            }
            matrix[begin][end] = 1;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的节点入队
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        /**
         * 队列里都是入度为0的点，将这些节点指向的下一个入度为1的节点入度减1然后放入队列，
         * 这个操作结束之后如果是一个无环图，拓扑排序节点的数量应该与课程数量相等
         */
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
