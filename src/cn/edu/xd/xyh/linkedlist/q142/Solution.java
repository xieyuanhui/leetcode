package cn.edu.xd.xyh.linkedlist.q142;

import cn.edu.xd.xyh.linkedlist.ListNode;

/**
 * @author LitheLight
 * @date 2019/7/5
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 快慢指针法，相遇之后慢指针回到原点，然后快慢指针速度变成一样，再次相遇就是环结点
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
