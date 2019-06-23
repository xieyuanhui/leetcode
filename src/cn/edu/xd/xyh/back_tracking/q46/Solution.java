package cn.edu.xd.xyh.back_tracking.q46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/23
 * https://leetcode.com/problems/permutations/
 * 回溯法
 * 遍历nums中的元素，将第一个元素添加进temp 这个list中，并且标记为访问过的，
 * 然后递归调用这个方法，方法调用之后需要将temp这个list中的这个元素移除，放入另一个元素进行新的查找
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // temp用于存储查找过程中的结果
        List<Integer> temp = new ArrayList<>();
        // 标记数组第i个元素是否被访问过，这是为了在递归里面不会在将这个元素添加进去
        boolean[] visited = new boolean[nums.length];
        findCombination(nums, 0, temp, res, visited);
        return res;
    }

    /**
     * 查找组合
     * @param nums
     * @param index
     * @param temp
     * @param res
     * @param visited
     */
    private void findCombination(int[] nums, int index, List<Integer> temp, List<List<Integer>> res, boolean[] visited) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                findCombination(nums, index + 1, temp, res, visited);
                // 将这个元素移除是为了进行新的一轮查找，将它标记为false也是这个原因
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
