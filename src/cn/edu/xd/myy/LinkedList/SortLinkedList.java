package cn.edu.xd.myy.LinkedList;
/**
 * https://leetcode.com/problems/sort-list/
 * q148
 * 以o(nlgn)时间复杂度 常量空间复杂度，排序链表
 */

public class SortLinkedList {
    /**
     * 找出链表的中间节点（利用快慢指针找出中间节点）
     * 递归排序左右子链表
     * 合并两个链表
     */

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = findmid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return mergeList(left,right);
    }

    public ListNode findmid(ListNode head){
        //例如五个节点，返回的是第二个节点；六个节点返回第三个节点； 返回的中间节点是第一段的最后一个结点;这样方面对原链表进行分割
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode left,ListNode right){
        if(left == null)
            return right;
        if(right == null)
            return left;
        ListNode result = new ListNode(0);
        ListNode res=result;
        while(left!= null && right != null){
            if(left.val <=right.val){
                res.next = left;
                left =left.next;
                res=res.next;
            }else{
                res.next =right;
                right = right.next;
                res=res.next;
            }
        }

        if(left!=null){
            res.next = left;
        }
        if(right!= null){
            res.next = right;
        }
        return result.next;
    }

}
