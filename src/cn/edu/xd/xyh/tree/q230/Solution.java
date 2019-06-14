package cn.edu.xd.xyh.tree.q230;

import java.util.Stack;

/**
 * @author LitheLight
 * @date 2019/6/13
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/submissions/
 * 利用中序遍历的，不需要遍历完，遍历到第k次的时候就可以结束了
 */
public class Solution {
    private int k;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder1(root);
        return result;
    }

    /**
     * 递归中序遍历
     *
     * @param root
     */
    private void inOrder(TreeNode root) {
        if (root == null || k == 0) {
            return;
        }
        inOrder(root.left);
        if (k == 1) {
            result = root.val;
        }
        k--;
        inOrder(root.right);
    }

    /**
     * 非递归中序遍历，需要改写成先序遍历或者后序遍历的时候只需要交换else里面的代码顺序即可
     *
     * @param root
     */
    private void inOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.operation.equals("print")) {
                if (k == 1) {
                    result = command.node.val;
                    break;
                }
                k--;
            } else {
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                stack.push(new Command("print", command.node));
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
    }
}

class Command {
    String operation;
    TreeNode node;

    Command(String operation, TreeNode node) {
        this.operation = operation;
        this.node = node;
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
