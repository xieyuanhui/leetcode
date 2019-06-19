package cn.edu.xd.xyh.breadth_first_search.q102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/19
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 利用队列进行广度优先搜索。将一层的值全部存起来，然后下一层的节点入队
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp = new ArrayList<>();
        int size;
        while (!queue.isEmpty()) {
            // 这个表示当前队列的长度，也就是某一层的节点数量
            size = queue.size();
            // 遍历这一层的节点并且把下一层不为空的节点入队
            while (size-- > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
        }
        return res;
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
