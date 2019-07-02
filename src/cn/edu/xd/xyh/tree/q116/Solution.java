package cn.edu.xd.xyh.tree.q116;

/**
 * @author LitheLight
 * @date 2019/7/2
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 思路：
 * 每次都是从结点的左孩子开始往后链接。如果某个结点的左孩子存在并且右孩子不为空，则把左孩子
 * 的下一个结点设为右孩子；如果某个结点的右孩子不为空，并且这个结点有下一个结点，则把该结点的
 * 右孩子的下一个结点设为 该结点的下一个结点的左孩子
 */
public class Solution {
    public Node connect(Node root) {
        Node level_start = root;
        while (level_start != null) {
            Node cur = level_start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            level_start = level_start.left;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
