package cn.edu.xd.xyh.sliding_window.q19;

/**
 * @author LitheLight
 * @date 2019/6/16
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 快慢指针法
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 因为第一个节点可能需要删除，所以需要在前面加一个虚拟节点
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        for (int i = 1; i <= n + 1; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
