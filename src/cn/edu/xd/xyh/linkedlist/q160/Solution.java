package cn.edu.xd.xyh.linkedlist.q160;

import cn.edu.xd.xyh.linkedlist.ListNode;

/**
 * @author LitheLight
 * @date 2019/7/16
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 思路：
 * 假设链表A分为两段 a + c，链表B分为两段 b + c，c就是A B相同的那一段，
 * 由于 a + c + b + c = b + c + a + c,又由于 a + c + b = b + c + a，所以链表A B
 * 遍历完了之后再接上对方继续遍历，当走了相同长度之后就会到相同的那一段
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
