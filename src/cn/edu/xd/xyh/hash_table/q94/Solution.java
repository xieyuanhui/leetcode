package cn.edu.xd.xyh.hash_table.q94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LitheLight
 * @date 2019/7/1
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 思路：
 * 递归的本质就是函数栈的调用，所以可以自定义函数栈来模拟这个递归操作。
 * Command类中的operation表示操作。print的话表示直接打印该结点的值，
 * travel的话表示对该结点进行中序遍历，因为栈是先进后出，所以将右边结点的遍历最先入栈，
 * 然后是当前节点的打印，最后是左边节点的中序遍历入栈
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("travel", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.operation.equals("print")) {
                res.add(command.node.val);
            }
            if (command.operation.equals("travel")) {
                if (command.node.right != null) {
                    stack.push(new Command("travel", command.node.right));
                }
                stack.push(new Command("print", command.node));
                if (command.node.left != null) {
                    stack.push(new Command("travel", command.node.left));
                }
            }
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

class Command {
    String operation;
    TreeNode node;

    public Command(String operation, TreeNode node) {
        this.operation = operation;
        this.node = node;
    }
}
