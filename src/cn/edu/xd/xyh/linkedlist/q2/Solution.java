package cn.edu.xd.xyh.linkedlist.q2;

/**
 * @author LitheLight
 * @date 2019/7/5
 * https://leetcode.com/problems/add-two-numbers/
 * 正常相加，大于9则进位为1，最后循环结束记得再次判断进位是否为1
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = null;
        ListNode cur = res;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (sum > 9) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (res == null) {
                res = new ListNode(sum);
                cur = res;
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}