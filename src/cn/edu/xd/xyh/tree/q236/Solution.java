package cn.edu.xd.xyh.tree.q236;

/**
 * @author LitheLight
 * @date 2019/6/13
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 递归寻找根节点的左子树中是否包含某一个节点，返回找到的第一个节点
 * 递归寻找右子树中是否包含某一个节点。返回找到的第一个节点
 * 如果两边都有的话，最近公共祖先就是根节点,只有一边有的话找到的就是最近公共祖先
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
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