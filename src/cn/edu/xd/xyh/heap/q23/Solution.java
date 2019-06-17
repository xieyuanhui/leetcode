package cn.edu.xd.xyh.heap.q23;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author LitheLight
 * @date 2019/6/17
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Solution {
    /**
     * 暴力解法，用ArrayList存储所有节点的值，排序之后拼接成一个新的链表返回
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        if (list.size() < 1) {
            return null;
        }
        Collections.sort(list);
        ListNode head = new ListNode(list.get(0));
        ListNode cur = head;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
