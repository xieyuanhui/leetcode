package cn.edu.xd.xyh.linkedlist.q234;

import cn.edu.xd.xyh.linkedlist.ListNode;

/**
 * @author LitheLight
 * @date 2019/6/14
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        /**
         * 跟前一题一样，断开链表，将链表分成两半
         */
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = null;
        ListNode tail = reverse(slow);
        return compareListNode(head, tail);
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 比较两个链表是否相同（这里是只比较前面共同长度部分，链表长度为奇数时中间的数不用比较）
     * @param l1
     * @param l2
     * @return
     */
    private boolean compareListNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return false;
        }
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}