package cn.edu.xd.xyh.q108;

/**
 * @author LitheLight
 * @date 2019/6/13
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 中序遍历的逆过程
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, begin, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
