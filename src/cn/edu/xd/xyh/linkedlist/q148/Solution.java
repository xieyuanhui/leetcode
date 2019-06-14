package cn.edu.xd.xyh.linkedlist.q148;

/**
 * @author LitheLight
 * @date 2019/6/14
 * https://leetcode.com/problems/sort-list/
 * 因为时间复杂度要是O(nlogn)，所以使用归并排序的思路
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        /**
         * 将链表拆分成两半，用一个慢指针一次走一个节点，一个快指针走两个节点
         * 当快指针到了结尾的时候慢指针就走了一半，慢指针指向的就是后一半链表
         * 为了得到前一半链表，维护了一个指向慢指针前一个节点的指针，当快节点
         * 走完的时候，将这个指针的后面置为空节点，那么这个链表就断开了
         */
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    /**
     * 合并链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return l.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
