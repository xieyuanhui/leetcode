package cn.edu.xd.xyh.linkedlist.q328;

import cn.edu.xd.xyh.linkedlist.ListNode;

/**
 * @author LitheLight
 * @date 2019/7/16
 * https://leetcode.com/problems/odd-even-linked-list/
 * 思路：
 * 注意偶数链表头的保存
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode even = head.next;
        ListNode tail = even;
        while (even != null && even.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            even.next = even.next.next;
            even = even.next;
        }
        cur.next = tail;
        return head;
    }
}
