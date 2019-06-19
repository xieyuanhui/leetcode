package cn.edu.xd.xyh.breadth_first_search.q103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/19
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 跟上一题思路一样，不过在将节点值输出时奇数层顺序，偶数层逆序（根节点算第一层）
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> temp = new LinkedList<>();
        int size;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            size = queue.size();
            if ((level & 1) == 0) {
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    temp.offer(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            } else {
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    temp.push(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            res.add(new LinkedList<>(temp));
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
