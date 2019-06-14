package cn.edu.xd.xyh.linkedlist.q138;

/**
 * @author LitheLight
 * @date 2019/6/14
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next;
        // 第一遍遍历，为每一个节点复制相同值的节点并连接在它后面
        while (cur != null) {
            next = cur.next;
            Node tempNode = new Node(cur.val, null, null);
            tempNode.next = next;
            cur.next = tempNode;
            cur = next;
        }
        cur = head;
        // 第二次遍历，为复制的每个节点连接上random节点
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node copyNode = head.next;
        Node copy = copyNode;
        // 拆分链表
        while (copy.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        // 原始链表不能改变，所以最后一个节点还得指向空节点
        cur.next = cur.next.next;
        return copyNode;
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
