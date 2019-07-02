package cn.edu.xd.xyh.tree.q105;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author LitheLight
 * @date 2019/7/2
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 1.递归：就是找出先序遍历的第一个作为根节点，中序遍历找到该结点所在位置，左右两边的作为左孩子和右孩子的中序遍历
 *
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return buildTreeRoot(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRoot(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.left = buildTreeRoot(preorder, preStart + 1, inorder, inStart, index - 1);
        root.right = buildTreeRoot(preorder, preStart + index - inStart + 1, inorder, index + 1, inEnd);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        Stack<TreeNode> stack = new Stack<>();
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            value = preorder[i];
            TreeNode node = new TreeNode(value);
            if (map.get(value) < map.get(stack.peek().val)) {
                stack.peek().left = node;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
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
