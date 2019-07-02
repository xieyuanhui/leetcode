package cn.edu.xd.xyh.tree.q124;

/**
 * @author LitheLight
 * @date 2019/7/2
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 思路：
 * maxPath函数就是找到经过这条路径的最大的和
 * https://www.cnblogs.com/ganganloveu/p/4126953.html
 */
public class Solution {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPath(node.left));
        int right = Math.max(0, maxPath(node.right));
        /**
         * 下面两行代码解析：max之所以是左孩子的和+右孩子的和+当前结点的值和原来的max取最大值
         * 是因为当前结点以及它的左右可以作为最终的结果。但是为什么下面返回的时候要么是左孩子的和
         * + 当前结点的值 要么是右孩子的和 + 当前结点的值呢，因为这个值是可能给当前结点的上面的结点使用的，
         * 当给它们使用的时候，走左边还是右边只能选一边走。
         */
        max = Math.max(max, left + node.val + right);
        return Math.max(node.val + left, node.val + right);
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
