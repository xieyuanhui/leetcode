package cn.edu.xd.xyh.linkedlist.q21;

/**
 * @author LitheLight
 * @date 2019/6/14
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        // 因为需要保存最后的结果，所以需要一个游标节点
        ListNode cur = dummyNode;
        while (l1 != null || l2 != null) {
            // 拼接l1：l1的值小于等于l2的值或者l1不为空l2为空
            if ((l1 != null && l2 != null && l1.val <= l2.val) || (l1 != null && l2 == null)) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                // 拼接l2：l2的值小于l1的值或者l2不为空l1为空
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
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
