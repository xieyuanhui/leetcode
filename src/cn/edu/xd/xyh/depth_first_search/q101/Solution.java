package cn.edu.xd.xyh.depth_first_search.q101;

import java.util.LinkedList;

/**
 * @author LitheLight
 * @date 2019/6/18
 * https://leetcode.com/problems/symmetric-tree/
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 递归方法
//        return isMirror(root.left, root.right);
        // 非递归方法
        return isMirror(root);
    }

    /**
     * 递归方法
     * @param left
     * @param right
     * @return
     */
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        } else if (right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
    }

    private boolean isMirror(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.pollFirst();
            TreeNode right = queue.pollFirst();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.push(left.left);
            queue.push(right.right);
            queue.push(left.right);
            queue.push(right.left);
        }
        return true;
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
