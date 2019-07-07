package cn.edu.xd.xyh.linkedlist.q141;

/**
 * @author LitheLight
 * @date 2019/7/5
 * https://leetcode.com/problems/linked-list-cycle/
 * 快慢指针法，如果有环会相遇，没有则不会
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
