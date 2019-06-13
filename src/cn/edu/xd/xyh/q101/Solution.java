package cn.edu.xd.xyh.q101;

import java.util.LinkedList;

/**
 * @author LitheLight
 * @date 2019/6/13
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    /**
     * 递归方式
     * @param node1
     * @param node2
     * @return
     */
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2 == null;
        }
        if (node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    /**
     * 非递归方式
     * @param root
     * @return
     */
    private boolean isMirror(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root.left);
        queue.push(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.pop();
            TreeNode right = queue.pop();
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

