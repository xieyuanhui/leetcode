package cn.edu.xd.xyh.depth_first_search.q104;

import java.util.LinkedList;

/**
 * @author LitheLight
 * @date 2019/6/18
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 递归，树的最大深度等于左子树右子树的最大深度加1
 */
public class Solution {
    /**
     * 递归方法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 非递归方法（注意LinkedList的push pop 是作为栈的方法来使用的，一开始在这里用错了）
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int size = 0;
        int depth = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode temp = queue.removeFirst();
                if (temp.left != null) {
                    queue.addLast(temp.left);
                }
                if (temp.right != null) {
                    queue.addLast(temp.right);
                }
            }
        }
        return depth;
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
