package cn.edu.xd.xyh.tree.q98;

import java.util.Stack;

/**
 * @author LitheLight
 * @date 2019/7/2
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 思路：
 * 1.递归：定义一个方法检查某个结点的值是否在某个范围内，然后递归调用这个方法检查左孩子和右孩子
 * 2.非递归方法：使用栈进行中序遍历，并且每次检查遍历的值是否比前面的小，小的话则不是二叉搜索树
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return bst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     *
     * 递归
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean bst(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val > min && root.val < max) {
            boolean left = bst(root.left, min, root.val);
            boolean right = bst(root.right, root.val, max);
            return left && right;
        } else {
            return false;
        }
    }

    /**
     * 非递归方法
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            root = root.right;
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
